package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Home_GUI extends JFrame implements ActionListener{
	private JButton btnTrangChu, btnTour, btnDonHang, btnKH, btnQuanLi, btnNhanVien;
	public Home_GUI() {
		setTitle("Vietour - Phan mem quan li tour du lich");
		setSize(1200, 820);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/travel.png"));
		createGUI();
	}
	public void createGUI() {
		JPanel panelHead = new JPanel();
		panelHead.setLayout(new FlowLayout());
		panelHead.setBackground(new Color(175, 238, 238));
		add(panelHead, BorderLayout.NORTH);
		ImageIcon imgHome = new ImageIcon("img/home.png");
		panelHead.add(btnTrangChu = new JButton("Trang chủ", imgHome));
		btnTrangChu.setFont(new Font("Arial", Font.BOLD, 14));
		btnTrangChu.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTrangChu.setBackground(new Color(255, 165, 0));
		btnTrangChu.setForeground(new Color(255, 255, 255));
		
		ImageIcon imgTour = new ImageIcon("img/search.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnTour = new JButton("Tour", imgTour));
		btnTour.setFont(new Font("Arial", Font.BOLD, 14));
		btnTour.setBackground(Color.WHITE);
		btnTour.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTour.setBackground(new Color(60, 179, 113));
		btnTour.setForeground(new Color(255, 255, 255));
		btnTour.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgHD = new ImageIcon("img/ticket.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnDonHang = new JButton("Hóa Đơn", imgHD));
		btnDonHang.setFont(new Font("Arial", Font.BOLD, 14));
		btnDonHang.setBackground(Color.WHITE);
		btnDonHang.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnDonHang.setBackground(new Color(60, 179, 113));
		btnDonHang.setForeground(new Color(255, 255, 255));
		btnDonHang.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgLogo = new ImageIcon("img/vietour_logo.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(new JLabel(imgLogo));
		
		ImageIcon imgKH = new ImageIcon("img/customer.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnKH = new JButton("Khách Hàng", imgKH));
		btnKH.setFont(new Font("Arial", Font.BOLD, 14));
		btnKH.setBackground(Color.WHITE);
		btnKH.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnKH.setBackground(new Color(60, 179, 113));
		btnKH.setForeground(new Color(255, 255, 255));
		btnKH.setPreferredSize(btnKH.getPreferredSize());

		ImageIcon imgQL = new ImageIcon("img/execute.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnQuanLi = new JButton("Quản lí", imgQL));
		btnQuanLi.setFont(new Font("Arial", Font.BOLD, 14));
		btnQuanLi.setBackground(Color.WHITE);
		btnQuanLi.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnQuanLi.setBackground(new Color(60, 179, 113));
		btnQuanLi.setForeground(new Color(255, 255, 255));
		btnQuanLi.setPreferredSize(btnTrangChu.getPreferredSize());
		
		panelHead.add(Box.createHorizontalStrut(20));
		ImageIcon imgUser = new ImageIcon("img/user.png");
		panelHead.add(btnNhanVien = new JButton(": Nguyễn Văn A", imgUser));
		btnNhanVien.setBackground(new Color(250,  128, 144));
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 12));
		
		ImageIcon banner = new ImageIcon("img/banner.png");
		JLabel lblBanner = new JLabel(banner);
		add(lblBanner, BorderLayout.WEST);
		
		ImageIcon phuQuoc = new ImageIcon("img/phuquoc.jpg");
		JLabel lblBanner1 = new JLabel(phuQuoc);
		add(lblBanner1, BorderLayout.CENTER);
		
		ImageIcon member = new ImageIcon("img/member.jpg");
		JLabel lblmember = new JLabel(member);
		add(lblmember, BorderLayout.SOUTH);
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDonHang.addActionListener(this);
		btnQuanLi.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnKH.addActionListener(this);
	}
	public static void main(String[] args) {
		new Home_GUI().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnTrangChu) {
			
		}else if(o==btnDonHang) {
			
		}else if(o==btnQuanLi){
			setVisible(false);
			new QuanLiTour_GUI().setVisible(true);
		}else if(o==btnTour) {
			setVisible(false);
			new Tour_GUI().setVisible(true);
		}else if(o==btnNhanVien){
			
		}else if(o==btnKH){
			setVisible(false);
			new KhachHang_GUI().setVisible(true);
		}
	}
}
