package BUS;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Dao.Login_DAO;
import Entity.NhanVien;

public class Login_BUS {
	Login_DAO login_DAO = new Login_DAO();
	private JButton btnNewButton;
	public boolean loGin() {
		NhanVien nv = new NhanVien();
		try {
			if(login_DAO.loGin(nv)) {
				JOptionPane.showMessageDialog(btnNewButton, "Ban da dang nhap thanh cong");
				return true;
			}else {
				JOptionPane.showMessageDialog(btnNewButton, "User hoac password sai!");
				return false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
}
