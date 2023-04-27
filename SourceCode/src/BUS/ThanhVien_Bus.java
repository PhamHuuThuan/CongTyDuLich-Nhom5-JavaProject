package BUS;

import java.text.ParseException;

import Dao.ThanhVien_Dao;
import Entity.ThanhVien;

public class ThanhVien_Bus {
	private ThanhVien_Dao tvDao = new ThanhVien_Dao();
	public String getMaTVMax(){
		return tvDao.getMaxTVMax();
	}
	public boolean addThanhVien(ThanhVien tv) {
		return tvDao.addThanhVien(tv);
	}
}