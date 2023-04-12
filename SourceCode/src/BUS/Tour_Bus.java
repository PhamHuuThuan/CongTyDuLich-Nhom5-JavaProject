package BUS;

import java.util.ArrayList;
import java.util.Date;

import Dao.TourDuLich_Dao;
import Entity.TourDuLich;

public class Tour_Bus {
	TourDuLich_Dao tour_Dao = new TourDuLich_Dao();
	public ArrayList<TourDuLich> getTourGanNhat(){
		return tour_Dao.getTourGanNhat();
	}
	public ArrayList<TourDuLich> timTour(String maTim){
		return tour_Dao.timTour(maTim);
	}
	public ArrayList<TourDuLich> locTour(String diemDi, String diemDen, int soNgay, java.sql.Date date, int soNguoi,
			String phuongTien) {
		// TODO Auto-generated method stub
		return tour_Dao.locTour(diemDi, diemDen, soNgay, date, soNguoi, phuongTien);
	}
}
