package model;

public class Phong {

	private int idPhong;
	private String tenPhong;
	private double giaPhong;
	private String trangThai;

	public Phong() {
	}

	public Phong(int idPhong, String tenPhong, double giaPhong, String trangThai) {
		this.idPhong = idPhong;
		this.tenPhong = tenPhong;
		this.giaPhong = giaPhong;
		this.trangThai = trangThai;
	}

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}