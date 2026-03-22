package Model;

public class Bill {
	private int id;
	private int roomId;
	private String date;
	private double roomFee, electricFee, waterFee;

	public Bill(int id, int roomId, String date, double r, double e, double w) {
		this.id = id;
		this.roomId = roomId;
		this.date = date;
		this.roomFee = r;
		this.electricFee = e;
		this.waterFee = w;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getRoomFee() {
		return roomFee;
	}

	public void setRoomFee(double roomFee) {
		this.roomFee = roomFee;
	}

	public double getElectricFee() {
		return electricFee;
	}

	public void setElectricFee(double electricFee) {
		this.electricFee = electricFee;
	}

	public double getWaterFee() {
		return waterFee;
	}

	public void setWaterFee(double waterFee) {
		this.waterFee = waterFee;
	}

	public double getTotal() {
		return roomFee + electricFee * 3500 + waterFee * 25;
	}

	public static double getRevenueByMonth(int month, int year) {
		// TODO Auto-generated method stub
		return 0;
	}
}
