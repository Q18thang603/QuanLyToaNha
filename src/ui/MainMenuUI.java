package ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainMenuUI extends JFrame {

	public MainMenuUI() {

		setTitle("HỆ THỐNG QUẢN LÝ NHÀ TRỌ");
		setSize(400, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(5, 1, 10, 10));

		JButton btnPhong = new JButton("Quản lý phòng");
		JButton btnNguoiThue = new JButton("Quản lý người thuê");
		JButton btnDienNuoc = new JButton("Nhập điện nước");
		JButton btnHoaDon = new JButton("Tạo hóa đơn");
		JButton btnDashboard = new JButton("Dashboard");

		add(btnPhong);
		add(btnNguoiThue);
		add(btnDienNuoc);
		add(btnHoaDon);
		add(btnDashboard);

		// MỞ CÁC FORM
		btnPhong.addActionListener(e -> {
			new PhongUI().setVisible(true);
		});

		btnNguoiThue.addActionListener(e -> {
			new NguoiThueUI().setVisible(true);
		});

		btnDienNuoc.addActionListener(e -> {
			new DienNuocUI().setVisible(true);
		});

		btnHoaDon.addActionListener(e -> {
			new HoaDonUI().setVisible(true);
		});

		btnDashboard.addActionListener(e -> {
			new DashboardUI().setVisible(true);
		});
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			new MainMenuUI().setVisible(true);
		});

	}
}