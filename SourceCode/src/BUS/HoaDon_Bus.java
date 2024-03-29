package BUS;

import java.util.ArrayList;

import Dao.HoaDon_Dao;
import Dao.ThanhVien_Dao;
import Dao.TourDuLich_Dao;
import Entity.HoaDon;
import Entity.NhanVien;
import Entity.ThanhVien;
import Entity.TourDuLich;

public class HoaDon_Bus {
	HoaDon_Dao hd_Dao = new HoaDon_Dao();
	public int getSoLuongKhach(String maTour) {
		return hd_Dao.soLuongDat(maTour);
	}
	public String getMaHoaDonMax() {
		return hd_Dao.getMaHoaDonMax();
	}
	public boolean themHoaDon(HoaDon hd) {
		return hd_Dao.themHoaDon(hd);
	}
	public boolean updateHoaDon(HoaDon hd) {
		return hd_Dao.updateHoaDon(hd);
	}
	public boolean deleteHoaDon(String soHoaDon) {
		return hd_Dao.deleteHoaDon(soHoaDon);
	}
	public TourDuLich tourMax() {
		return hd_Dao.tourMax();
	}
	public ArrayList<HoaDon> getHoaDonTheoSoDT(String SDT){
		return hd_Dao.getHoaDonTheoSoDT(SDT);
	}
	public ArrayList<HoaDon> getHoaDonTheoNhanVien(NhanVien nv){
		return hd_Dao.getHoaDonTheoNhanVien(nv);
	}
	public ArrayList<HoaDon> getHoaDonTheoNgayLap(java.sql.Date ngayLapHD){
		return hd_Dao.getHoaDonTheoNgayLap(ngayLapHD);
	}
	public ArrayList<HoaDon> getHoaDonTheoNhanVienVaNgayLap(NhanVien nv, java.sql.Date ngayLapHD){
		return hd_Dao.getHoaDonTheoNhanVienVaNgayLap(nv, ngayLapHD);
	}
	public double thanhTienByMonth(int month, int year) {
		double tongThanhTien = 0.0;
		ArrayList<HoaDon> dsHD = hd_Dao.tinhTongThanhTienByMonth(month, year);
		for(HoaDon hd : dsHD) {
			ArrayList<ThanhVien> dsTV = new ThanhVien_Dao().getThanhVienTheoMaHD(hd.getSoHoaDon());
			tongThanhTien += hd.getTour().getGia()*dsTV.size()*1.1;
		}
		return tongThanhTien;
	}
}
