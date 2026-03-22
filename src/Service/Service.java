package Service;

import java.util.List;

import Model.Room;
import Model.Tenant;
import Repository.BillRepository;
import Repository.RoomRepository;
import Repository.TenantRepository;

public class Service {

	RoomRepository roomRepo = new RoomRepository();
	TenantRepository tenantRepo = new TenantRepository();
	BillRepository billRepo = new BillRepository(); // ✅ thêm

	// ===== ROOM =====
	public List<Room> getRooms() {
		return roomRepo.findAll();
	}

	public void addRoom(Room r) {
		roomRepo.insert(r);
	}

	public void updateRoomStatus(int id, String s) {
		roomRepo.updateStatus(id, s);
	}

	public String getRoomStatus(int id) {
		return roomRepo.getStatus(id);
	}

	public int countRoom(String s) {
		return roomRepo.countByStatus(s);
	}

	// ===== TENANT =====
	public List<Tenant> getTenants() {
		return tenantRepo.findAll();
	}

	public void addTenant(Tenant t) {
		tenantRepo.insert(t);
	}

	public void updateTenant(Tenant t) {
		tenantRepo.update(t);
	}

	public void deleteTenant(int id) {
		tenantRepo.delete(id);
	}

	public List<String> searchTenant(String kw) {
		return tenantRepo.search(kw); // ✅ fix lỗi search
	}

	public String findTenantById(int id) {
		return tenantRepo.findById(id); // ✅ thêm
	}

	// ===== BILL =====
	public double getRevenue(int month, int year) {
		return billRepo.getRevenueByMonth(month, year); // ✅ fix lỗi chính
	}
}