package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.PhongDAO;

public class DashboardUI extends JFrame {

	private JTable table;
	private DefaultTableModel model;
	private JLabel lblPhongTrong;

	private PhongDAO phongDAO;

	public DashboardUI() {

		phongDAO = new PhongDAO();

		setTitle("Dashboard quản lý phòng");
		setSize(650, 400);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		// Label hiển thị phòng trống
		lblPhongTrong = new JLabel("Tổng phòng trống: ");
		lblPhongTrong.setFont(new Font("Arial", Font.BOLD, 16));
		lblPhongTrong.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		add(lblPhongTrong, BorderLayout.NORTH);

		// Table
		model = new DefaultTableModel();

		model.setColumnIdentifiers(new Object[] { "ID Phòng", "Tên Phòng", "Trạng Thái", "Người Thuê" });

		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);

		add(scrollPane, BorderLayout.CENTER);

		loadData();
	}

	private void loadData() {

		model.setRowCount(0);

		List<Object[]> list = phongDAO.getPhongVaNguoiThue();

		for (Object[] row : list) {
			model.addRow(row);
		}

		int phongTrong = phongDAO.demPhongTrong();

		lblPhongTrong.setText("Tổng phòng trống: " + phongTrong);
	}
}