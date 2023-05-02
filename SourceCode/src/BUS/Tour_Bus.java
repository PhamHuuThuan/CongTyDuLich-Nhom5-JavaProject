package BUS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Dao.KhachHang_Dao;
import Dao.TourDuLich_Dao;
import Entity.KhachHang;
import Entity.TourDuLich;

public class Tour_Bus {
	private TourDuLich_Dao tour_Dao = new TourDuLich_Dao();
	private KhachHang_Dao kh_Dao = new KhachHang_Dao();
	public ArrayList<TourDuLich> getTourGanNhat(){
		return tour_Dao.getTourGanNhat();
	}
	public ArrayList<TourDuLich> timTour(String maTim){
		return tour_Dao.timTour(maTim);
	}
	public TourDuLich timTourTheoMa(String maTim) {
		return tour_Dao.timTourTheoMa(maTim);
	}
	public ArrayList<TourDuLich> locTour(String diemDi, String diemDen, int soNgay, java.sql.Date date, int soNguoi,
			String phuongTien) {
		// TODO Auto-generated method stub
		return tour_Dao.locTour(diemDi, diemDen, soNgay, date, soNguoi, phuongTien);
	}
	public boolean deleteTour(String maTour) {
		TourDuLich tour = tour_Dao.timTour(maTour).get(0);
		boolean kq = tour_Dao.deleteTour(maTour);
		if(kq = true) {
			String filePath = tour.getDsAnh().get(0).substring(0, 9);
			File file = new File(filePath);
			deleteFolder(file);
		}
		return kq;
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
		if(kq) {
			luuImage(tour);
			tour_Dao.updateDSAnh(tour.getMaTour(), tour.getDsAnh());
//			sendEmail(tour);
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
	public void deleteFolder(File file){
	    for (File subFile : file.listFiles()) {
	       if(subFile.isDirectory()) {
	          deleteFolder(subFile);
	       } else {
	          subFile.delete();
	        }
	     }
	    file.delete();
	  }
	public void sendEmail(TourDuLich tour) {
		ArrayList<KhachHang> dsKH = kh_Dao.getAllKhachHang();
		Properties p = new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", 587);
		   
		Session s = Session.getInstance(p,
			new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("huuthuan1405@gmail.com", "bysgquqyuyocridd");
		}
		});
		  
		try {
			   for(KhachHang kh : dsKH) {
				   Message msg = new MimeMessage(s);
				   msg.setFrom(new InternetAddress("huuthuan1405@gmail.com"));
				   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(kh.getEmail()));
				   msg.setSubject("VIETOUR - ["+tour.getMaTour()+"] "+tour.getTenTour()+ " <<New Tour>>");
				   msg.setText("Xin chào "+ kh.getTenKH()+"!\n"
						   +"["+tour.getMaTour()+"] "+tour.getTenTour()+ " <<New Tour>>"
						   +"Mô tả: "+tour.getMoTa()+"\n"
						   +"Ngày khởi hành: "+tour.getNgayDi()+"\n"
						   +"Lịch trình: "+ tour.getDiemKH().getTenDiaDiem() +" - "+tour.getDiemDen().getTenDiaDiem()+"\n"
						   +"Phương tiện: "+tour.getPhuongTien().getTenPT()+"\n"
						   +"Hãy cùng VIETOUR khám phá ngay nào!");
				   Transport.send(msg);
			   }
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} 
	}
}
