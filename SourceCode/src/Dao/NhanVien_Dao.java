package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConnectDB.ConnectDB;
import Entity.NhanVien;

public class NhanVien_Dao {
	public NhanVien_Dao() {
		
	}
	
	public boolean updateNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		PreparedStatement st = null;
		int n=0;
		try {
			Connection con = ConnectDB.getConnection();
			st = con.prepareStatement("UPDATE NhanVien SET soDT=?, matKhau=?, tenNV=?, ngaySinh=?, gioiTinh=?, cccd=?, ngayVL=? where maNV=?");
			st.setString(1, nv.getSoDT());
			st.setString(2, nv.getMatKhau());
			st.setString(3, nv.getTenNV());
			st.setDate(4, nv.getNgaySinh());
			st.setBoolean(5, nv.getGioiTinh());
			st.setString(6, nv.getCccd());
			st.setDate(7, nv.getNgayVL());
			n = st.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}

}
