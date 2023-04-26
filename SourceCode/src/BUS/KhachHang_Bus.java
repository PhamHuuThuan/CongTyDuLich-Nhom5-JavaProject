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
<<<<<<< HEAD
	public ArrayList<KhachHang> searchByAddress(String address) {
	    ArrayList<KhachHang> result = new ArrayList<>();
	    for (KhachHang kh : getAllKH()) {
	        if (kh.getDiaChi().equals(address)) {
	            result.add(kh);
	        }
	    }
	    return result;
=======
	public String getMaKHMax() {
		return khachHang_Dao.getMaKHMax();
>>>>>>> fcfc3dbd1647fbe39274aff664b0383b617ca6fa
	}
}
