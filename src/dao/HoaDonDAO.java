package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.KetNoiMySQL;
import model.HoaDon;

public class HoaDonDAO {

	// lưu hóa đơn
	public void themHoaDon(HoaDon hd) {

		String sql = "INSERT INTO hoa_don(id_phong, thang, nam, tien_phong, tien_dien, tien_nuoc, tong_tien) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {

			Connection conn = KetNoiMySQL.getConnection();
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
}