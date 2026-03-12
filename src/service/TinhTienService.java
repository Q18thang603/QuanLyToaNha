package service;

public class TinhTienService {

	// giá điện và nước (có thể thay đổi sau)
	private static final int GIA_DIEN = 3500;
	private static final int GIA_NUOC = 15000;

	// tính tiền điện
	public static double tinhTienDien(int dienThangTruoc, int dienThangSau) {

		int soDien = dienThangSau - dienThangTruoc;

		return soDien * GIA_DIEN;
	}

	// tính tiền nước
	public static double tinhTienNuoc(int nuocThangTruoc, int nuocThangSau) {

		int soNuoc = nuocThangSau - nuocThangTruoc;

		return soNuoc * GIA_NUOC;
	}

	// tính tổng tiền
	public static double tinhTongTien(double tienPhong, double tienDien, double tienNuoc) {

		return tienPhong + tienDien + tienNuoc;
	}
}