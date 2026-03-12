package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.KetNoiMySQL;
import model.NguoiThue;

public class NguoiThueDAO {

	// thêm người thuê
	public void themNguoiThue(NguoiThue nt) {

		String sql = "INSERT INTO nguoi_thue(ten_nguoi, so_dien_thoai, cccd, id_phong) VALUES (?, ?, ?, ?)";

		try {

			Connection conn = KetNoiMySQL.getConnection();
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

	// lấy danh sách người thuê
	public List<NguoiThue> layDanhSach() {

		List<NguoiThue> list = new ArrayList<>();

		String sql = "SELECT * FROM nguoi_thue";

		try {

			Connection conn = KetNoiMySQL.getConnection();
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