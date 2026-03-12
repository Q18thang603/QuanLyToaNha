package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.KetNoiMySQL;
import model.Phong;

public class PhongDAO {

	// lấy danh sách phòng
	public List<Phong> layDanhSachPhong() {

		List<Phong> list = new ArrayList<>();

		String sql = "SELECT * FROM phong";

		try {

			Connection conn = KetNoiMySQL.getConnection();
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
}