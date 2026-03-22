package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Model.Room;

public class RoomRepository {

	// 1. Lấy tất cả phòng
	public List<Room> findAll() {
		List<Room> list = new ArrayList<>();
		String sql = "SELECT * FROM Room";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Room r = new Room(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("status"),
						rs.getInt("building_id"));
				list.add(r);
			}

		} catch (Exception e) {
			System.out.println("Lỗi findAll:");
			e.printStackTrace();
		}
		return list;
	}

	// 2. Thêm phòng
	public boolean insert(Room r) {
		String sql = "INSERT INTO Room(name, price, status, building_id) VALUES (?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, r.getName());
			ps.setDouble(2, r.getPrice());
			ps.setString(3, r.getStatus());
			ps.setInt(4, r.getBuildingId());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			System.out.println("Lỗi insert:");
			e.printStackTrace();
		}
		return false;
	}

	// 3. Cập nhật trạng thái
	public boolean updateStatus(int id, String status) {
		String sql = "UPDATE Room SET status = ? WHERE id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, status);
			ps.setInt(2, id);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			System.out.println("Lỗi updateStatus:");
			e.printStackTrace();
		}
		return false;
	}

	// 4. Lấy trạng thái theo id
	public String getStatus(int id) {
		String sql = "SELECT status FROM Room WHERE id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getString("status");
				}
			}

		} catch (Exception e) {
			System.out.println("Lỗi getStatus:");
			e.printStackTrace();
		}
		return "Not found";
	}

	// 5. Đếm theo trạng thái
	public int countByStatus(String status) {
		String sql = "SELECT COUNT(*) FROM Room WHERE status = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, status);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}

		} catch (Exception e) {
			System.out.println("Lỗi countByStatus:");
			e.printStackTrace();
		}
		return 0;
	}
}