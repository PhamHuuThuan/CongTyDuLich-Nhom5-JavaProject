package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.NhanVien_Bus;
import ConnectDB.ConnectDB;
import Entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login_GUI extends JFrame implements ActionListener{
	private JPanel contentPane;
	private static JTextField txtSDT;
	private static JPasswordField txtPass;
	private JButton btnLogin;
	private NhanVien_Bus nvBus;
	
	public Login_GUI() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nvBus = new NhanVien_Bus();
		setTitle("Vietour - Phan mem quan li tour du lich");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/travel.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1014, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setBounds(644, 260, 241, 32);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);
		txtSDT.setBorder(null);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass.setBounds(644, 319, 241, 32);
		txtPass.setForeground(Color.gray.brighter());
		txtPass.setBorder(null);
		contentPane.add(txtPass);
		
		JLabel error = new JLabel("");
		error.setForeground(Color.RED);
		error.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		error.setBounds(565, 222, 386, 21);
		contentPane.add(error);
		
		btnLogin = new JButton("");

		btnLogin.setBounds(674, 404, 188, 40);
		contentPane.add(btnLogin);
		btnLogin.setOpaque(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Img/loginBG.png"));
		background.setBounds(0, 0, 1000, 554);
		contentPane.add(background);
		
		btnLogin.addActionListener(this);
	}
	public static void main(String[] args) {
		new Login_GUI().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnLogin) {
			if(validData())
				login();
		}
	}
	public void login() {
		String sdt = txtSDT.getText().trim();
		String pass = txtPass.getText().trim();
		NhanVien nv = nvBus.getNhanVien(sdt, pass);
		if(nv==null) {
			JOptionPane.showMessageDialog(this, "SĐT hoặc mật khẩu không chính xác!");
			return;
		}
		new Home_GUI(nv).setVisible(true);
	}
	public boolean validData() {
		String sdt = txtSDT.getText().trim();
		String pass = txtPass.getText().trim();
		
		boolean ptSDT = Pattern.matches("[0-9]{10,11}", sdt);
		boolean ptPass = Pattern.matches("[a-zA-Z0-9 @#$%^&+=_]{4,}", pass);
		if(!ptSDT) {
			JOptionPane.showMessageDialog(this, "Lỗi! SDT chỉ được nhập số và độ dài từ 10-11 kí tự");
			txtSDT.requestFocus();
			return false;
		}if(!ptPass) {
			JOptionPane.showMessageDialog(this, "Lỗi! Pwd chỉ được nhập số, chữ và @#$%^&+=_. Độ dài từ 4 kí tự trở lên");
			txtPass.requestFocus();
			return false;
		}
		return true;
	}
}
