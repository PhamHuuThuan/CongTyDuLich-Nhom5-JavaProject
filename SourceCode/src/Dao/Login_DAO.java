package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ConnectDB.ConnectDB;
import Entity.NhanVien;

public class Login_DAO {
private JButton btnNewButton;
	
	public boolean loGin(NhanVien nv) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("Select MaNV, MatKhau from NhanVien where MaNV=? and MatKhau=?");
			st.setString(1, nv.getMaNV());
			st.setString(2, nv.getMatKhau());
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
//				dispose();
//				UserHome ah = new UserHome(nv.getMaND());
//				ah.setTitle("Chao mung");
//				ah.setVisible(true);
//				JOptionPane.showMessageDialog(btnNewButton, "Ban da dang nhap thanh cong");
				return true;
			} else {
//				JOptionPane.showMessageDialog(btnNewButton, "User hoac password sai!");
				return false;
//			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
//		return true;
		
	}

	private void dispose() {
		// TODO Auto-generated method stub
		
	}
}
