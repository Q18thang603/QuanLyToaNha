package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.PhongDAO;
import model.Phong;

public class PhongUI extends JFrame {

	JTable table;
	DefaultTableModel model;

	JTextField txtTenPhong;
	JTextField txtGia;
	JComboBox<String> cbTrangThai;

	PhongDAO dao = new PhongDAO();

	public PhongUI() {

		setTitle("Quản lý phòng");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// ===== FORM =====

		JPanel form = new JPanel(new GridLayout(2, 3));

		txtTenPhong = new JTextField();
		txtGia = new JTextField();
		cbTrangThai = new JComboBox<>(new String[] { "Trống", "Đã thuê" });

		form.add(new JLabel("Tên phòng"));
		form.add(new JLabel("Giá"));
		form.add(new JLabel("Trạng thái"));

		form.add(txtTenPhong);
		form.add(txtGia);
		form.add(cbTrangThai);

		add(form, BorderLayout.NORTH);

		// ===== TABLE =====

		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Tên phòng");
		model.addColumn("Giá");
		model.addColumn("Trạng thái");

		table = new JTable(model);

		JScrollPane sp = new JScrollPane(table);

		add(sp, BorderLayout.CENTER);

		// ===== BUTTON =====

		JPanel panel = new JPanel();

		JButton btnThem = new JButton("Thêm");
		JButton btnSua = new JButton("Sửa");
		JButton btnXoa = new JButton("Xóa");

		panel.add(btnThem);
		panel.add(btnSua);
		panel.add(btnXoa);

		add(panel, BorderLayout.SOUTH);

		// ===== LOAD DATA =====

		loadData();

		// ===== CLICK TABLE =====

		table.getSelectionModel().addListSelectionListener(e -> {

			int row = table.getSelectedRow();

			if (row >= 0) {

				txtTenPhong.setText(model.getValueAt(row, 1).toString());
				txtGia.setText(model.getValueAt(row, 2).toString());
				cbTrangThai.setSelectedItem(model.getValueAt(row, 3).toString());

			}

		});

		// ===== THÊM =====

		btnThem.addActionListener(e -> {

			Phong p = new Phong();

			p.setTenPhong(txtTenPhong.getText());
			p.setGiaPhong(Double.parseDouble(txtGia.getText()));
			p.setTrangThai(cbTrangThai.getSelectedItem().toString());

			dao.themPhong(p);

			loadData();

		});

		// ===== SỬA =====

		btnSua.addActionListener(e -> {

			int row = table.getSelectedRow();

			if (row == -1) {

				JOptionPane.showMessageDialog(this, "Chọn phòng cần sửa");
				return;

			}

			int id = Integer.parseInt(model.getValueAt(row, 0).toString());

			Phong p = new Phong();

			p.setIdPhong(id);
			p.setTenPhong(txtTenPhong.getText());
			p.setGiaPhong(Double.parseDouble(txtGia.getText()));
			p.setTrangThai(cbTrangThai.getSelectedItem().toString());

			dao.suaPhong(p);

			loadData();

		});

		// ===== XÓA =====

		btnXoa.addActionListener(e -> {

			int row = table.getSelectedRow();

			if (row == -1) {

				JOptionPane.showMessageDialog(this, "Chọn phòng cần xóa");
				return;

			}

			int id = Integer.parseInt(model.getValueAt(row, 0).toString());

			dao.xoaPhong(id);

			loadData();

		});

	}

	// ===== LOAD DATA =====

	private void loadData() {

		model.setRowCount(0);

		List<Phong> list = dao.getAllPhong();

		for (Phong p : list) {

			model.addRow(new Object[] { p.getIdPhong(), p.getTenPhong(), p.getGiaPhong(), p.getTrangThai() });

		}

	}
}