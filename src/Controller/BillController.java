package Controller;

import Service.Service;

public class BillController {

	private Service service = new Service();

	public void revenue(int month, int year) {
		double total = service.getRevenue(month, year);
		System.out.println("Doanh thu: " + total);
	}
}
