package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.HoaDon;
import Entity.ThanhVien;

public class ThanhVien_Dao {
	public ThanhVien_Dao() {
		
	}
	public ArrayList<ThanhVien> getAllHoaDon(){
		ArrayList<ThanhVien> dsTV = new ArrayList<ThanhVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String query = "Select * from ThanhVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String maTV = rs.getString("MaTV");
				String tenTV = rs.getString("TenTV");
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				String ngaySinhStr = rs.getString("NgaySinh");
				Date ngaySinh = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhStr);
				boolean luaTuoi = rs.getBoolean("LuaTuoi");
				HoaDon hd = new HoaDon(rs.getString("MaHD"));
				ThanhVien tv = new ThanhVien(maTV, tenTV, gioiTinh, ngaySinh, luaTuoi, hd);
				dsTV.add(tv);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dsTV;
	}
	public ThanhVien getThanhVienTheoMa(String maThanhVien) throws ParseException {
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ThanhVien where MaTV like ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%"+maThanhVien+"%");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maTV = rs.getString("MaTV");
				String tenTV = rs.getString("TenTV");
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				String ngaySinhStr = rs.getString("NgaySinh");
				Date ngaySinh = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhStr);
				HoaDon hd = new HoaDon(rs.getString("MaHD"));
				ThanhVien tv = new ThanhVien(maTV, tenTV, gioiTinh, ngaySinh, gioiTinh, hd);
				return tv;
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
	public ArrayList<ThanhVien> getThanhVienTheoMaHD(String maHD){
		ArrayList<ThanhVien> dsTV = new ArrayList<>(); 
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ThanhVien where MaHD = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maTV = rs.getString("MaTV");
				String tenTV = rs.getString("TenTV");
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				Date ngaySinh = rs.getDate("NgaySinh");
				HoaDon hd = new HoaDon(rs.getString("MaHD"));
				ThanhVien tv = new ThanhVien(maTV, tenTV, gioiTinh, ngaySinh, gioiTinh, hd);
				dsTV.add(tv);
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
		return dsTV;
	}
	public boolean addThanhVien(ThanhVien tv) {
		ConnectDB.getInstance();
		PreparedStatement statement = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			statement = con.prepareStatement("insert into ThanhVien values(?, ?, ?, ?, ?, ?)");
			statement.setString(1, tv.getMaTV());
			statement.setString(2, tv.getHd().getSoHoaDon());
			statement.setString(3, tv.getTenTV());
			statement.setBoolean(4, tv.isGioiTinh());
			statement.setDate(5, tv.getNgaySinh());
			statement.setBoolean(6, tv.isLuaTuoi());
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
	public boolean updateThanhVien(ThanhVien tv) {
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("update ThanhVien Set "
										+ "TenTV = ? ,"
										+ "GioiTinh = ? ,"
										+ "NgaySinh = ? ,"
										+ "LuaTuoi = ? ,"
										+ "MaHD = ? "
										+ "where MaTV = ? ");
			stmt.setString(1, tv.getTenTV());
			stmt.setBoolean(2, tv.isGioiTinh());
			stmt.setDate(3, tv.getNgaySinh());
			stmt.setBoolean(4, tv.isLuaTuoi());
			stmt.setString(5, tv.getHd().getSoHoaDon());
			stmt.setString(6, tv.getMaTV());
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
	public boolean deleteThanhVien(String maThanhVien) {
		ConnectDB.getInstance();
		int n=0;
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("Delete from ThanhVien where MaTV=?");
			stmt.setString(1, maThanhVien);
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
	public String getMaxTVMax(){
		String maMax = null;
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select MAX(MaTV) as MAX from ThanhVien";
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
				maMax = rs.getString("MAX");
			return maMax;
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
}
