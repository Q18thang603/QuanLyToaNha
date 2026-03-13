package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.KetNoiMySQL;
import model.Phong;

public class PhongDAO {

	private Connection conn;

	public PhongDAO() {
		conn = KetNoiMySQL.getConnection();
	}

	// =============================
	// LẤY DANH SÁCH PHÒNG
	// =============================
	public List<Phong> getAllPhong() {

		List<Phong> list = new ArrayList<>();

		try {

			String sql = "SELECT * FROM phong";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Phong p = new Phong();

				p.setIdPhong(rs.getInt("id_phong"));
				p.setTenPhong(rs.getString("ten_phong"));
				p.setGiaPhong(rs.getDouble("gia_phong"));
				p.setTrangThai(rs.getString("trang_thai"));

				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// =============================
	// THÊM PHÒNG
	// =============================
	public boolean themPhong(Phong p) {

		try {

			String sql = "INSERT INTO phong(ten_phong, gia_phong, trang_thai) VALUES (?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, p.getTenPhong());
			ps.setDouble(2, p.getGiaPhong());
			ps.setString(3, p.getTrangThai());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// =============================
	// SỬA PHÒNG
	// =============================
	public boolean suaPhong(Phong p) {

		try {

			String sql = "UPDATE phong SET ten_phong=?, gia_phong=?, trang_thai=? WHERE id_phong=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, p.getTenPhong());
			ps.setDouble(2, p.getGiaPhong());
			ps.setString(3, p.getTrangThai());
			ps.setInt(4, p.getIdPhong());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// =============================
	// XÓA PHÒNG
	// =============================
	public boolean xoaPhong(int idPhong) {

		try {

			String sql = "DELETE FROM phong WHERE id_phong=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, idPhong);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// =============================
	// DASHBOARD PHÒNG + NGƯỜI THUÊ
	// =============================
	public List<Object[]> getPhongVaNguoiThue() {

		List<Object[]> list = new ArrayList<>();

		try {

			String sql = """
					    SELECT p.id_phong,p.ten_phong,p.trang_thai,
					           IFNULL(n.ten_nguoi,'Chưa có')
					    FROM phong p
					    LEFT JOIN nguoi_thue n
					    ON p.id_phong=n.id_phong
					""";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Object[] row = { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) };

				list.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// =============================
	// ĐẾM PHÒNG TRỐNG
	// =============================
	public int demPhongTrong() {

		int count = 0;

		try {

			String sql = "SELECT COUNT(*) FROM phong WHERE trang_thai='Trống'";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
}