package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.KetNoiMySQL;
import model.HoaDon;

public class HoaDonDAO {

	public void themHoaDon(HoaDon hd) {

		try {

			Connection conn = KetNoiMySQL.getConnection();

			String sql = "INSERT INTO hoa_don(id_phong, thang, nam, tien_phong, tien_dien, tien_nuoc, tong_tien) VALUES(?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, hd.getIdPhong());
			ps.setInt(2, hd.getThang());
			ps.setInt(3, hd.getNam());
			ps.setDouble(4, hd.getTienPhong());
			ps.setDouble(5, hd.getTienDien());
			ps.setDouble(6, hd.getTienNuoc());
			ps.setDouble(7, hd.getTongTien());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Lấy danh sách hóa đơn hiển thị bảng
	public List<Object[]> getDanhSachHoaDon() {

		List<Object[]> list = new ArrayList<>();

		try {

			Connection conn = KetNoiMySQL.getConnection();

			String sql = """
					SELECT
					    p.ten_phong,
					    nt.ten_nguoi,
					    hd.thang,
					    hd.nam,
					    hd.tien_phong,
					    hd.tien_dien,
					    hd.tien_nuoc,
					    hd.tong_tien
					FROM hoa_don hd
					JOIN phong p ON hd.id_phong = p.id_phong
					LEFT JOIN nguoi_thue nt ON nt.id_phong = p.id_phong
					""";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Object[] row = { rs.getString("ten_phong"), rs.getString("ten_nguoi"), rs.getInt("thang"),
						rs.getInt("nam"), rs.getDouble("tien_phong"), rs.getDouble("tien_dien"),
						rs.getDouble("tien_nuoc"), rs.getDouble("tong_tien") };

				list.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}