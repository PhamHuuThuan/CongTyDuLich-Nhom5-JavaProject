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

import ConnectDB.ConnectDB;
import Entity.HoaDon;

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
				HoaDon hd = new HoaDon(soHD,ngayLap);
				dsHD.add(hd);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	public HoaDon getHoaDonTheoSoHD(String soHoaDon) throws ParseException {
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon where SoHoaDon like ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%"+soHoaDon+"%");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String soHD = rs.getString("SoHoaDon");
				java.sql.Timestamp ngayLap = rs.getTimestamp("NgayLapHD");
				HoaDon hd = new HoaDon(soHD,ngayLap);
				return hd;
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
		return null;
	}
	public boolean themHoaDon(HoaDon hd) {
		ConnectDB.getInstance();
		PreparedStatement statement = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			statement = con.prepareStatement("insert into HoaDon values(?, ?)");
			statement.setString(1, hd.getSoHoaDon());
			statement.setTimestamp(2, hd.getNgayTaoHD());
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
			stmt = con.prepareStatement("Update HoaDon Set NgayLapHD=? where SoHoaDon=?");
			stmt.setString(1, hd.getSoHoaDon());
			stmt.setTimestamp(2, hd.getNgayTaoHD());
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
}
