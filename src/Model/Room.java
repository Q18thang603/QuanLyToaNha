package Model;

public class Room {
	private int id;
	private String name;
	private double price;
	private String status;
	private int buildingId;

	public Room(int id, String name, double price, String status, int buildingId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.buildingId = buildingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
}
