package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ConnectDB.ConnectDB;
import Entity.DiaDiem;
import Entity.PhuongTien;
import Entity.TourDuLich;

public class TourDuLich_Dao {
	public TourDuLich_Dao(){
		
	}
	public ArrayList<TourDuLich> getTourGanNhat(){
		ArrayList<TourDuLich> dsTour = new ArrayList<TourDuLich>();
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select top 5 * from TourDuLich t where (t.SoCho-ISNULL((select count(hd.MaTour)as soluong\r\n"
					+ "from HoaDon hd join ThanhVien tv ON hd.SoHoaDon = tv.MaHD\r\n"
					+ "where hd.MaTour = t.MaTour\r\n"
					+ "group by hd.MaTour), 0)) > 0 and NgayDi > getDate()\r\n"
					+ "order by t.NgayDi";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				DiaDiem diemKH = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKH"));
				DiaDiem diemKT = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKT"));
				String[] array = rs.getString("Anh").split(";");
				List<String> list = Arrays.asList(array);
				ArrayList<String> dsAnh = new ArrayList<>(list);
				TourDuLich tour = new TourDuLich(rs.getString("MaTour"), rs.getString("TenTour"), rs.getString("MoTa"), rs.getInt("SoCho"), new PhuongTien(rs.getString("PhuongTien")), rs.getDate("NgayDi"), rs.getDate("NgayKetThuc"), diemKH, diemKT, rs.getString("KhachSan"), rs.getDouble("Gia"), dsAnh);
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
			stmt.setString(5, x.getPhuongTien().getMaPT());
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
										+ "Gia = ? "
										+ "where MaTour = ? ");
			stmt.setString(1, tourNew.getTenTour());
			stmt.setString(2, tourNew.getMoTa());
			stmt.setInt(3, tourNew.getSoCho());
			stmt.setString(4, tourNew.getPhuongTien().getMaPT());
			stmt.setDate(5, tourNew.getNgayDi());
			stmt.setDate(6, tourNew.getNgayKetThuc());
			stmt.setString(7, tourNew.getDiemKH().getMaDiaDiem());
			stmt.setString(8, tourNew.getDiemDen().getMaDiaDiem());
			stmt.setString(9, tourNew.getKhachSan());
			stmt.setDouble(10, tourNew.getGia());
			stmt.setString(11, tourNew.getMaTour());
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
	public boolean updateDSAnh(String maTour, ArrayList<String> listAnh) {
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("update TourDuLich Set "
										+ "Anh = ? "
										+ "where MaTour = ? ");
			String dsAnh = "";
			for(String str : listAnh)
				dsAnh+=str+";";
			stmt.setString(1, dsAnh);
			stmt.setString(2, maTour);
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
	public ArrayList<TourDuLich> timTour(String maTim){
		ArrayList<TourDuLich> dsTour = new ArrayList<TourDuLich>();
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("select * from TourDuLich where MaTour like ? or TenTour like ?");
			stmt.setString(1, "%"+maTim+"%");
			stmt.setString(2, "%"+maTim+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				DiaDiem diemKH = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKH"));
				DiaDiem diemKT = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKT"));
				String[] array = rs.getString("Anh").split(";");
				List<String> list = Arrays.asList(array);
				ArrayList<String> dsAnh = new ArrayList<>(list);
				TourDuLich tour = new TourDuLich(rs.getString("MaTour"), rs.getString("TenTour"), rs.getString("MoTa"), rs.getInt("SoCho"), new PhuongTien(rs.getString("PhuongTien")), rs.getDate("NgayDi"), rs.getDate("NgayKetThuc"), diemKH, diemKT, rs.getString("KhachSan"), rs.getDouble("Gia"), dsAnh);
				dsTour.add(tour);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsTour;
	}
	public TourDuLich timTourTheoMa(String maTim){
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("select * from TourDuLich where MaTour = ?");
			stmt.setString(1, maTim);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				DiaDiem diemKH = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKH"));
				DiaDiem diemKT = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKT"));
				PhuongTien pt = new PhuongTien_Dao().timPhuongTien(rs.getString("PhuongTien"));
				String[] array = rs.getString("Anh").split(";");
				List<String> list = Arrays.asList(array);
				ArrayList<String> dsAnh = new ArrayList<>(list);
				TourDuLich tour = new TourDuLich(rs.getString("MaTour"), rs.getString("TenTour"), rs.getString("MoTa"), rs.getInt("SoCho"), pt, rs.getDate("NgayDi"), rs.getDate("NgayKetThuc"), diemKH, diemKT, rs.getString("KhachSan"), rs.getDouble("Gia"), dsAnh);
				return tour;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<TourDuLich> locTour(String diemDi, String diemDen, int soNgay, java.sql.Date ngayDi, int soNguoi, String phuongTien){
		ArrayList<TourDuLich> dsTour = new ArrayList<TourDuLich>();
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TourDuLich t\r\n"
					+ "		where (t.SoCho-ISNULL((select count(hd.MaTour)as soluong\r\n"
					+ "		from HoaDon hd join ThanhVien tv ON hd.SoHoaDon = tv.MaHD\r\n"
					+ "		where hd.MaTour = t.MaTour\r\n"
					+ "		group by hd.MaTour), 0)) >= ? and NgayDi >= ? and DiemKH like ? and DiemKT like ? \r\n"
					+ "		and PhuongTien like ? \r\n"
					+ "		and DATEDIFF(day, NgayDi, NgayKetThuc) = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, soNguoi);
			stmt.setDate(2, ngayDi);
			stmt.setString(3, "%"+diemDi+"%");
			stmt.setString(4, "%"+diemDen+"%");
			stmt.setString(5, "%"+phuongTien+"%");
			stmt.setInt(6, soNgay);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				DiaDiem diemKH = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKH"));
				DiaDiem diemKT = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKT"));
				String[] array = rs.getString("Anh").split(";");
				List<String> list = Arrays.asList(array);
				ArrayList<String> dsAnh = new ArrayList<>(list);
				TourDuLich tour = new TourDuLich(rs.getString("MaTour"), rs.getString("TenTour"), rs.getString("MoTa"), rs.getInt("SoCho"), new PhuongTien(rs.getString("PhuongTien")), rs.getDate("NgayDi"), rs.getDate("NgayKetThuc"), diemKH, diemKT, rs.getString("KhachSan"), rs.getDouble("Gia"), dsAnh);
				dsTour.add(tour);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsTour;
	}
	public String getMaTourMax() {
		String maTour = "";
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(MaTour) as MAX from TourDuLich");
			while(rs.next())
				maTour = rs.getString("MAX");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maTour;
	}
}
