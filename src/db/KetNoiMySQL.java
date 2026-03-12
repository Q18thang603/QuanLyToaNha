package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoiMySQL {
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3307/quanly_toanha";
			String user = "root";
			String password = "123456";

			Connection kn = DriverManager.getConnection(url, user, password);
			System.out.println("Kết nối thành công ");
			return kn;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
