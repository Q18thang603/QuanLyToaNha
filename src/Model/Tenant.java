package Model;

public class Tenant {
	private int id;
	private String name;
	private String phone;
	private String cccd;
	private int roomId;

	public Tenant(int id, String name, String phone, String cccd, int roomId) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.cccd = cccd;
		this.roomId = roomId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

}
