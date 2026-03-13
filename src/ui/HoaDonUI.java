package ui;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonDAO;
import model.HoaDon;

public class HoaDonUI extends JFrame {

	JTextField txtPhong, txtThang, txtNam;
	JTextField txtTienPhong;
	JTextField txtSoDien, txtSoNuoc;
	JTextField txtTong;

	JTable table;
	DefaultTableModel model;

	HoaDonDAO dao = new HoaDonDAO();

	public HoaDonUI() {

		setTitle("Quản lý hóa đơn");
		setSize(700, 600);
		setLayout(null);
		setLocationRelativeTo(null);

		JLabel l1 = new JLabel("ID Phòng");
		l1.setBounds(30, 30, 100, 25);
		add(l1);

		txtPhong = new JTextField();
		txtPhong.setBounds(130, 30, 120, 25);
		add(txtPhong);

		JLabel l2 = new JLabel("Tháng");
		l2.setBounds(30, 70, 100, 25);
		add(l2);

		txtThang = new JTextField();
		txtThang.setBounds(130, 70, 120, 25);
		add(txtThang);

		JLabel l3 = new JLabel("Năm");
		l3.setBounds(30, 110, 100, 25);
		add(l3);

		txtNam = new JTextField();
		txtNam.setBounds(130, 110, 120, 25);
		add(txtNam);

		JLabel l4 = new JLabel("Tiền phòng");
		l4.setBounds(30, 150, 100, 25);
		add(l4);

		txtTienPhong = new JTextField();
		txtTienPhong.setBounds(130, 150, 120, 25);
		add(txtTienPhong);

		JLabel l5 = new JLabel("Số điện");
		l5.setBounds(30, 190, 100, 25);
		add(l5);

		txtSoDien = new JTextField();
		txtSoDien.setBounds(130, 190, 120, 25);
		add(txtSoDien);

		JLabel l6 = new JLabel("Số nước");
		l6.setBounds(30, 230, 100, 25);
		add(l6);

		txtSoNuoc = new JTextField();
		txtSoNuoc.setBounds(130, 230, 120, 25);
		add(txtSoNuoc);

		JLabel l7 = new JLabel("Tổng tiền");
		l7.setBounds(30, 270, 100, 25);
		add(l7);

		txtTong = new JTextField();
		txtTong.setBounds(130, 270, 120, 25);
		txtTong.setEditable(false);
		add(txtTong);

		JButton btnTinh = new JButton("Tính & Lưu");
		btnTinh.setBounds(130, 310, 120, 30);
		add(btnTinh);

		model = new DefaultTableModel();

		model.setColumnIdentifiers(new Object[] { "Tên phòng", "Tên người thuê", "Tháng", "Năm", "Tiền phòng",
				"Tiền điện", "Tiền nước", "Tổng tiền" });

		table = new JTable(model);

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(20, 360, 650, 180);

		add(sp);

		btnTinh.addActionListener(e -> tinhTien());

		loadHoaDon();
	}

	private void tinhTien() {

		try {

			int phong = Integer.parseInt(txtPhong.getText());
			int thang = Integer.parseInt(txtThang.getText());
			int nam = Integer.parseInt(txtNam.getText());

			double tienPhong = Double.parseDouble(txtTienPhong.getText());

			int soDien = Integer.parseInt(txtSoDien.getText());
			int soNuoc = Integer.parseInt(txtSoNuoc.getText());

			double tienDien = soDien * 3500;
			double tienNuoc = soNuoc * 25000;

			double tong = tienPhong + tienDien + tienNuoc;

			txtTong.setText(String.valueOf(tong));

			HoaDon hd = new HoaDon();

			hd.setIdPhong(phong);
			hd.setThang(thang);
			hd.setNam(nam);
			hd.setTienPhong(tienPhong);
			hd.setTienDien(tienDien);
			hd.setTienNuoc(tienNuoc);
			hd.setTongTien(tong);

			dao.themHoaDon(hd);

			loadHoaDon();

			JOptionPane.showMessageDialog(this, "Lưu hóa đơn thành công");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
		}
	}

	private void loadHoaDon() {

		model.setRowCount(0);

		List<Object[]> list = dao.getDanhSachHoaDon();

		for (Object[] row : list) {

			model.addRow(row);
		}
	}
}