package Dao;

import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ConnectDB.ConnectDB;
import Entity.DiaDiem;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhuongTien;
import Entity.TourDuLich;

public class HoaDon_Dao {
	public HoaDon_Dao() {
		
	}
	public ArrayList<HoaDon> getAllHoaDon(){
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String query = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String soHD = rs.getString("SoHoaDon");
				java.sql.Timestamp ngayLap = rs.getTimestamp("NgayLapHD");
				HoaDon hd = new HoaDon(soHD,ngayLap, new TourDuLich(rs.getString("MaTour")),new NhanVien(rs.getString("MaNV")));
				dsHD.add(hd);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	public ArrayList<HoaDon> getHoaDonTheoSoDT(String SDT){
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon hd "
					+ "join KhachHang kh on hd.MaKH = kh.MaKH "
					+ "join TourDuLich t on hd.MaTour = t.MaTour "
					+ "join NhanVien nv on hd.MaNV = nv.MaNV "
					+ "where kh.SDT = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, SDT);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String soHD = rs.getString("SoHoaDon");
				java.sql.Timestamp ngayLap = rs.getTimestamp("NgayLapHD");
				TourDuLich tour = new TourDuLich_Dao().timTourTheoMa(rs.getString("MaTour"));
				NhanVien nv = new NhanVien(rs.getString("MaNV"),rs.getString("TenNV"));
				KhachHang kh = new KhachHang(rs.getString("MaKH"),rs.getString("SDT"),rs.getString("TenKH"),rs.getString("Email"),rs.getString("DiaChi"));
				HoaDon hd = new HoaDon(soHD,ngayLap, tour , nv, kh);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dsHD;
	}
	public ArrayList<HoaDon> getHoaDonTheoNhanVien(NhanVien nv){
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon hd \r\n"
					+ "join KhachHang kh on hd.MaKH = kh.MaKH \r\n"
					+ "join TourDuLich t on hd.MaTour = t.MaTour \r\n"
					+ "join NhanVien nv on hd.MaNV = nv.MaNV \r\n"
					+ "where nv.MaNV = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, nv.getMaNV());
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String soHD = rs.getString("SoHoaDon");
				java.sql.Timestamp ngayLap = rs.getTimestamp("NgayLapHD");
				TourDuLich tour = new TourDuLich_Dao().timTourTheoMa(rs.getString("MaTour"));
				KhachHang kh = new KhachHang(rs.getString("MaKH"),rs.getString("SDT"),rs.getString("TenKH"),rs.getString("Email"),rs.getString("DiaChi"));
				HoaDon hd = new HoaDon(soHD,ngayLap, tour , nv, kh);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dsHD;
	}
	public ArrayList<HoaDon> getHoaDonTheoNgayLap(java.sql.Date ngayLapHD){
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon hd \r\n"
					+ "join KhachHang kh on hd.MaKH = kh.MaKH \r\n"
					+ "join TourDuLich t on hd.MaTour = t.MaTour \r\n"
					+ "join NhanVien nv on hd.MaNV = nv.MaNV \r\n"
					+ "where CAST(hd.NgayLapHD AS date)  = ?";
			statement = con.prepareStatement(sql);
			statement.setDate(1, ngayLapHD);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String soHD = rs.getString("SoHoaDon");
				java.sql.Timestamp ngayLap = rs.getTimestamp("NgayLapHD");
				TourDuLich tour = new TourDuLich_Dao().timTourTheoMa(rs.getString("MaTour"));
				NhanVien nv = new NhanVien(rs.getString("MaNV"),rs.getString("TenNV"));
				KhachHang kh = new KhachHang(rs.getString("MaKH"),rs.getString("SDT"),rs.getString("TenKH"),rs.getString("Email"),rs.getString("DiaChi"));
				HoaDon hd = new HoaDon(soHD,ngayLap, tour , nv, kh);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dsHD;
	}
	public ArrayList<HoaDon> getHoaDonTheoNhanVienVaNgayLap(NhanVien nv, java.sql.Date ngayLapHD){
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon hd \r\n"
					+ "join KhachHang kh on hd.MaKH = kh.MaKH \r\n"
					+ "join TourDuLich t on hd.MaTour = t.MaTour \r\n"
					+ "join NhanVien nv on hd.MaNV = nv.MaNV \r\n"
					+ "where hd.MaNV = ? and\r\n"
					+ "CAST(hd.NgayLapHD AS date)  = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, nv.getMaNV());
			statement.setDate(2, ngayLapHD);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String soHD = rs.getString("SoHoaDon");
				java.sql.Timestamp ngayLap = rs.getTimestamp("NgayLapHD");
				TourDuLich tour = new TourDuLich_Dao().timTourTheoMa(rs.getString("MaTour"));
				KhachHang kh = new KhachHang(rs.getString("MaKH"),rs.getString("SDT"),rs.getString("TenKH"),rs.getString("Email"),rs.getString("DiaChi"));
				HoaDon hd = new HoaDon(soHD,ngayLap, tour , nv, kh);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dsHD;
	}
	public boolean themHoaDon(HoaDon hd) {
		ConnectDB.getInstance();
		PreparedStatement statement = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			statement = con.prepareStatement("insert into HoaDon values(?, ?, ?, ?, ?)");
			statement.setString(1, hd.getSoHoaDon());
			if(hd.getKh()!=null)
				statement.setString(2, hd.getKh().getMaKH());
			else
				statement.setString(2, null);
			if(hd.getTour()!=null)
				statement.setString(3, hd.getTour().getMaTour());
			else
				statement.setString(3, null);
			statement.setTimestamp(4, hd.getNgayTaoHD());
			statement.setString(5, hd.getNv().getMaNV());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean updateHoaDon(HoaDon hd) {
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("Update HoaDon Set MaKH=?, MaTour=?, NgayLapHD=?, MaNV=? where SoHoaDon=?");
			stmt.setString(1, hd.getKh().getMaKH());
			stmt.setString(2, hd.getTour().getMaTour());
			stmt.setTimestamp(3, hd.getNgayTaoHD());
			stmt.setString(4, hd.getNv().getMaNV());
			stmt.setString(5, hd.getSoHoaDon());
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
	public boolean deleteHoaDon(String soHoaDon) {
		ConnectDB.getInstance();
		int n=0;
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("Delete from HoaDon where SoHoaDon=?");
			stmt.setString(1, soHoaDon);
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
	public int soLuongDat(String maTour) {
		int soLuongDat = 0;
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("select count(hd.MaTour) as soluong\r\n"
					+ "from HoaDon hd join ThanhVien tv ON hd.SoHoaDon = tv.MaHD\r\n"
					+ "where MaTour = ?\r\n"
					+ "group by hd.MaTour");
			stmt.setString(1, maTour);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				soLuongDat = rs.getInt("soluong");
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
		return soLuongDat;
	}
	public String getMaHoaDonMax(){
		String maHDMax = "";
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(SoHoaDon) as MAX from HoaDon");
			while(rs.next())
				maHDMax = rs.getString("MAX");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maHDMax;
	}
	public TourDuLich tourMax() {
	    ConnectDB.getInstance();
	    PreparedStatement stmt = null;
	    TourDuLich maxTour = null;
	    int maxSoLuongDat = -1;

	    try {
	        Connection con = ConnectDB.getConnection();
	        stmt = con.prepareStatement("select * from TourDuLich");
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            String maTour = rs.getString("MaTour");
	            int soLuongDat = soLuongDat(maTour);

	            if (soLuongDat > maxSoLuongDat) {
	                maxSoLuongDat = soLuongDat;
	                DiaDiem diemKH = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKH"));
					DiaDiem diemKT = new DiaDiem_Dao().getDiaDiemTheoMa(rs.getString("DiemKT"));
					String[] array = rs.getString("Anh").split(";");
					List<String> list = Arrays.asList(array);
					ArrayList<String> dsAnh = new ArrayList<>(list);
					maxTour = new TourDuLich(rs.getString("MaTour"), rs.getString("TenTour"), rs.getString("MoTa"), rs.getInt("SoCho"), new PhuongTien(rs.getString("PhuongTien")), rs.getDate("NgayDi"), rs.getDate("NgayKetThuc"), diemKH, diemKT, rs.getString("KhachSan"), rs.getDouble("Gia"), dsAnh);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return maxTour;
	}
	public double tinhTongThanhTienByMonth(int month, int year) {
	    double tongThanhTien = 0.0;
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String query = "SELECT MaTour FROM HoaDon WHERE MONTH(NgayLapHD) = ? AND YEAR(NgayLapHD) = ?";
	        PreparedStatement statement = con.prepareStatement(query);
	        statement.setInt(1, month);
	        statement.setInt(2, year);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            String maTour = rs.getString("MaTour");
	            int soLuongDat = soLuongDat(maTour);
	            TourDuLich tour = new TourDuLich_Dao().timTourTheoMa(maTour);
	            double thanhTien = tour.getGia() * soLuongDat;
	            tongThanhTien += thanhTien;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return tongThanhTien;
	}

}
