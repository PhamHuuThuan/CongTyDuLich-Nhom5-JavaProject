package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.KhachHang;
	public class KhachHang_Dao {
	    public KhachHang_Dao() {
	        
	    }
	    public ArrayList<KhachHang> getAllKhachHang(){
	        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	        try {
	            ConnectDB.getInstance();
	            Connection con = ConnectDB.getConnection();
	            String query = "SELECT * FROM KhachHang";
	            Statement statement = con.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            while(rs.next()) {
	                String maKH = rs.getString("MaKH");
	                String hoTen = rs.getString("HoTen");
	                String gioiTinh = rs.getString("GioiTinh");
	                String sdt = rs.getString("SDT");
	                String email = rs.getString("Email");
	                KhachHang kh = new KhachHang(maKH);
	                dsKH.add(kh);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return dsKH;
	    }
	    public KhachHang getKhachHangTheoMa(String maKH){
	        PreparedStatement statement = null;
	        try {
	            ConnectDB.getInstance();
	            Connection con = ConnectDB.getConnection();
	            String sql = "SELECT * FROM KhachHang WHERE MaKH LIKE ?";
	            statement = con.prepareStatement(sql);
	            statement.setString(1, "%"+maKH+"%");
	            ResultSet rs = statement.executeQuery();
	            while(rs.next()) {
	                String hoTen = rs.getString("HoTen");
	                String gioiTinh = rs.getString("GioiTinh");
	                String sdt = rs.getString("SDT");
	                String email = rs.getString("Email");
	                KhachHang kh = new KhachHang(maKH);
	                return kh;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return null;
	    }
	    public boolean themKhachHang(KhachHang kh) {
	        ConnectDB.getInstance();
	        PreparedStatement statement = null;
	        int n=0;
	        try {
	            Connection con = ConnectDB.getConnection();
	            statement = con.prepareStatement("INSERT INTO KhachHang VALUES(?, ?, ?, ?, ?)");
	            statement.setString(1, kh.getMaND());
	            statement.setString(2, kh.getTenND());
	            statement.setBoolean(3, kh.getGioiTinh());
	            statement.setString(4, kh.getSoDT());
	            statement.setString(5, kh.getEmail());
	            n = statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return n>0;
	    }

	    public boolean updateKhachHang(KhachHang kh) {
	        ConnectDB.getInstance();
	        PreparedStatement stmt = null;
	        int n=0;
	        try {
	            Connection con = ConnectDB.getConnection();
	            stmt = con.prepareStatement("UPDATE KhachHang SET HoTen=?, GioiTinh=?, SDT=?, Email=? WHERE MaKH=?");
	            stmt.setString(1, kh.getTenND());
	            stmt.setBoolean(2, kh.getGioiTinh());
	            stmt.setString(3, kh.getSoDT());
	            stmt.setString(4, kh.getEmail());
	            stmt.setString(5, kh.getMaND());
	            n = stmt.executeUpdate();
	            } catch (SQLException e) {
	            e.printStackTrace();
	            } finally {
	            try {
	            stmt.close();
	            } catch (SQLException e) {
	            e.printStackTrace();
	            }
	            }
	            return n > 0;
	            }
	    public boolean deleteKhachHang(String maKH) {
	    	ConnectDB.getInstance();
	    	int n = 0;
	    	PreparedStatement stmt = null;
	    	try {
	    		Connection con = ConnectDB.getConnection();
	    		stmt = con.prepareStatement("DELETE FROM KhachHang WHERE MaKH=?");
	    		stmt.setString(1, maKH);
	    		n = stmt.executeUpdate();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	} finally {
	    		try {
	    			stmt.close();
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	return n > 0;
	    }
	
}