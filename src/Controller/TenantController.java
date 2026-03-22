package Controller;

import java.util.List;

import Model.Tenant;
import Service.Service;

public class TenantController {

	private Service service = new Service();

	public void showTenants() {
		service.getTenants().forEach(t -> System.out.println(t.getId() + " - " + t.getName()));
	}

	public void addTenant(String name, int roomId) {
		service.addTenant(new Tenant(0, name, "", "", roomId));
		System.out.println("Them nguoi thue thanh cong!");
	}

	public void updateTenant(int id, String name, int roomId) {
		service.updateTenant(new Tenant(id, name, "", "", roomId));
		System.out.println("Cap nhat thanh cong!");
	}

	public void deleteTenant(int id) {
		service.deleteTenant(id);
		System.out.println("Xoa thanh cong!");
	}

	public void searchTenant(String keyword) {
		List<String> list = service.searchTenant(keyword);
		list.forEach(System.out::println);
	}

	// TÌM THEO ID
	public void findTenantById(int id) {
		String result = service.findTenantById(id);
		System.out.println(result);
	}
}