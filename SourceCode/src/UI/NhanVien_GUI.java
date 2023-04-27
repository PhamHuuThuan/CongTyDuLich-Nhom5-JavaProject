package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NhanVien_GUI extends JFrame implements ActionListener, MouseListener{
	private JButton btnSua, btnTrangChu, btnTour, btnDonHang, btnKhachHang, btnQuanLy, btnNhanVien;
	private JLabel lblMaNV, lblSdt, lblMatKhau, lblTenNV, lblNgaySinh, lblGioiTinh, lblCCCD, lblNgayVL;
	private JTextField txtMaNV, txtSdt, txtTenNV, txtCCCD, txtNgayVL;
	private JPasswordField password;
	private JRadioButton radNam, radNu;
	private ButtonGroup group;
	private JPanel pCenter;
	public NhanVien_GUI() {
		setTitle("Thông tin nhân viên");
		setSize(1200, 820);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img//travel.png"));
		createGUI();
	}
	
	public void createGUI() {
		JPanel pHeader = new JPanel();
		pHeader.setLayout(new FlowLayout());
		pHeader.setBackground(new Color(175, 238, 238));
		add(pHeader,BorderLayout.NORTH);
		ImageIcon imgHome = new ImageIcon("Img/home.png");
		pHeader.add(btnTrangChu = new JButton("Trang Chủ"));
		btnTrangChu.setFont(new Font("Arial", Font.BOLD, 14));
		btnTrangChu.setBorder(new EmptyBorder(10,10,10,10));
		btnTrangChu.setBackground(new Color(255,165,0));
		btnTrangChu.setForeground(new Color(255,255,255));
		
		ImageIcon imgTour = new ImageIcon("Img/search.png");
		pHeader.add(Box.createHorizontalStrut(20));
		pHeader.add(btnTour = new JButton("Tuor", imgTour));
		btnTour.setFont(new Font("Arial",Font.BOLD,14));
		btnTour.setBackground(Color.WHITE);
		btnTour.setBorder(new EmptyBorder(10,10,10,10));
		btnTour.setBackground(new Color(60,179,113));
		btnTour.setForeground(new Color(255,255,255));
		btnTour.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgHD = new ImageIcon("Img/ticket.png");
		pHeader.add(Box.createHorizontalStrut(20));
		pHeader.add(btnDonHang = new JButton("Hóa đơn", imgHD));
		btnDonHang.setFont(new Font("Arial", Font.BOLD,14));
		btnDonHang.setBackground(Color.WHITE);
		btnDonHang.setBorder(new EmptyBorder(10,10,10,10));
		btnDonHang.setBackground(new Color(60,179,113));
		btnDonHang.setForeground(new Color(255,255,255));
		btnDonHang.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgLogo = new ImageIcon("Img/vietour_logo.png");
		pHeader.add(Box.createHorizontalStrut(20));
		pHeader.add(new JLabel(imgLogo));
		
		ImageIcon imgKH = new ImageIcon("Img/customer.png");
		pHeader.add(Box.createHorizontalStrut(20));
		pHeader.add(btnKhachHang = new JButton("Khách hàng", imgKH));
		btnKhachHang.setFont(new Font("Arial", Font.BOLD,14));
		btnKhachHang.setBackground(Color.WHITE);
		btnKhachHang.setBorder(new EmptyBorder(10,10,10,10));
		btnKhachHang.setBackground(new Color(60,179,113));
		btnKhachHang.setForeground(new Color(255,255,255));
		btnKhachHang.setPreferredSize(btnTrangChu.getPreferredSize());
		
		
		ImageIcon imgQL = new ImageIcon("Img/execute.png");
		pHeader.add(Box.createHorizontalStrut(20));
		pHeader.add(btnQuanLy = new JButton("Quản lý", imgQL));
		btnQuanLy.setFont(new Font("Arial", Font.BOLD,14));
		btnQuanLy.setBackground(Color.WHITE);
		btnQuanLy.setBorder(new EmptyBorder(10,10,10,10));
		btnQuanLy.setBackground(new Color(60,179,113));
		btnQuanLy.setForeground(new Color(255,255,255));
		btnQuanLy.setPreferredSize(btnTrangChu.getPreferredSize());
		
		pHeader.add(Box.createHorizontalStrut(20));
		ImageIcon imgUser = new ImageIcon("Img/user.png");
		pHeader.add(btnNhanVien = new JButton(": Nguyễn Văn A", imgUser));
		btnNhanVien.setBackground(new Color(250, 128, 144));
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 12));
		
		ImageIcon banner = new ImageIcon("Img/banner.png");
		JLabel lblBanner = new JLabel(banner);
		add(lblBanner, BorderLayout.WEST);
		
		pCenter = new JPanel();
		JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTitle.setForeground(Color.BLUE);
		Font ftTitle = new Font("Arial", Font.BOLD,25);
		lblTitle.setFont(ftTitle);
//		pCenter.add(lblTitle);
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.X_AXIS));
		Box b = Box.createVerticalBox();
		Box b0 = Box.createHorizontalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		Box b7 = Box.createHorizontalBox();
		Box b8 = Box.createHorizontalBox();
		
		b.add(b0);
		b.add(Box.createVerticalStrut(35));
		b.add(b1);
		b.add(Box.createVerticalStrut(35));
		b.add(b2);
		b.add(Box.createVerticalStrut(35));
		b.add(b3);
		b.add(Box.createVerticalStrut(35));
		b.add(b4);
		b.add(Box.createVerticalStrut(35));
		b.add(b5);
		b.add(Box.createVerticalStrut(35));
		b.add(b6);
		b.add(Box.createVerticalStrut(35));
		b.add(b7);
		b.add(Box.createVerticalStrut(35));
		b.add(b8);
		b.add(Box.createVerticalStrut(35));
		pCenter.add(b);
		pCenter.add(Box.createVerticalStrut(35));
		
		lblMaNV = new JLabel("Mã nhân viên:    ");
		lblMatKhau = new JLabel("Mật khẩu:");
		lblTenNV = new JLabel("Tên nhân viên:");
		lblSdt = new JLabel("SĐT:");
		lblNgaySinh = new JLabel("Ngày sinh:");
		lblGioiTinh = new JLabel("Giới tính:");
		lblCCCD = new JLabel("CCCD:");
		lblNgayVL = new JLabel("Ngay VL:");
		
		txtMaNV = new JTextField();
		password = new JPasswordField();
		txtTenNV = new JTextField();
		txtSdt = new JTextField();
		txtCCCD = new JTextField();
		txtNgayVL = new JTextField();
		radNam = new JRadioButton("Nam", true);
		radNu = new JRadioButton("Nữ");
		group = new ButtonGroup();
		group.add(radNam);
		group.add(radNu);
		
		b0.add(lblTitle);
		b1.add(lblMaNV);
		b1.add(txtMaNV);
		b2.add(lblMatKhau);
		b2.add(password);
		b3.add(lblTenNV);
		b3.add(txtTenNV);
		b4.add(lblSdt);
		b4.add(txtSdt);
		b5.add(lblNgaySinh);
		b5.add(new JFormattedTextField(new Date()));
		b5.add(lblGioiTinh);
		b5.add(radNam);
		b5.add(radNu);
		b6.add(lblCCCD);
		b6.add(txtCCCD);
		b7.add(lblNgayVL);
		b7.add(txtNgayVL);
		b8.add(btnSua = new JButton("Sửa"));
		lblMatKhau.setPreferredSize(lblMaNV.getPreferredSize());
		lblTenNV.setPreferredSize(lblMaNV.getPreferredSize());
		lblSdt.setPreferredSize(lblMaNV.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblMaNV.getPreferredSize());
		lblCCCD.setPreferredSize(lblMaNV.getPreferredSize());
		lblNgayVL.setPreferredSize(lblMaNV.getPreferredSize());
		
		ImageIcon member = new ImageIcon("Img/member.jpg");
		JLabel lblMember = new JLabel(member);
		add(lblMember, BorderLayout.SOUTH);
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDonHang.addActionListener(this);
		btnQuanLy.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnSua.addActionListener(this);
		
		
	}
	
	public static void main(String[] args) {
		new NhanVien_GUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o==btnTrangChu) {
			setVisible(false);
			new Home_GUI().setVisible(true);
		}else if(o==btnDonHang) {
			
		}else if(o==btnQuanLy){
			setVisible(false);
			new QuanLiTour_GUI().setVisible(true);
		}else if(o==btnTour) {
			setVisible(false);
			new Tour_GUI().setVisible(true);
		}else if(o==btnNhanVien){
			
		}else if(o==btnKhachHang){
			
		}else if(o==btnSua){
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
