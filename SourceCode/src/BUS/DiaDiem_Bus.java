package BUS;

import java.util.ArrayList;

import Dao.DiaDiem_Dao;
import Entity.DiaDiem;
import Entity.TourDuLich;

public class DiaDiem_Bus {
	DiaDiem_Dao dd_Dao = new DiaDiem_Dao();
	public ArrayList<DiaDiem> getAllDiemDi() {
		return dd_Dao.getAllDiemDi();
	}
	public ArrayList<DiaDiem> getAllDiemDuLich() {
		return dd_Dao.getAllDiemDuLich();
	}
	
}
