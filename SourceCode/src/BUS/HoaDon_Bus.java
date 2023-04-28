package BUS;

import Dao.HoaDon_Dao;
import Entity.HoaDon;

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
}
