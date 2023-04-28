package BUS;

import java.util.ArrayList;

import Dao.PhuongTien_Dao;
import Entity.PhuongTien;

public class PhuongTien_Bus {
	PhuongTien_Dao pt_Dao = new PhuongTien_Dao();
	
	public ArrayList<PhuongTien> getAllPhuongTien() {
		return pt_Dao.getAllPhuongTien();
	}
	public String getMaPTMax() {
		return pt_Dao.getMaPTMax();
	}
	public boolean themPhuongTien(PhuongTien pt) {
		return pt_Dao.themPhuongTien(pt);
	}
	public boolean updatePhuongTien(PhuongTien pt) {
		return pt_Dao.updatePhuongTien(pt);
	}
	public boolean deletePhuongTien(String maPhuongTien) {
        return pt_Dao.deletePhuongTien(maPhuongTien);
    }
	public PhuongTien timPhuongTien(String maPT) {
		return pt_Dao.timPhuongTien(maPT);
	}
}
