package BUS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
	public boolean deleteTour(String maTour) {
		return tour_Dao.deleteTour(maTour);
	}
	public String getMaTourMax() {
		return tour_Dao.getMaTourMax();
	}
	public boolean updateTour(TourDuLich newTour) {
		boolean kq = tour_Dao.updateTour(newTour);
		if(kq == true) {
			luuImage(newTour);
			tour_Dao.updateDSAnh(newTour.getMaTour(), newTour.getDsAnh());
		}
		return kq;
	}
	public boolean addTour(TourDuLich tour) {
		boolean kq = tour_Dao.addTour(tour);
		if(kq == true) {
			luuImage(tour);
			tour_Dao.updateDSAnh(tour.getMaTour(), tour.getDsAnh());
		}
		return kq;
	}
	public void luuImage(TourDuLich tour) {
		for (String link : tour.getDsAnh()) {
			File sourceFile = new File(link);
		    File destinationDir = new File("Img/" + tour.getMaTour());
		    if (!destinationDir.exists()) {
		        destinationDir.mkdirs();
		    }
		    String destinationPath = destinationDir.getPath() + File.separator + sourceFile.getName();
		    try {
		        Files.copy(sourceFile.toPath(), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    tour.getDsAnh().set(tour.getDsAnh().indexOf(link), destinationPath);
		}
	}
}
