package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.KetNoiMySQL;
import model.NguoiThue;

public class NguoiThueDAO {

	public void themNguoiThue(NguoiThue nt) {

		try {

			Connection conn = KetNoiMySQL.getConnection();

			String sql = "INSERT INTO nguoi_thue(ten_nguoi, so_dien_thoai, cccd, id_phong) VALUES (?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, nt.getTenNguoi());
			ps.setString(2, nt.getSoDienThoai());
			ps.setString(3, nt.getCccd());
			ps.setInt(4, nt.getIdPhong());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void suaNguoiThue(NguoiThue nt) {

		try {

			Connection conn = KetNoiMySQL.getConnection();

			String sql = "UPDATE nguoi_thue SET ten_nguoi=?, so_dien_thoai=?, cccd=?, id_phong=? WHERE id_nguoi=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, nt.getTenNguoi());
			ps.setString(2, nt.getSoDienThoai());
			ps.setString(3, nt.getCccd());
			ps.setInt(4, nt.getIdPhong());
			ps.setInt(5, nt.getIdNguoi());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoaNguoiThue(int id) {

		try {

			Connection conn = KetNoiMySQL.getConnection();

			String sql = "DELETE FROM nguoi_thue WHERE id_nguoi=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<NguoiThue> layDanhSach() {

		List<NguoiThue> list = new ArrayList<>();

		try {

			Connection conn = KetNoiMySQL.getConnection();

			String sql = "SELECT * FROM nguoi_thue";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				NguoiThue nt = new NguoiThue();

				nt.setIdNguoi(rs.getInt("id_nguoi"));
				nt.setTenNguoi(rs.getString("ten_nguoi"));
				nt.setSoDienThoai(rs.getString("so_dien_thoai"));
				nt.setCccd(rs.getString("cccd"));
				nt.setIdPhong(rs.getInt("id_phong"));

				list.add(nt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}