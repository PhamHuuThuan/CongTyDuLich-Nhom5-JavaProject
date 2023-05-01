package BUS;

import java.util.ArrayList;

import Dao.DiaDiem_Dao;
import Entity.DiaDiem;

public class DiaDiem_Bus {
	DiaDiem_Dao dd_Dao = new DiaDiem_Dao();
	public ArrayList<DiaDiem> getAllDiemDi() {
		return dd_Dao.getAllDiemDi();
	}
	public ArrayList<DiaDiem> getAllDiemDuLich() {
		return dd_Dao.getAllDiemDuLich();
	}
	public boolean themDiaDiem(DiaDiem dd) {
		return dd_Dao.themDiaDiem(dd);
	}
	public boolean updateDiaDiem(DiaDiem dd) {
		return dd_Dao.updateDiaDiem(dd);
	}
	public boolean deleteDiaDiem(String maDiaDiem) {
        return dd_Dao.deleteDiaDiem(maDiaDiem);
    }
	public String getMaDDMaxKH() {
		return dd_Dao.getMaDDMaxKH();
	}
	public String getMaDDMaxDL() {
		return dd_Dao.getMaDDMaxDL();
	}
}
