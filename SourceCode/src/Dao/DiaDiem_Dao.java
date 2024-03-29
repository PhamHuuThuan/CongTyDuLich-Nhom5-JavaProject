package Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	    int n = 0;
	    try {
	        Connection con = ConnectDB.getConnection();
	        statement = con.prepareStatement("insert into DiaDiem values(?, ?)");
	        statement.setString(1, dd.getMaDiaDiem());
	        statement.setString(2, dd.getTenDiaDiem());
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
	public ArrayList<DiaDiem> getAllDiemDi() {
		ArrayList<DiaDiem> dsDD = new ArrayList<DiaDiem>();
		PreparedStatement stmt = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("Select * from DiaDiem where MaDiaDiem like ?");
			stmt.setString(1, "DKH%");
			ResultSet rs = stmt.executeQuery();
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
	public ArrayList<DiaDiem> getAllDiemDuLich() {
		ArrayList<DiaDiem> dsDD = new ArrayList<DiaDiem>();
		PreparedStatement stmt = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("Select * from DiaDiem where MaDiaDiem like ?");
			stmt.setString(1, "DDL%");
			ResultSet rs = stmt.executeQuery();
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
	public String getMaDDMaxKH() {
		String maDD = "";
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(MaDiaDiem) as MAX from DiaDiem where MaDiaDiem like 'DKH%' ");
			while(rs.next())
				maDD = rs.getString("MAX");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maDD;
	}
	public String getMaDDMaxDL() {
		String maDD = "";
		ConnectDB.getInstance();
		try {
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(MaDiaDiem) as MAX from DiaDiem where MaDiaDiem like 'DDL%'");
			while(rs.next())
				maDD = rs.getString("MAX");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maDD;
	}
}
