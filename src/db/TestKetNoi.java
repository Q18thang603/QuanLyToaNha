package db;

import java.sql.Connection;

public class TestKetNoi {
	public static void main(String[] args) {
		Connection kn = KetNoiMySQL.getConnection();
		if (kn != null) {
			System.out.println("Kết nối thành công ");
		} else {
			System.out.println("Kết nối thất bại ");
		}
	}
}
