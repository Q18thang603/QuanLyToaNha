package model;

public class DienNuoc {

	private int id;
	private int idPhong;
	private int thang;
	private int nam;
	private int soDien;
	private int soNuoc;

	public DienNuoc() {
	}

	public DienNuoc(int id, int idPhong, int thang, int nam, int soDien, int soNuoc) {
		this.id = id;
		this.idPhong = idPhong;
		this.thang = thang;
		this.nam = nam;
		this.soDien = soDien;
		this.soNuoc = soNuoc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public int getSoDien() {
		return soDien;
	}

	public void setSoDien(int soDien) {
		this.soDien = soDien;
	}

	public int getSoNuoc() {
		return soNuoc;
	}

	public void setSoNuoc(int soNuoc) {
		this.soNuoc = soNuoc;
	}
}