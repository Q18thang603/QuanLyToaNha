package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.DienNuocDAO;
import model.DienNuoc;

public class DienNuocUI extends JFrame {

	JTextField txtPhong, txtThang, txtNam, txtDien, txtNuoc;

	DienNuocDAO dao = new DienNuocDAO();

	public DienNuocUI() {

		setTitle("Nhập điện nước");
		setSize(400, 350);
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

		JLabel l4 = new JLabel("Số điện");
		l4.setBounds(40, 160, 100, 25);
		add(l4);

		txtDien = new JTextField();
		txtDien.setBounds(140, 160, 150, 25);
		add(txtDien);

		JLabel l5 = new JLabel("Số nước");
		l5.setBounds(40, 200, 100, 25);
		add(l5);

		txtNuoc = new JTextField();
		txtNuoc.setBounds(140, 200, 150, 25);
		add(txtNuoc);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(140, 240, 100, 30);
		add(btnLuu);

		btnLuu.addActionListener(e -> luuDienNuoc());
	}

	private void luuDienNuoc() {

		DienNuoc dn = new DienNuoc();

		dn.setIdPhong(Integer.parseInt(txtPhong.getText()));
		dn.setThang(Integer.parseInt(txtThang.getText()));
		dn.setNam(Integer.parseInt(txtNam.getText()));
		dn.setSoDien(Integer.parseInt(txtDien.getText()));
		dn.setSoNuoc(Integer.parseInt(txtNuoc.getText()));

		dao.themDienNuoc(dn);

		JOptionPane.showMessageDialog(this, "Đã lưu");

	}
}