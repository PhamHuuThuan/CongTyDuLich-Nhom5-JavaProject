package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BUS.Login_BUS;
import ConnectDB.ConnectDB;
import Dao.Login_DAO;
import Entity.NhanVien;

public class UserLogin extends JFrame {
	private static final long serialVersionUID = 1L;

	protected static final Statement DBConnectionFactory = null;

	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel label;
	private JPanel contentPane;
	private Login_BUS loginbus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLogin() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		loginbus = new Login_BUS();
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 190, 550, 370);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel.setBounds(250, 13, 273, 93);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(210, 110, 281, 40);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(210, 160, 281, 40);
		contentPane.add(passwordField);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsername.setBounds(50, 100, 193, 52);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(50, 150, 193, 52);
		contentPane.add(lblPassword);

		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(250, 220, 100, 52);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnNewButton)) {
					if(loginbus.loGin()) {
						setVisible(false);
						new Home_GUI().setVisible(true);
					}
				}
//				String userName = textField.getText();
//				String password = passwordField.getText();
//				try {
//					Connection connection = DBConnectionFactory.getConnection();
//
//					PreparedStatement st = connection.prepareStatement("Select MaNV, MatKhau from NhanVien where MaNV=? and MatKhau=?");
//
//					st.setString(1, userName);
//					st.setString(2, password);
//					ResultSet rs = st.executeQuery();
//					if (rs.next()) {
////						dispose();
//						UserHome ah = new UserHome(userName);
//						ah.setTitle("Chao mung");
//						ah.setVisible(true);
//						JOptionPane.showMessageDialog(btnNewButton, "Ban da dang nhap thanh cong");
//					} else {
//						JOptionPane.showMessageDialog(btnNewButton, "User hoac password sai!");
//					}
//				} catch (SQLException sqlException) {
//					sqlException.printStackTrace();
//				}
			}
		});

//		contentPane.add(btnNewButton);
//
//		label = new JLabel("");
//		label.setBounds(0, 0, 1008, 562);
//		contentPane.add(label);
	}
}
