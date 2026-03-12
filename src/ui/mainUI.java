package ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class mainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtPhong;
	private JTable tableNguoiThue;

	DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainUI frame = new mainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Ten = new JLabel("Tên Người Thuê");
		Ten.setFont(new Font("Tahoma", Font.ITALIC, 14));
		Ten.setBounds(36, 78, 117, 17);
		contentPane.add(Ten);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ TÒA NHÀ");
		lblNewLabel.setBounds(165, 10, 300, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel);

		JLabel SDT = new JLabel("SDT");
		SDT.setFont(new Font("Tahoma", Font.ITALIC, 14));
		SDT.setBounds(36, 132, 117, 17);
		contentPane.add(SDT);

		JLabel Phong = new JLabel("Phòng");
		Phong.setFont(new Font("Tahoma", Font.ITALIC, 14));
		Phong.setBounds(36, 179, 117, 17);
		contentPane.add(Phong);

		txtTen = new JTextField();
		txtTen.setBounds(196, 74, 174, 29);
		contentPane.add(txtTen);

		txtSDT = new JTextField();
		txtSDT.setBounds(196, 128, 174, 29);
		contentPane.add(txtSDT);

		txtPhong = new JTextField();
		txtPhong.setBounds(196, 175, 174, 29);
		contentPane.add(txtPhong);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(95, 247, 84, 29);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(221, 247, 84, 29);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(343, 247, 84, 29);
		contentPane.add(btnXoa);

		JScrollPane NguoiThue = new JScrollPane();
		NguoiThue.setBounds(36, 300, 675, 208);
		contentPane.add(NguoiThue);

		tableNguoiThue = new JTable();
		tableNguoiThue.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Tên", "SDT", "Phòng" }));

		NguoiThue.setViewportView(tableNguoiThue);

		model = (DefaultTableModel) tableNguoiThue.getModel();

		// =========================
		// NÚT THÊM
		// =========================
		btnThem.addActionListener(e -> {

			String ten = txtTen.getText();
			String sdt = txtSDT.getText();
			String phong = txtPhong.getText();

			int id = model.getRowCount() + 1;

			model.addRow(new Object[] { id, ten, sdt, phong });

			txtTen.setText("");
			txtSDT.setText("");
			txtPhong.setText("");

		});

		// =========================
		// NÚT XÓA
		// =========================
		btnXoa.addActionListener(e -> {

			int row = tableNguoiThue.getSelectedRow();

			if (row != -1) {
				model.removeRow(row);
			}

		});

		// =========================
		// NÚT SỬA
		// =========================
		btnSua.addActionListener(e -> {

			int row = tableNguoiThue.getSelectedRow();

			if (row != -1) {

				model.setValueAt(txtTen.getText(), row, 1);
				model.setValueAt(txtSDT.getText(), row, 2);
				model.setValueAt(txtPhong.getText(), row, 3);

			}

		});

		// =========================
		// CLICK BẢNG -> HIỆN LÊN TEXTBOX
		// =========================
		tableNguoiThue.getSelectionModel().addListSelectionListener(e -> {

			int row = tableNguoiThue.getSelectedRow();

			if (row >= 0) {

				txtTen.setText(model.getValueAt(row, 1).toString());
				txtSDT.setText(model.getValueAt(row, 2).toString());
				txtPhong.setText(model.getValueAt(row, 3).toString());

			}

		});
	}
}