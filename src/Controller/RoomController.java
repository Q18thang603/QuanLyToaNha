package Controller;

import Model.Room;
import Service.Service;

public class RoomController {

	private Service service = new Service();

	public void showRooms() {
		service.getRooms().forEach(r -> System.out.println(r.getId() + " - " + r.getName() + " - " + r.getStatus()));
	}

	public void addRoom(String name, double price) {
		service.addRoom(new Room(0, name, price, "EMPTY", 1));
		System.out.println("Them phong thanh cong!");
	}

	public void showRoomStatus(int id) {
		System.out.println("Trang thai: " + service.getRoomStatus(id));
	}

	public void updateRoomStatus(int id, String status) {
		service.updateRoomStatus(id, status);
		System.out.println("Cap nhat thanh cong!");
	}

	public void statRoom() {
		int occupied = service.countRoom("OCCUPIED");
		int empty = service.countRoom("EMPTY");

		System.out.println("===== THONG KE =====");
		System.out.println("Dang thue: " + occupied);
		System.out.println("Con trong: " + empty);
	}
}