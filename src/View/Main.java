package View;

import java.util.Scanner;

import Controller.BillController;
import Controller.RoomController;
import Controller.TenantController;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		RoomController roomC = new RoomController();
		TenantController tenantC = new TenantController();
		BillController billC = new BillController();

		while (true) {
			System.out.println("\n===== QUAN LY TOA NHA =====");
			System.out.println("1. Quan ly phong");
			System.out.println("2. Quan ly nguoi thue");
			System.out.println("3. Doanh thu");
			System.out.println("4. Thong ke phong");
			System.out.println("0. Thoat");

			int c = sc.nextInt();

			switch (c) {

			case 1:
				System.out.println("1. Xem");
				System.out.println("2. Them");
				System.out.println("3. Trang thai");

				int r = sc.nextInt();

				if (r == 1) {
					roomC.showRooms();
				} else if (r == 2) {
					sc.nextLine();
					System.out.print("Ten: ");
					String name = sc.nextLine();
					System.out.print("Gia: ");
					double price = sc.nextDouble();
					roomC.addRoom(name, price);
				} else {
					System.out.print("ID: ");
					int id = sc.nextInt();
					roomC.showRoomStatus(id);
				}
				break;

			case 2:
				System.out.println("1. Xem");
				System.out.println("2. Them");
				System.out.println("3. Sua");
				System.out.println("4. Xoa");
				System.out.println("5. Tim");

				int t = sc.nextInt();

				if (t == 1) {
					tenantC.showTenants();
				} else if (t == 2) {
					sc.nextLine();
					System.out.print("Ten: ");
					String name = sc.nextLine();
					System.out.print("Room ID: ");
					int roomId = sc.nextInt();
					tenantC.addTenant(name, roomId);
				} else if (t == 3) {
					System.out.print("ID: ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.print("Ten moi: ");
					String name = sc.nextLine();
					System.out.print("Room ID: ");
					int roomId = sc.nextInt();
					tenantC.updateTenant(id, name, roomId);
				} else if (t == 4) {
					System.out.print("ID: ");
					int id = sc.nextInt();
					tenantC.deleteTenant(id);
				} else {
					sc.nextLine();
					System.out.print("Nhap ID nguoi thue: ");
					int id = sc.nextInt();
					tenantC.findTenantById(id);
				}
				break;

			case 3:
				System.out.print("Thang: ");
				int m = sc.nextInt();
				System.out.print("Nam: ");
				int y = sc.nextInt();
				billC.revenue(m, y);
				break;

			case 4:
				roomC.statRoom();
				break;

			case 0:
				return;
			}
		}
	}
}
