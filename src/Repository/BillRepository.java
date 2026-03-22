package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBConnection.DBConnection;

public class BillRepository {

	public double getRevenueByMonth(int month, int year) {
		double total = 0;

		try (Connection conn = DBConnection.getConnection()) {

			String sql = """
					    SELECT SUM(room_fee + electric_fee + water_fee) as total
					    FROM Bill
					    WHERE MONTH(bill_date) = ? AND YEAR(bill_date) = ?
					""";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, month);
			ps.setInt(2, year);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				total = rs.getDouble("total");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return total;
	}
}