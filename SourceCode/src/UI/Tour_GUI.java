package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Entity.DiaDiem;

public class Tour_GUI extends JFrame implements ActionListener{
	private JButton btnTrangChu, btnTour, btnDonHang, btnQuanLi, btnLoc, btnReset, btnTim, btnDatTour;
	private JTextField txtTim;
	private JTextArea txtAMoTa;
	private JLabel lblTourTim, lblTitleTour, lblGia, lblKhoiHanh, lblTime, lblNoiKH, lblCho, lblMaTour, lblKhachSan, lblPhuongTien,lblNoiDen;
	private JComboBox<DiaDiem> cmbDi, cmbDen;
	private JComboBox<Integer> cmbSoNgay;
	private JComboBox<String> cmbPhuongTien;
	private SpinnerModel modelSpin;
	private JSpinner spinner;
	private DefaultTableModel tblModel;
	private JTable tblTour;
	public Tour_GUI() {
		setTitle("Vietour - Phan mem quan li tour du lich");
		setSize(1200, 820);
		setLocationRelativeTo(null);
		setResizable(false);
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
		btnTrangChu.setBackground(new Color(60, 179, 113));
		btnTrangChu.setForeground(new Color(255, 255, 255));
		
		ImageIcon imgTour = new ImageIcon("img/search.png");
		panelHead.add(Box.createHorizontalStrut(50));
		panelHead.add(btnTour = new JButton("Tour", imgTour));
		btnTour.setFont(new Font("Arial", Font.BOLD, 14));
		btnTour.setBackground(Color.WHITE);
		btnTour.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTour.setBackground(new Color(255, 165, 0));
		btnTour.setForeground(new Color(255, 255, 255));
		btnTour.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgLogo = new ImageIcon("img/vietour_logo.png");
		panelHead.add(Box.createHorizontalStrut(50));
		panelHead.add(new JLabel(imgLogo));
		
		ImageIcon imgHD = new ImageIcon("img/ticket.png");
		panelHead.add(Box.createHorizontalStrut(50));
		panelHead.add(btnDonHang = new JButton("Hóa Đơn", imgHD));
		btnDonHang.setFont(new Font("Arial", Font.BOLD, 14));
		btnDonHang.setBackground(Color.WHITE);
		btnDonHang.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnDonHang.setBackground(new Color(60, 179, 113));
		btnDonHang.setForeground(new Color(255, 255, 255));
		btnDonHang.setPreferredSize(btnTrangChu.getPreferredSize());

		ImageIcon imgQL = new ImageIcon("img/execute.png");
		panelHead.add(Box.createHorizontalStrut(50));
		panelHead.add(btnQuanLi = new JButton("Quản lí", imgQL));
		btnQuanLi.setFont(new Font("Arial", Font.BOLD, 14));
		btnQuanLi.setBackground(Color.WHITE);
		btnQuanLi.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnQuanLi.setBackground(new Color(60, 179, 113));
		btnQuanLi.setForeground(new Color(255, 255, 255));
		btnQuanLi.setPreferredSize(btnTrangChu.getPreferredSize());
		
		JLabel lblUser = new JLabel("Nhân viên: abc");
		panelHead.add(Box.createHorizontalStrut(50));
		panelHead.add(lblUser);
		
		//form search
		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(new GridLayout(16, 1, 0, 10));
		panelSearch.setBorder(BorderFactory.createTitledBorder("Lọc kết quả"));
		add(panelSearch, BorderLayout.WEST);
		
		JLabel lblDiemDi = new JLabel("Điểm đi");
		lblDiemDi.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiemDi.setForeground(new Color(0, 102, 204));
		panelSearch.add(lblDiemDi);
		panelSearch.add(cmbDi = new JComboBox<DiaDiem>());
		
		JLabel lblDiemDen = new JLabel("Điểm đến");
		lblDiemDen.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiemDen.setForeground(new Color(0, 102, 204));
		panelSearch.add(lblDiemDen);
		panelSearch.add(cmbDen = new JComboBox<DiaDiem>());
		
		JLabel lblSoNgay = new JLabel("Số ngày");
		lblSoNgay.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoNgay.setForeground(new Color(0, 102, 204));
		panelSearch.add(lblSoNgay);
		panelSearch.add(cmbSoNgay = new JComboBox<Integer>());
		for(int i=1;i<30;i++) {
			cmbSoNgay.addItem(i);
		}
		
		JLabel lblNgayDi = new JLabel("Ngày đi");
		lblNgayDi.setFont(new Font("Arial", Font.BOLD, 14));
		lblNgayDi.setForeground(new Color(0, 102, 204));
		panelSearch.add(lblNgayDi);
		UtilDateModel model = new UtilDateModel();
		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

		panelSearch.add(datePicker);
		
		JLabel lblSoNguoi = new JLabel("Số người");
		lblSoNguoi.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoNguoi.setForeground(new Color(0, 102, 204));
		panelSearch.add(lblSoNguoi);
		modelSpin = new SpinnerNumberModel(1, 1, null, 1);
		spinner = new JSpinner(modelSpin);
		panelSearch.add(spinner);
		
		JLabel lblPhuongTien = new JLabel("Thông tin vận chuyển");
		lblPhuongTien.setFont(new Font("Arial", Font.BOLD, 14));
		lblPhuongTien.setForeground(new Color(0, 102, 204));
		panelSearch.add(lblPhuongTien);
		String phuongTien[] = {"Xe khách", "Máy bay", "Xe bus", "Tàu"};
		panelSearch.add(cmbPhuongTien = new JComboBox<String>(phuongTien));
		
		JPanel panelBtn = new JPanel(new FlowLayout());
		panelBtn.add(btnLoc = new JButton("Lọc kết quả"));
		btnLoc.setFont(new Font("Arial", Font.BOLD, 14));
		btnLoc.setForeground(Color.WHITE);
		btnLoc.setBackground(new Color(30, 144, 255));
		panelBtn.add(btnReset = new JButton("Reset"));
		btnReset.setFont(new Font("Arial", Font.BOLD, 14));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 144, 255));
		panelSearch.add(panelBtn);
		
		//form ds tour và chi tiết tour
		JPanel panelThongTin = new JPanel();
		panelThongTin.setLayout(new BoxLayout(panelThongTin, BoxLayout.Y_AXIS));
		add(panelThongTin, BorderLayout.CENTER);
		
		JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelThongTin.add(panelTop);
		
		panelTop.add(txtTim=new JTextField(20));
		txtTim.setFont(new Font("Arial", Font.PLAIN, 16));
		panelTop.add(btnTim = new JButton("Tìm"));
		btnTim.setForeground(Color.WHITE);
		btnTim.setBackground(new Color(30, 144, 255));
		panelTop.add(lblTourTim = new JLabel());
		
		String cols[] = {"Mã Tour", "Tên Tour", "Số chỗ", "Ngày đi", "Ngày kết thúc", "Giá tour"};
		tblModel = new DefaultTableModel(cols, 0);
		tblTour = new JTable(tblModel);
		tblTour.setRowHeight(20);
		tblTour.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblTour.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblTour.getColumnModel().getColumn(1).setPreferredWidth(360);
		tblTour.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblTour.getColumnModel().getColumn(3).setPreferredWidth(125);
		tblTour.getColumnModel().getColumn(4).setPreferredWidth(125);
		tblTour.getColumnModel().getColumn(5).setPreferredWidth(150);
		tblTour.setSize(MAXIMIZED_HORIZ, 150);
		JScrollPane tblScroll = new JScrollPane(tblTour,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tblScroll.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 100));
		panelThongTin.add(Box.createVerticalStrut(5));
		panelThongTin.add(tblScroll);
		panelThongTin.add(Box.createVerticalStrut(5));
		
		//chi tiet tour
		//JPanel panelChiTiet = new JPanel();
		JPanel panelTitleTour = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 20)) ;
		panelThongTin.add(panelTitleTour);
		panelTitleTour.add(lblTitleTour = new JLabel("[T15]Du Lich Phu Quoc"));
		lblTitleTour.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitleTour.setForeground(new Color(0, 0, 255));
		
		panelTitleTour.add(lblGia = new JLabel("2.500.000"+"/khach"));
		lblGia.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGia.setForeground(new Color(30,144,255));
		panelTitleTour.add(btnDatTour = new JButton("Đặt Tour"));
		btnDatTour.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnDatTour.setFont(new Font("Arial", Font.BOLD, 18));
		btnDatTour.setBounds(0, 0, 100, 50);
		btnDatTour.setForeground(Color.WHITE);
		btnDatTour.setBackground(new Color(30,144,255));
		
		//hinh anh
		JPanel panelImage = new JPanel(new GridLayout(1, 2));
		panelThongTin.add(panelImage);
		ImageIcon hinh1 = new ImageIcon("Img/ban.png");
		Image image1 = hinh1.getImage();
		Image scaledImage1 = image1.getScaledInstance(550, 300, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
		JLabel lblHinh1 = new JLabel(scaledIcon1);
		panelImage.add(lblHinh1);
		
		JPanel panelImageRight = new JPanel(new GridLayout(2, 1));
		panelImage.add(panelImageRight);
		
		JPanel panelImageTop = new JPanel(new GridLayout(1, 2));
		panelImageRight.add(panelImageTop);
		
		ImageIcon hinh2 = new ImageIcon("Img/ban.png");
		Image image2 = hinh1.getImage();
		Image scaledImage2= image2.getScaledInstance(230, 140, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		JLabel lblHinh2 = new JLabel(scaledIcon2);
		panelImageTop.add(lblHinh2);
		
		ImageIcon hinh3 = new ImageIcon("Img/ban.png");
		Image image3 = hinh3.getImage();
		Image scaledImage3= image3.getScaledInstance(230, 140, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
		JLabel lblHinh3 = new JLabel(scaledIcon3);
		panelImageTop.add(lblHinh3);
		
		ImageIcon hinh4 = new ImageIcon("Img/ban.png");
		Image image4 = hinh4.getImage();
		Image scaledImage4= image4.getScaledInstance(470, 150, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
		JLabel lblHinh4 = new JLabel(scaledIcon4);
		panelImageRight.add(lblHinh4);
		
		JPanel panelBottom = new JPanel(new GridLayout(1, 2));
		panelThongTin.add(Box.createVerticalStrut(5));
		panelThongTin.add(panelBottom);
		JPanel panelBotLeft = new JPanel(new GridLayout(2, 1));
		panelBottom.add(panelBotLeft);
		panelBotLeft.add(txtAMoTa = new JTextArea("Chưa có mô tả"));
		txtAMoTa.setFont(new Font("Arial", Font.ITALIC, 14));
		
		JPanel panelTT = new JPanel(new GridLayout(4, 2));
		panelBotLeft.add(panelTT);
		
		JLabel lblTT1 = new JLabel("Khởi hành: ");
		lblTT1.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT1.setForeground(Color.BLUE);
		panelTT.add(lblTT1);
		
		panelTT.add(lblKhoiHanh = new JLabel("40/04/2023 12:00:00 PM"));
		lblKhoiHanh.setFont(new Font("Arial", Font.PLAIN, 14));
		lblKhoiHanh.setForeground(Color.BLUE);
		
		JLabel lblTT2 = new JLabel("Thời gian: ");
		lblTT2.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT2.setForeground(Color.BLUE);
		panelTT.add(lblTT2);
		
		panelTT.add(lblTime = new JLabel("5 ngày"));
		lblTime.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTime.setForeground(Color.BLUE);
		
		JLabel lblTT3 = new JLabel("Nơi khởi hành: ");
		lblTT3.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT3.setForeground(Color.BLUE);
		panelTT.add(lblTT3);
		
		panelTT.add(lblNoiKH = new JLabel("Hồ Chí Minh"));
		lblNoiKH.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNoiKH.setForeground(Color.BLUE);
		
		JLabel lblTT4 = new JLabel("Số chỗ còn nhận: ");
		lblTT4.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT4.setForeground(Color.BLUE);
		panelTT.add(lblTT4);
		
		panelTT.add(lblCho = new JLabel("20"));
		lblCho.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCho.setForeground(Color.BLUE);
		
		JPanel panelBotRight = new JPanel(new GridLayout(3, 3));
		panelBottom.add(panelBotRight);
		
		JLabel lblTT5 = new JLabel("Khách sạn");
		lblTT5.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT5.setForeground(Color.BLUE);
		JPanel pnTT5 = new JPanel(new FlowLayout());
		pnTT5.add(lblTT5);
		panelBotRight.add(pnTT5);
		
		JLabel lblTT6 = new JLabel("Phương tiện");
		lblTT6.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT6.setForeground(Color.BLUE);
		JPanel pnTT6 = new JPanel(new FlowLayout());
		pnTT6.add(lblTT6);
		panelBotRight.add(pnTT6);
		
		JLabel lblTT7 = new JLabel("Điểm tham quan");
		lblTT7.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT7.setForeground(Color.BLUE);
		JPanel pnTT7 = new JPanel(new FlowLayout());
		pnTT7.add(lblTT7);
		panelBotRight.add(pnTT7);
		
		
		ImageIcon hinh5 = new ImageIcon("Img/hotels.png");
		Image image5 = hinh5.getImage();
		Image scaledImage5= image5.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(scaledImage5);
		JLabel lblHinh5 = new JLabel(scaledIcon5);
		panelBotRight.add(lblHinh5);
		
		ImageIcon hinh6 = new ImageIcon("Img/bus.png");
		Image image6 = hinh6.getImage();
		Image scaledImage6= image6.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
		JLabel lblHinh6 = new JLabel(scaledIcon6);
		panelBotRight.add(lblHinh6);
		
		ImageIcon hinh7 = new ImageIcon("Img/location.png");
		Image image7 = hinh7.getImage();
		Image scaledImage7= image7.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7= new ImageIcon(scaledImage7);
		JLabel lblHinh7 = new JLabel(scaledIcon7);
		panelBotRight.add(lblHinh7);
		
		JPanel pnTT8 = new JPanel(new FlowLayout());
		pnTT8.add(lblKhachSan = new JLabel("Khách sạn 3s"));
		panelBotRight.add(pnTT8);
		
		JPanel pnTT9 = new JPanel(new FlowLayout());
		pnTT9.add(lblPhuongTien = new JLabel("Máy bay"));
		panelBotRight.add(pnTT9);
		
		JPanel pnTT10 = new JPanel(new FlowLayout());
		pnTT10.add(lblNoiDen = new JLabel("Phú Quốc"));
		panelBotRight.add(pnTT10);
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDonHang.addActionListener(this);
		btnQuanLi.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnTrangChu) {
			setVisible(false);
			new Home_GUI().setVisible(true);
		}else if(o==btnDonHang) {
			
		}else if(o==btnQuanLi){
			
		}else if(o==btnTour) {
			
		}
	}
	public static void main(String[] args) {
		new Tour_GUI().setVisible(true);
	}
}	
