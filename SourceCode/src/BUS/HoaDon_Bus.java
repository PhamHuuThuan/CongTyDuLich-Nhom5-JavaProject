package BUS;

import Dao.HoaDon_Dao;

public class HoaDon_Bus {
	HoaDon_Dao hd_Dao = new HoaDon_Dao();
	public int getSoLuongKhach(String maTour) {
		return hd_Dao.soLuongDat(maTour);
	}
	public String getMaHoaDonMax() {
		return hd_Dao.getMaHoaDonMax();
	}
}
