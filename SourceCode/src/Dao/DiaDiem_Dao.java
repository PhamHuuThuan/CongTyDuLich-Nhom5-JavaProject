package Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ConnectDB.ConnectDB;
import Entity.DiaDiem;

public class DiaDiem_Dao {
	public DiaDiem_Dao() {
		
	}
	public ArrayList<DiaDiem> getAllDiaDiem(){
		ArrayList<DiaDiem> dsDD = new ArrayList<DiaDiem>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String query = "Select * from DiaDiem";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String maDD = rs.getString("MaDiaDiem");
				String tenDD = rs.getString("TenDiaDiem");
				DiaDiem dd = new DiaDiem(maDD, tenDD);
				dsDD.add(dd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDD;
	}
	public DiaDiem getDiaDiemTheoMa(String maDiaDiem){
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DiaDiem where MaDiaDiem like ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%"+maDiaDiem+"%");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maDD = rs.getString("MaDiaDiem");
				String tenDD = rs.getString("TenDiaDiem");
				DiaDiem dd = new DiaDiem(maDD, tenDD);
				return dd;
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
	public boolean themDiaDiem(DiaDiem dd) {
		ConnectDB.getInstance();
		PreparedStatement statement = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			statement = con.prepareStatement("insert into DiaDiem values(?, ?)");
			statement.setString(1, dd.getMaDiaDiem());
			statement.setString(2, dd.getTenDiaDiem());
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
	public boolean updateDiaDiem(DiaDiem dd) {
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("Update DiaDiem Set TenDiaDiem=? where MaDiaDiem=?");
			stmt.setString(1, dd.getTenDiaDiem());
			stmt.setString(2, dd.getMaDiaDiem());
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
	public boolean deleteDiaDiem(String maDiaDiem) {
		ConnectDB.getInstance();
		int n=0;
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("Delete from DiaDiem where MaDiaDiem=?");
			stmt.setString(1, maDiaDiem);
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
}
