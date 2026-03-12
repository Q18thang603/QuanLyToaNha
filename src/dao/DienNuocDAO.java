package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.KetNoiMySQL;
import model.DienNuoc;

public class DienNuocDAO {

	// lưu điện nước
	public void themDienNuoc(DienNuoc dn) {

		String sql = "INSERT INTO dien_nuoc(id_phong, thang, nam, so_dien, so_nuoc) VALUES (?, ?, ?, ?, ?)";

		try {

			Connection conn = KetNoiMySQL.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, dn.getIdPhong());
			ps.setInt(2, dn.getThang());
			ps.setInt(3, dn.getNam());
			ps.setInt(4, dn.getSoDien());
			ps.setInt(5, dn.getSoNuoc());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}