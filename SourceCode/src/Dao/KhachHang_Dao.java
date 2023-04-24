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
import Entity.KhachHang;
import Entity.ThanhVien;
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
	                String Sdt = rs.getString("SDT");
	                String TenKH = rs.getString("TenKH");
	                String email = rs.getString("Email");
	                String diaChi = rs.getString("DiaChi");
	                KhachHang kh = new KhachHang(maKH, Sdt, TenKH, email, diaChi);
	                dsKH.add(kh);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return dsKH;
	    }

	    public boolean updateKhachHang(KhachHang kh) {
	        ConnectDB.getInstance();
	        PreparedStatement stmt = null;
	        int n=0;
	        try {
		            Connection con = ConnectDB.getConnection();
		            stmt = con.prepareStatement("UPDATE KhachHang SET SDT=?,TenKH=?, Email=?, DiaChi=? WHERE MaKH=?");
		            stmt.setString(1, kh.getSdt());
		            stmt.setString(2, kh.getTenKH());
		            stmt.setString(3, kh.getEmail());
		            stmt.setString(4, kh.getDiaChi());
		            stmt.setString(5, kh.getMaKH());
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
	    public String getMaKHMax() {
			String maKH = "";
			ConnectDB.getInstance();
			try {
				Connection con = ConnectDB.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select max(MaKH) as MAX from KhachHang");
				while(rs.next())
					maKH = rs.getString("MAX");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return maKH;
		}
	    public KhachHang getKhachHangTheoMa(String maKhachHang) throws ParseException {
			PreparedStatement statement = null;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "Select * from KhachHang where MaKH like ?";
				statement = con.prepareStatement(sql);
				statement.setString(1, "%"+maKhachHang+"%");
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					 String maKH = rs.getString("MaKH");
		                String Sdt = rs.getString("SDT");
		                String TenKH = rs.getString("TenKH");
		                String email = rs.getString("Email");
		                String diaChi = rs.getString("DiaChi");
		                KhachHang kh = new KhachHang(maKH, Sdt, TenKH, email, diaChi);
					return kh;
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
}
