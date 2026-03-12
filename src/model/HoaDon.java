package model;

public class HoaDon {

	private int idHoaDon;
	private int idPhong;
	private int thang;
	private int nam;
	private double tienPhong;
	private double tienDien;
	private double tienNuoc;
	private double tongTien;

	public HoaDon() {
	}

	public HoaDon(int idHoaDon, int idPhong, int thang, int nam, double tienPhong, double tienDien, double tienNuoc,
			double tongTien) {

		this.idHoaDon = idHoaDon;
		this.idPhong = idPhong;
		this.thang = thang;
		this.nam = nam;
		this.tienPhong = tienPhong;
		this.tienDien = tienDien;
		this.tienNuoc = tienNuoc;
		this.tongTien = tongTien;
	}

	public int getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
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

	public double getTienPhong() {
		return tienPhong;
	}

	public void setTienPhong(double tienPhong) {
		this.tienPhong = tienPhong;
	}

	public double getTienDien() {
		return tienDien;
	}

	public void setTienDien(double tienDien) {
		this.tienDien = tienDien;
	}

	public double getTienNuoc() {
		return tienNuoc;
	}

	public void setTienNuoc(double tienNuoc) {
		this.tienNuoc = tienNuoc;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
}