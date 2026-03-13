package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.HoaDonDAO;
import model.HoaDon;

public class HoaDonUI extends JFrame {

	JTextField txtPhong, txtThang, txtNam, txtTienPhong, txtDien, txtNuoc, txtTong;

	HoaDonDAO dao = new HoaDonDAO();

	public HoaDonUI() {

		setTitle("Hóa đơn");
		setSize(400, 400);
		setLayout(null);
		setLocationRelativeTo(null);

		JLabel l1 = new JLabel("ID Phòng");
		l1.setBounds(40, 40, 100, 25);
		add(l1);

		txtPhong = new JTextField();
		txtPhong.setBounds(140, 40, 150, 25);
		add(txtPhong);

		JLabel l2 = new JLabel("Tháng");
		l2.setBounds(40, 80, 100, 25);
		add(l2);

		txtThang = new JTextField();
		txtThang.setBounds(140, 80, 150, 25);
		add(txtThang);

		JLabel l3 = new JLabel("Năm");
		l3.setBounds(40, 120, 100, 25);
		add(l3);

		txtNam = new JTextField();
		txtNam.setBounds(140, 120, 150, 25);
		add(txtNam);

		JLabel l4 = new JLabel("Tiền phòng");
		l4.setBounds(40, 160, 100, 25);
		add(l4);

		txtTienPhong = new JTextField();
		txtTienPhong.setBounds(140, 160, 150, 25);
		add(txtTienPhong);

		JLabel l5 = new JLabel("Tiền điện");
		l5.setBounds(40, 200, 100, 25);
		add(l5);

		txtDien = new JTextField();
		txtDien.setBounds(140, 200, 150, 25);
		add(txtDien);

		JLabel l6 = new JLabel("Tiền nước");
		l6.setBounds(40, 240, 100, 25);
		add(l6);

		txtNuoc = new JTextField();
		txtNuoc.setBounds(140, 240, 150, 25);
		add(txtNuoc);

		JButton btnTinh = new JButton("Tính tiền");
		btnTinh.setBounds(140, 280, 120, 30);
		add(btnTinh);

		txtTong = new JTextField();
		txtTong.setBounds(140, 320, 150, 25);
		add(txtTong);

		btnTinh.addActionListener(e -> tinhTien());
	}

	private void tinhTien() {

		double tong = Double.parseDouble(txtTienPhong.getText()) + Double.parseDouble(txtDien.getText())
				+ Double.parseDouble(txtNuoc.getText());

		txtTong.setText(String.valueOf(tong));

		HoaDon hd = new HoaDon();

		hd.setIdPhong(Integer.parseInt(txtPhong.getText()));
		hd.setThang(Integer.parseInt(txtThang.getText()));
		hd.setNam(Integer.parseInt(txtNam.getText()));
		hd.setTienPhong(Double.parseDouble(txtTienPhong.getText()));
		hd.setTienDien(Double.parseDouble(txtDien.getText()));
		hd.setTienNuoc(Double.parseDouble(txtNuoc.getText()));
		hd.setTongTien(tong);

		dao.themHoaDon(hd);

		JOptionPane.showMessageDialog(this, "Đã lưu hóa đơn");
	}
}