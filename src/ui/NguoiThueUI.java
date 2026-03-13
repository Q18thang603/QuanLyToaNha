package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.NguoiThueDAO;
import model.NguoiThue;

public class NguoiThueUI extends JFrame {

	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtCCCD;
	private JTextField txtPhong;

	private JTable table;
	private DefaultTableModel model;

	private NguoiThueDAO dao = new NguoiThueDAO();

	public NguoiThueUI() {

		setTitle("Quản lý người thuê");
		setSize(650, 500);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel lbTen = new JLabel("Tên người thuê");
		lbTen.setBounds(40, 40, 120, 25);
		add(lbTen);

		JLabel lbSDT = new JLabel("SĐT");
		lbSDT.setBounds(40, 80, 120, 25);
		add(lbSDT);

		JLabel lbCCCD = new JLabel("CCCD");
		lbCCCD.setBounds(40, 120, 120, 25);
		add(lbCCCD);

		JLabel lbPhong = new JLabel("ID Phòng");
		lbPhong.setBounds(40, 160, 120, 25);
		add(lbPhong);

		txtTen = new JTextField();
		txtTen.setBounds(150, 40, 180, 25);
		add(txtTen);

		txtSDT = new JTextField();
		txtSDT.setBounds(150, 80, 180, 25);
		add(txtSDT);

		txtCCCD = new JTextField();
		txtCCCD.setBounds(150, 120, 180, 25);
		add(txtCCCD);

		txtPhong = new JTextField();
		txtPhong.setBounds(150, 160, 180, 25);
		add(txtPhong);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(400, 40, 100, 30);
		add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(400, 80, 100, 30);
		add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(400, 120, 100, 30);
		add(btnXoa);

		model = new DefaultTableModel();

		model.setColumnIdentifiers(new Object[] { "ID", "Tên", "SĐT", "CCCD", "Phòng" });

		table = new JTable(model);

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(40, 220, 550, 200);

		add(sp);

		loadTable();

		btnThem.addActionListener(e -> themNguoi());

		btnSua.addActionListener(e -> suaNguoi());

		btnXoa.addActionListener(e -> xoaNguoi());

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();

				txtTen.setText(model.getValueAt(row, 1).toString());
				txtSDT.setText(model.getValueAt(row, 2).toString());
				txtCCCD.setText(model.getValueAt(row, 3).toString());
				txtPhong.setText(model.getValueAt(row, 4).toString());
			}
		});

	}

	private void loadTable() {

		model.setRowCount(0);

		List<NguoiThue> list = dao.layDanhSach();

		for (NguoiThue nt : list) {

			model.addRow(new Object[] { nt.getIdNguoi(), nt.getTenNguoi(), nt.getSoDienThoai(), nt.getCccd(),
					nt.getIdPhong() });

		}
	}

	private void themNguoi() {

		try {

			NguoiThue nt = new NguoiThue();

			nt.setTenNguoi(txtTen.getText());
			nt.setSoDienThoai(txtSDT.getText());
			nt.setCccd(txtCCCD.getText());
			nt.setIdPhong(Integer.parseInt(txtPhong.getText()));

			dao.themNguoiThue(nt);

			loadTable();

			JOptionPane.showMessageDialog(this, "Thêm thành công");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
		}

	}

	private void suaNguoi() {

		int row = table.getSelectedRow();

		if (row == -1) {

			JOptionPane.showMessageDialog(this, "Chọn người cần sửa");
			return;
		}

		int id = Integer.parseInt(model.getValueAt(row, 0).toString());

		NguoiThue nt = new NguoiThue();

		nt.setIdNguoi(id);
		nt.setTenNguoi(txtTen.getText());
		nt.setSoDienThoai(txtSDT.getText());
		nt.setCccd(txtCCCD.getText());
		nt.setIdPhong(Integer.parseInt(txtPhong.getText()));

		dao.suaNguoiThue(nt);

		loadTable();

		JOptionPane.showMessageDialog(this, "Sửa thành công");

	}

	private void xoaNguoi() {

		int row = table.getSelectedRow();

		if (row == -1) {

			JOptionPane.showMessageDialog(this, "Chọn người cần xóa");
			return;
		}

		int id = Integer.parseInt(model.getValueAt(row, 0).toString());

		dao.xoaNguoiThue(id);

		loadTable();

		JOptionPane.showMessageDialog(this, "Xóa thành công");

	}

}