package model;

public class NguoiThue {

	private int idNguoi;
	private String tenNguoi;
	private String soDienThoai;
	private String cccd;
	private int idPhong;

	public NguoiThue() {
	}

	public NguoiThue(int idNguoi, String tenNguoi, String soDienThoai, String cccd, int idPhong) {
		this.idNguoi = idNguoi;
		this.tenNguoi = tenNguoi;
		this.soDienThoai = soDienThoai;
		this.cccd = cccd;
		this.idPhong = idPhong;
	}

	public int getIdNguoi() {
		return idNguoi;
	}

	public void setIdNguoi(int idNguoi) {
		this.idNguoi = idNguoi;
	}

	public String getTenNguoi() {
		return tenNguoi;
	}

	public void setTenNguoi(String tenNguoi) {
		this.tenNguoi = tenNguoi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}
}