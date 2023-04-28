package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.PhuongTien;

public class PhuongTien_Dao {
	public PhuongTien_Dao() {
		
	}
	
	public ArrayList<PhuongTien> getAllPhuongTien() {
		ArrayList<PhuongTien> dsPT = new ArrayList<PhuongTien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String query = "Select * from PhuongTien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String maPT = rs.getString("MaPhuongTien");
				String tenPT = rs.getString("PhuongTien");
				PhuongTien pt = new PhuongTien(maPT,tenPT);
				dsPT.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPT;
	}
	
	public String getMaPTMax() {
		String maPT = "";
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(MaPhuongTien) as MAX from PhuongTien");
			while(rs.next())
				maPT = rs.getString("MAX");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maPT;
	}
	
	public boolean themPhuongTien(PhuongTien dd) {
	    ConnectDB.getInstance();
	    PreparedStatement statement = null;
	    int n = 0;
	    try {
	        Connection con = ConnectDB.getConnection();
	        statement = con.prepareStatement("insert into PhuongTien values(?, ?)");
	        statement.setString(1, dd.getMaPT());
	        statement.setString(2, dd.getTenPT());
	        n = statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return n > 0;
	}

	public boolean updatePhuongTien(PhuongTien dd) {
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("Update PhuongTien Set PhuongTien=? where MaPhuongTien=?");
			stmt.setString(1, dd.getTenPT());
			stmt.setString(2, dd.getMaPT());
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
	public boolean deletePhuongTien(String maPhuongTien) {
		ConnectDB.getInstance();
		int n=0;
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("Delete from PhuongTien where MaPhuongTien=?");
			stmt.setString(1, maPhuongTien);
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
	public PhuongTien timPhuongTien(String maPT) {
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("select * from PhuongTien where MaPhuongTien=?");
			stmt.setString(1, maPT);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				return new PhuongTien(rs.getString("MaPhuongTien"), rs.getString("PhuongTien"));
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
		return null;
	}
}
