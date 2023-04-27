package BUS;

import Dao.NhanVien_Dao;
import Entity.NhanVien;

public class NhanVien_Bus {
	NhanVien_Dao nhanvien_dao = new NhanVien_Dao();
	public boolean updateNhanVien(NhanVien nv) {
		return nhanvien_dao.updateNhanVien(nv);
	}
}
