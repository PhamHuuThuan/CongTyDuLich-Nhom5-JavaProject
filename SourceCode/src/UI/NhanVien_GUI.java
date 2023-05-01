package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.DateModel;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import BUS.NhanVien_Bus;
import Entity.NhanVien;

public class NhanVien_GUI extends JFrame implements ActionListener, FocusListener{
	private JButton btnSua, btnLogout, btnTrangChu, btnTour, btnDonHang, btnKhachHang, btnQuanLy, btnNhanVien;
	private JLabel lblMaNV, lblSdt, lblMatKhau, lblTenNV, lblNgaySinh, lblGioiTinh, lblCCCD, lblNgayVL;
	private JTextField txtMaNV, txtSdt, txtTenNV, txtCCCD;
	private JPasswordField password;
	private JRadioButton radNam, radNu;
	private JDatePickerImpl ngaySinh, ngayVL;
	private ButtonGroup group;
	private JPanel pCenter;
	private NhanVien nv;
	private NhanVien_Bus nvBus;
	public NhanVien_GUI(NhanVien nv) {
		setTitle("Thông tin nhân viên");
		setSize(1200, 820);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img//travel.png"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.nv = nv;
		nvBus = new NhanVien_Bus();
		createGUI();
	}
	public void createGUI() {
		JPanel pHeader = new JPanel();
		pHeader.setLayout(new FlowLayout());
		pHeader.setBackground(new Color(175, 238, 238));
		add(pHeader,BorderLayout.NORTH);
		ImageIcon imgHome = new ImageIcon("img/home.png");
		pHeader.add(btnTrangChu = new JButton("Trang Chủ", imgHome));
		btnTrangChu.setFont(new Font("Arial", Font.BOLD, 14));
		btnTrangChu.setBorder(new EmptyBorder(10,10,10,10));
		btnTrangChu.setBackground(new Color(60,179,113));
		btnTrangChu.setForeground(new Color(255,255,255));
		
		ImageIcon imgTour = new ImageIcon("Img/search.png");
		pHeader.add(Box.createHorizontalStrut(20));
		pHeader.add(btnTour = new JButton("Tour", imgTour));
		btnTour.setFont(new Font("Arial",Font.BOLD,14));
		btnTour.setBackground(Color.WHITE);
		btnTour.setBorder(new EmptyBorder(10,10,10,10));
		btnTour.setBackground(new Color(60,179,113));
		btnTour.setForeground(new Color(255,255,255));
		
		ImageIcon imgHD = new ImageIcon("Img/ticket.png");
		pHeader.add(Box.createHorizontalStrut(20));
		pHeader.add(btnDonHang = new JButton("Hóa đơn", imgHD));
		btnDonHang.setFont(new Font("Arial", Font.BOLD,14));
		btnDonHang.setBackground(Color.WHITE);
		btnDonHang.setBorder(new EmptyBorder(10,10,10,10));
		btnDonHang.setBackground(new Color(60,179,113));
		btnDonHang.setForeground(new Color(255,255,255));
		
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
		
		
		ImageIcon imgQL = new ImageIcon("Img/execute.png");
		pHeader.add(Box.createHorizontalStrut(20));
		pHeader.add(btnQuanLy = new JButton("Quản lý", imgQL));
		btnQuanLy.setFont(new Font("Arial", Font.BOLD,14));
		btnQuanLy.setBackground(Color.WHITE);
		btnQuanLy.setBorder(new EmptyBorder(10,10,10,10));
		btnQuanLy.setBackground(new Color(60,179,113));
		btnQuanLy.setForeground(new Color(255,255,255));
		btnQuanLy.setPreferredSize(btnTrangChu.getPreferredSize());
		btnDonHang.setPreferredSize(btnTrangChu.getPreferredSize());
		btnTour.setPreferredSize(btnTrangChu.getPreferredSize());
		
		pHeader.add(Box.createHorizontalStrut(20));
		ImageIcon imgUser = new ImageIcon("Img/user.png");
		pHeader.add(btnNhanVien = new JButton(":"+ nv.getTenNV(), imgUser));
		btnNhanVien.setBackground(new Color(255,165,0));
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 12));
		
		ImageIcon hinh1 = new ImageIcon("img/BannerEMP.png");
		Image image1 = hinh1.getImage();
		Image scaledImage1 = image1.getScaledInstance(400, 600, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
		JLabel lblBanner = new JLabel(scaledIcon1);
		add(lblBanner, BorderLayout.WEST);
		
		pCenter = new JPanel();
		pCenter.setBorder(BorderFactory.createEmptyBorder(20, 175, 20, 175));
		JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTitle.setForeground(Color.BLUE);
		Font ftTitle = new Font("Arial", Font.BOLD,25);
		lblTitle.setFont(ftTitle);
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
		pCenter.setBackground(Color.WHITE);
		
		lblMaNV = new JLabel("Mã nhân viên:");
		lblMatKhau = new JLabel("Mật khẩu:");
		lblTenNV = new JLabel("Họ tên:");
		lblSdt = new JLabel("SĐT:");
		lblNgaySinh = new JLabel("Ngày sinh:");
		lblGioiTinh = new JLabel("Giới tính:");
		lblCCCD = new JLabel("CCCD:");
		lblNgayVL = new JLabel("Ngày vào làm:");
		
		txtMaNV = new JTextField();
		password = new JPasswordField();
		txtTenNV = new JTextField();
		txtSdt = new JTextField();
		txtCCCD = new JTextField();
		radNam = new JRadioButton("Nam", true);
		radNu = new JRadioButton("Nữ");
		group = new ButtonGroup();
		group.add(radNam);
		group.add(radNu);
		
		b0.add(lblTitle);
		b1.add(lblMaNV);
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtMaNV);
		txtMaNV.setEditable(false);
		b2.add(lblMatKhau);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(password);
		b3.add(lblTenNV);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtTenNV);
		b4.add(lblSdt);
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtSdt);
		b5.add(lblNgaySinh);
		b5.add(Box.createHorizontalStrut(20));
		UtilDateModel model = new UtilDateModel();
		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
		ngaySinh = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		b5.add(ngaySinh);
		b5.add(Box.createHorizontalStrut(5));
		b5.add(lblGioiTinh);
		b5.add(radNam);
		b5.add(radNu);
		b6.add(lblCCCD);
		b6.add(Box.createHorizontalStrut(20));
		b6.add(txtCCCD);
		b7.add(lblNgayVL);
		b7.add(Box.createHorizontalStrut(20));
		UtilDateModel model1 = new UtilDateModel();
		Properties properties1 = new Properties();
		properties1.put("text.today", "Today");
		properties1.put("text.month", "Month");
		properties1.put("text.year", "Year");
		JDatePanelImpl datePanelVL = new JDatePanelImpl(model1, properties1);
		ngayVL = new JDatePickerImpl(datePanelVL, new DateComponentFormatter());
		b7.add(ngayVL);
		b7.add(Box.createHorizontalStrut(165));
		b8.add(btnSua = new JButton("Cập nhật thông tin"));
		b8.add(Box.createHorizontalStrut(50));
		b8.add(btnLogout = new JButton("Đăng xuất"));
		lblMaNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTenNV.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMatKhau.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSdt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNgaySinh.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGioiTinh.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCCCD.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNgayVL.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblMatKhau.setPreferredSize(lblNgayVL.getPreferredSize());
		lblTenNV.setPreferredSize(lblNgayVL.getPreferredSize());
		lblSdt.setPreferredSize(lblNgayVL.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblNgayVL.getPreferredSize());
		lblCCCD.setPreferredSize(lblNgayVL.getPreferredSize());
		lblMaNV.setPreferredSize(lblNgayVL.getPreferredSize());
		
		txtMaNV.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMaNV.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		txtMaNV.setBackground(new Color(220, 220, 220));
		txtTenNV.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTenNV.setBackground(new Color(224, 255, 255));
		txtTenNV.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		txtSdt.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSdt.setBackground(new Color(224, 255, 255));
		txtSdt.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		txtCCCD.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCCCD.setBackground(new Color(224, 255, 255));
		txtCCCD.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		password.setFont(new Font("Arial", Font.PLAIN, 14));
		password.setBackground(new Color(224, 255, 255));
		password.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		radNam.setBackground(Color.WHITE);
		radNu.setBackground(Color.WHITE);
		
		btnSua.setFont(new Font("Arial", Font.BOLD, 14));
		btnSua.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnSua.setBackground(new Color(255, 165, 0));
		btnSua.setForeground(new Color(255, 255, 255));
		
		btnLogout.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogout.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnLogout.setBackground(new Color(255, 127, 80));
		btnLogout.setForeground(new Color(255, 255, 255));
		
		ImageIcon hinh2 = new ImageIcon("img/EMP.jpg");
		Image image2 = hinh2.getImage();
		Image scaledImage2 = image2.getScaledInstance(1200, 125, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		JLabel lblMember = new JLabel(scaledIcon2);
		add(lblMember, BorderLayout.SOUTH);
		
		txtMaNV.setText(nv.getMaNV());
		txtTenNV.setText(nv.getTenNV());
		txtSdt.setText(nv.getSoDT());
		txtCCCD.setText(nv.getCccd());
		password.setText(nv.getMatKhau());
		password.setEchoChar('*');
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nv.getNgaySinh());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		UtilDateModel modelDate = (UtilDateModel) ngaySinh.getModel();
		modelDate.setSelected(true);
		modelDate.setDate(year, month, day);
		
		calendar.setTime(nv.getNgayVL());
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		UtilDateModel modelDate1 = (UtilDateModel) ngayVL.getModel();
		modelDate1.setSelected(true);
		modelDate1.setDate(year, month, day);
		ngayVL.getComponent(1).setEnabled(false);
		
		if(nv.getGioiTinh())
			radNam.setSelected(true);
		else
			radNu.setSelected(true);
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDonHang.addActionListener(this);
		btnQuanLy.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnSua.addActionListener(this);
		btnLogout.addActionListener(this);
		password.addFocusListener(this);
		
	}
	public static void main(String[] args) {
		NhanVien nv = new NhanVien("NV001", "0123456789", "12345", "Phạm Hữu Thuận", java.sql.Date.valueOf(LocalDate.of(2003, 5, 14)), true, "064xxxxxxxxx",  java.sql.Date.valueOf(LocalDate.of(2023, 3, 15)));
		new NhanVien_GUI(nv).setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o==btnTrangChu) {
			setVisible(false);
			new Home_GUI(nv).setVisible(true);
		}else if(o==btnDonHang) {
			setVisible(false);
			new QuanLiHoaDon_GUI(nv).setVisible(true);
		}else if(o==btnQuanLy){
			setVisible(false);
			new QuanLiTour_GUI(nv).setVisible(true);
		}else if(o==btnTour) {
			setVisible(false);
			new Tour_GUI(nv).setVisible(true);
		}else if(o==btnNhanVien){
			setVisible(false);
			new NhanVien_GUI(nv).setVisible(true);
		}else if(o==btnKhachHang){
			setVisible(false);
			new KhachHang_GUI(nv).setVisible(true);
		}else if(o==btnSua){
			if(validData()) {
				NhanVien nv = convertNhanVien();
				if(nvBus.updateNhanVien(nv)) {
					this.nv = nv;
					btnNhanVien.setText(nv.getTenNV());
					JOptionPane.showMessageDialog(this, "Update thành công!");
				}else {
					JOptionPane.showMessageDialog(this, "Thất bại! Đã xảy ra lỗi trong quá trình thực hiện.");
				}
			}
		}else if(o==btnLogout) {
			setVisible(false);
			new Login_GUI().setVisible(true);
		}
		
	}
	public boolean validData() {
		String tenNV = txtTenNV.getText().trim();
		String sdt = txtSdt.getText().trim();
		String cccd = txtCCCD.getText().trim();
		String matKhau = password.getText().trim();
		
		boolean ptTenNV = Pattern.matches("[a-zA-Z0-9aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
				+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
				+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ _']+", tenNV);
		boolean ptSdt = Pattern.matches("[0-9]{10,11}", sdt);
		boolean ptCCCD = Pattern.matches("[0-9]{12}", cccd);
		boolean ptMatKhau = Pattern.matches("[a-zA-Z0-9 @#$%^&+=_]{4,}", matKhau);

		DateModel<?> model = ngaySinh.getModel();
		int day = model.getDay();
		int month = model.getMonth();
		int year = model.getYear();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		java.sql.Date birthDate = new java.sql.Date(calendar.getTimeInMillis());
		if(!ptMatKhau) {
			JOptionPane.showMessageDialog(this, "Lỗi! Pwd chỉ được nhập số, chữ và @#$%^&+=_. Độ dài từ 4 kí tự trở lên");
			password.requestFocus();
			return false;
		}
		if(!ptTenNV) {
			JOptionPane.showMessageDialog(this, "Lỗi! Tên chỉ được nhập chữ và kí tự khoảng trắng hoặc '");
			txtTenNV.requestFocus();
			return false;
		}
		if(!ptSdt) {
			JOptionPane.showMessageDialog(this, "Lỗi! SDT chỉ được nhập số và độ dài từ 10-11 kí tự");
			txtSdt.requestFocus();
			return false;
		}
		if(java.sql.Date.valueOf(LocalDate.now()).before(birthDate) || ChronoUnit.YEARS.between(birthDate.toLocalDate(), LocalDate.now())<18) {
			JOptionPane.showMessageDialog(this, "Error: Ngày sinh không được sau ngày hiện tại và phải đủ 18 tuổi!");
			ngaySinh.requestFocus();
			return false;
		}
		if(!ptCCCD) {
			JOptionPane.showMessageDialog(this, "Lỗi! CCCD chỉ được nhập số và độ dài 12 kí tự");
			txtCCCD.requestFocus();
			return false;
		}
		
		return true;
	}
	public NhanVien convertNhanVien() {
		String maNV = txtMaNV.getText().trim();
		String tenNV = txtTenNV.getText().trim();
		String sdt = txtSdt.getText().trim();
		String cccd = txtCCCD.getText().trim();
		String matKhau = password.getText().trim();
		boolean gt = radNam.isSelected()?true:false;
		
		DateModel<?> model = ngaySinh.getModel();
		int day = model.getDay();
		int month = model.getMonth();
		int year = model.getYear();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		java.sql.Date ngaySinhSQL = new java.sql.Date(calendar.getTimeInMillis());
		
		model = ngayVL.getModel();
		day = model.getDay();
		month = model.getMonth();
		year = model.getYear();
		calendar.set(year, month, day);
		java.sql.Date ngayVLSQL = new java.sql.Date(calendar.getTimeInMillis());
		
		return new NhanVien(maNV, sdt, matKhau, tenNV, ngaySinhSQL, gt, cccd, ngayVLSQL);
	}
	@Override
	public void focusGained(FocusEvent e) {
		Object o = e.getSource();
		if(o==password)
			password.setEchoChar((char)0);
	}
	@Override
	public void focusLost(FocusEvent e) {
		Object o = e.getSource();
		if(o==password)
			password.setEchoChar('*');
	}
}
