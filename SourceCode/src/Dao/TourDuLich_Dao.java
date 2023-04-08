package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ConnectDB.ConnectDB;
import Entity.DiaDiem;
import Entity.TourDuLich;

public class TourDuLich_Dao {
	public TourDuLich_Dao(){
		
	}
	public ArrayList<TourDuLich> getAllTour(){
		ArrayList<TourDuLich> dsTour = new ArrayList<TourDuLich>();
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TourDuLich";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				DiaDiem diemKH = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKH"));
				DiaDiem diemKT = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKT"));
				String[] array = rs.getString("Anh").split(";");
				List<String> list = Arrays.asList(array);
				ArrayList<String> dsAnh = new ArrayList<>(list);
				TourDuLich tour = new TourDuLich(rs.getString("MaTour"), rs.getString("TenTour"), rs.getString("MoTa"), rs.getInt("SoCho"), rs.getString("PhuongTien"), rs.getDate("NgayDi"), rs.getDate("NgayKetThuc"), diemKH, diemKT, rs.getString("KhachSan"), rs.getDouble("Gia"), dsAnh);
				dsTour.add(tour);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsTour;
	}
	public boolean addTour(TourDuLich x) {
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("insert into TourDuLich values(?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?)");
			stmt.setString(1, x.getMaTour());
			stmt.setString(2, x.getTenTour());
			stmt.setString(3, x.getMoTa());
			stmt.setInt(4, x.getSoCho());
			stmt.setString(5, x.getPhuongTien());
			stmt.setDate(6, x.getNgayDi());
			stmt.setDate(7, x.getNgayKetThuc());
			stmt.setString(8, x.getDiemKH().getMaDiaDiem());
			stmt.setString(9, x.getDiemDen().getMaDiaDiem());
			stmt.setString(10, x.getKhachSan());
			stmt.setDouble(11, x.getGia());
			String dsAnh = "";
			for(String str : x.getDsAnh())
				dsAnh+=str+";";
			stmt.setString(12, dsAnh);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n>0;
	}
	public boolean deleteTour(String maTour) {
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("delete from TourDuLich where MaTour = ?");
			stmt.setString(1, maTour);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean updateTour(TourDuLich tourNew) {
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("update TourDuLich Set "
										+ "TenTour = ? ,"
										+ "MoTa = ? ,"
										+ "SoCho = ? ,"
										+ "PhuongTien = ? ,"
										+ "NgayDi = ? ,"
										+ "NgayKetThuc = ? ,"
										+ "DiemKH = ? ,"
										+ "DiemKT = ? ,"
										+ "KhachSan = ? ,"
										+ "Gia = ? ,"
										+ "Anh = ? "
										+ "where MaTour = ? ");
			stmt.setString(1, tourNew.getTenTour());
			stmt.setString(2, tourNew.getMoTa());
			stmt.setInt(3, tourNew.getSoCho());
			stmt.setString(4, tourNew.getPhuongTien());
			stmt.setDate(5, tourNew.getNgayDi());
			stmt.setDate(6, tourNew.getNgayKetThuc());
			stmt.setString(7, tourNew.getDiemKH().getMaDiaDiem());
			stmt.setString(8, tourNew.getDiemDen().getMaDiaDiem());
			stmt.setString(9, tourNew.getKhachSan());
			stmt.setDouble(10, tourNew.getGia());
			String dsAnh = "";
			for(String str : tourNew.getDsAnh())
				dsAnh+=str+";";
			stmt.setString(11, dsAnh);
			stmt.setString(12, tourNew.getMaTour());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public static void main(String[] args) {
		for(TourDuLich x : new TourDuLich_Dao().getAllTour()) {
			System.out.println(x.getMaTour() + "|" + x.getTenTour() + "|" + x.getSoCho() + "|" + x.getDiemDen().getTenDiaDiem() + "|" + x.getDiemKH().getTenDiaDiem() + "|" + x.getNgayDi() + "|" + x.getNgayKetThuc());
		}
//		DiaDiem diemKH = new DiaDiem("DD01", "Gia Lai");
//		DiaDiem diemKT = new DiaDiem("DD04", "Phu Quoc");
//		ArrayList<String> dsAnh = new ArrayList<>();
//		dsAnh.add("hinh3.png");
//		dsAnh.add("hinh4.png");
//		TourDuLich tour = new TourDuLich("TN001", "Gia Lai - Phu Quoc", "abc", 40, "Xe khach", new Date(2023, 06, 1), new Date(2023, 06, 4), diemKH, diemKT, "Khach san 4 sao", 5444333.222, dsAnh);
//		if(new TourDuLich_Dao().addTour(tour)) {
//			System.out.println("Them thanh cong!");
//		}
//		if(new TourDuLich_Dao().deleteTour("TN001"))
//			System.out.println("Xoa thanh cong!");
//		DiaDiem diemKH = new DiaDiem("DD01", "Gia Lai");
//		DiaDiem diemKT = new DiaDiem("DD04", "Phu Quoc");
//		ArrayList<String> dsAnh = new ArrayList<>();
//		dsAnh.add("hinh3.png");
//		dsAnh.add("hinh4.png");
//		TourDuLich tour = new TourDuLich("TN001", "Gia Lai - Phu Quoc", "update mota", 50, "Xe khach", new Date(123, 06, 1), new Date(123, 06, 4), diemKH, diemKT, "Khach san 4 sao", 5444333.222, dsAnh);
//		if(new TourDuLich_Dao().updateTour(tour)) {
//			System.out.println("Sua thanh cong!");
//		}
	}
}
