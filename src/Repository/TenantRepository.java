package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Model.Tenant;

public class TenantRepository {

	public List<Tenant> findAll() {
		List<Tenant> list = new ArrayList<>();
		try (Connection conn = DBConnection.getConnection()) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Tenant");

			while (rs.next()) {
				list.add(new Tenant(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("cccd"),
						rs.getInt("room_id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insert(Tenant t) {
		try (Connection conn = DBConnection.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Tenant(name,phone,cccd,room_id) VALUES (?,?,?,?)");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getCccd());
			ps.setInt(4, t.getRoomId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Tenant t) {
		try (Connection conn = DBConnection.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Tenant SET name=?, phone=?, cccd=?, room_id=? WHERE id=?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getCccd());
			ps.setInt(4, t.getRoomId());
			ps.setInt(5, t.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try (Connection conn = DBConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Tenant WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TÌM THEO ID
	public String findById(int id) {
		String result = "Không tìm thấy người thuê!";

		try (Connection conn = DBConnection.getConnection()) {

			String sql = """
					SELECT t.name, t.phone, r.name AS room
					FROM Tenant t
					LEFT JOIN Room r ON t.room_id = r.id
					WHERE t.id = ?
					""";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getString("name") + " - SĐT: " + rs.getString("phone") + " - Phòng: "
						+ rs.getString("room");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}