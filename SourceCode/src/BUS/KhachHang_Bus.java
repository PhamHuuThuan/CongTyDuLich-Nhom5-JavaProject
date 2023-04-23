package BUS;

import java.util.ArrayList;

import Dao.KhachHang_Dao;
import Entity.KhachHang;

public class KhachHang_Bus {
	KhachHang_Dao khachHang_Dao = new KhachHang_Dao();
	
	public ArrayList<KhachHang> getAllKH() {
		return khachHang_Dao.getAllKhachHang();
	}
	
	public boolean updateKhachHang(KhachHang kh) {
		return khachHang_Dao.updateKhachHang(kh);
	}
	public String getMaKHMax() {
		return khachHang_Dao.getMaKHMax();
	}
}
