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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import BUS.DiaDiem_Bus;
import BUS.HoaDon_Bus;
import BUS.PhuongTien_Bus;
import BUS.Tour_Bus;
import ConnectDB.ConnectDB;
import Entity.DiaDiem;
import Entity.NhanVien;
import Entity.PhuongTien;
import Entity.TourDuLich;
import Util.CodeGenerator;

public class Tour_GUI extends JFrame implements ActionListener, MouseListener{
	private JButton btnTrangChu, btnTour, btnDonHang, btnKH, btnQuanLi, btnNhanVien,btnLoc, btnReset, btnTim, btnDatTour;
	private JTextField txtTim;
	private JTextArea txtAMoTa;
	private JLabel lblTourTim, lblTitleTour, lblGia, lblKhoiHanh, lblTime, lblNoiKH, lblCho, lblKhachSan, lblPhuongTien,lblNoiDen;
	private JLabel lblHinh1, lblHinh2, lblHinh3, lblHinh4;
	private JComboBox<DiaDiem> cmbDi, cmbDen;
	private JComboBox<Integer> cmbSoNgay;
	private JComboBox<PhuongTien> cmbPhuongTien;
	private JDatePickerImpl datePicker;
	private SpinnerModel modelSpin;
	private JSpinner spinner;
	private DefaultTableModel tblModel;
	private JTable tblTour;
	private JTableHeader tblHead;
	private ArrayList<TourDuLich> dsTour;
	private JFrame frameDatTour;
	private Tour_Bus tourBus;
	private HoaDon_Bus hdBus;
	private DiaDiem_Bus ddBus;
	private PhuongTien_Bus ptBus;
	private NhanVien nv;
	
	public Tour_GUI(NhanVien nv) {
		setTitle("Vietour - Phan mem quan li tour du lich");
		setSize(1200, 820);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/travel.png"));
		dsTour = new ArrayList<TourDuLich>();
		tourBus = new Tour_Bus();
		hdBus = new HoaDon_Bus();
		ddBus = new DiaDiem_Bus();
		ptBus = new PhuongTien_Bus();
		this.nv = nv;
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnTour = new JButton("Tour", imgTour));
		btnTour.setFont(new Font("Arial", Font.BOLD, 14));
		btnTour.setBackground(Color.WHITE);
		btnTour.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTour.setBackground(new Color(255, 165, 0));
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
		panelHead.add(btnNhanVien = new JButton(": "+nv.getTenNV(), imgUser));
		btnNhanVien.setBackground(new Color(250,  128, 144));
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 12));
		
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
		for(DiaDiem dd : ddBus.getAllDiemDi()) {
			cmbDi.addItem(dd);
		}
		
		JLabel lblDiemDen = new JLabel("Điểm đến");
		lblDiemDen.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiemDen.setForeground(new Color(0, 102, 204));
		panelSearch.add(lblDiemDen);
		panelSearch.add(cmbDen = new JComboBox<DiaDiem>());
		for(DiaDiem dd : ddBus.getAllDiemDuLich()) {
			cmbDen.addItem(dd);
		}
		
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
		datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		panelSearch.add(datePicker);
		
		JLabel lblSoNguoi = new JLabel("Số người");
		lblSoNguoi.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoNguoi.setForeground(new Color(0, 102, 204));
		panelSearch.add(lblSoNguoi);
		modelSpin = new SpinnerNumberModel(1, 1, null, 1);
		spinner = new JSpinner(modelSpin);
		panelSearch.add(spinner);
		
		JLabel lblPT = new JLabel("Thông tin vận chuyển");
		lblPT.setFont(new Font("Arial", Font.BOLD, 14));
		lblPT.setForeground(new Color(0, 102, 204));
		panelSearch.add(lblPT);
		panelSearch.add(cmbPhuongTien = new JComboBox<PhuongTien>());
		for(PhuongTien pt : ptBus.getAllPhuongTien()) {
			cmbPhuongTien.addItem(pt);
		}
		
		JPanel panelBtn = new JPanel(new FlowLayout());
		panelBtn.add(btnLoc = new JButton("Lọc", new ImageIcon("img/loc.png")));
		btnLoc.setFont(new Font("Arial", Font.BOLD, 14));
		btnLoc.setForeground(Color.WHITE);
		btnLoc.setBackground(new Color(30, 144, 255));
		btnLoc.setBorder(new EmptyBorder(5, 10, 5, 10));
		panelBtn.add(Box.createHorizontalStrut(10));
		panelBtn.add(btnReset = new JButton("Reset", new ImageIcon("Img/reset-icon.png")));
		btnReset.setFont(new Font("Arial", Font.BOLD, 14));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 144, 255));
		btnReset.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		panelSearch.add(panelBtn);
		btnReset.setPreferredSize(new Dimension(100, 27));
		btnLoc.setPreferredSize(btnReset.getPreferredSize());
		
		//form ds tour và chi tiết tour
		JPanel panelThongTin = new JPanel();
		panelThongTin.setLayout(new BoxLayout(panelThongTin, BoxLayout.Y_AXIS));
		add(panelThongTin, BorderLayout.CENTER);
		
		JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelThongTin.add(panelTop);
		
		panelTop.add(Box.createHorizontalStrut(20));
		panelTop.add(txtTim=new JTextField(20));
		txtTim.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTim.setToolTipText("Tìm theo mã tour hoặc tên tour");
		txtTim.setBorder(new CompoundBorder(
			    new MatteBorder(0, 0, 2, 0, new Color(0, 250, 154)),
			    new EmptyBorder(5, 10, 5, 10)
			));
		panelTop.add(Box.createHorizontalStrut(10));
		panelTop.add(btnTim = new JButton("Tìm", new ImageIcon("Img/search-icon.png")));
		btnTim.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		btnTim.setForeground(Color.WHITE);
		btnTim.setBackground(new Color(30, 144, 255));
		panelTop.add(Box.createHorizontalStrut(10));
		panelTop.add(lblTourTim = new JLabel());
		
		String cols[] = {"Mã Tour", "Tên Tour", "Số chỗ", "Ngày đi", "Ngày kết thúc", "Giá tour"};
		tblModel = new DefaultTableModel(cols, 0);
		tblTour = new JTable(tblModel);
		tblTour.setFont(new Font("Arial", Font.PLAIN, 14));
		
		tblHead = new JTableHeader(tblTour.getColumnModel());
		tblHead.setReorderingAllowed(false);
		tblHead.setBackground(new Color(30, 144, 255));
		tblHead.setForeground(Color.WHITE);
		tblHead.setFont(new Font("Arial", Font.BOLD, 14));
		tblTour.setTableHeader(tblHead);
		
		tblTour.setRowHeight(20);
		tblTour.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblTour.getColumnModel().getColumn(0).setPreferredWidth(75);
		tblTour.getColumnModel().getColumn(1).setPreferredWidth(350);
		tblTour.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblTour.getColumnModel().getColumn(3).setPreferredWidth(125);
		tblTour.getColumnModel().getColumn(4).setPreferredWidth(125);
		tblTour.getColumnModel().getColumn(5).setPreferredWidth(150);
		tblTour.setSize(MAXIMIZED_HORIZ, 150);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		tblTour.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		tblTour.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		tblTour.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblTour.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		JScrollPane tblScroll = new JScrollPane(tblTour,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tblScroll.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 100));
		panelThongTin.add(Box.createVerticalStrut(5));
		panelThongTin.add(tblScroll);
		panelThongTin.add(Box.createVerticalStrut(5));
		
		//chi tiet tour
		//JPanel panelChiTiet = new JPanel();
		JPanel panelTitleTour = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 20)) ;
		panelThongTin.add(panelTitleTour);
		panelTitleTour.add(lblTitleTour = new JLabel("[TXXX]Tour XXX"));
		lblTitleTour.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitleTour.setForeground(new Color(0, 0, 255));
		
		panelTitleTour.add(lblGia = new JLabel("x.xxx.000"+"/khach"));
		lblGia.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGia.setForeground(new Color(30,144,255));
		panelTitleTour.add(btnDatTour = new JButton("Đặt Tour", new ImageIcon("img/booking.png")));
		btnDatTour.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnDatTour.setFont(new Font("Arial", Font.BOLD, 18));
		btnDatTour.setBounds(0, 0, 100, 50);
		btnDatTour.setForeground(Color.WHITE);
		btnDatTour.setBackground(new Color(30,144,255));
		
		//hinh anh
		JPanel panelImage = new JPanel(new GridLayout(1, 2));
		panelThongTin.add(panelImage);
		ImageIcon hinh1 = new ImageIcon("Img/noimagefound.png");
		Image image1 = hinh1.getImage();
		Image scaledImage1 = image1.getScaledInstance(550, 300, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
		lblHinh1 = new JLabel(scaledIcon1);
		panelImage.add(lblHinh1);
		
		JPanel panelImageRight = new JPanel(new GridLayout(2, 1));
		panelImage.add(panelImageRight);
		
		JPanel panelImageTop = new JPanel(new GridLayout(1, 2));
		panelImageRight.add(panelImageTop);
		
		Image scaledImage2= image1.getScaledInstance(230, 140, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		lblHinh2 = new JLabel(scaledIcon2);
		panelImageTop.add(lblHinh2);
		lblHinh3 = new JLabel(scaledIcon2);
		panelImageTop.add(lblHinh3);
		
		Image scaledImage4= image1.getScaledInstance(470, 150, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
		lblHinh4 = new JLabel(scaledIcon4);
		panelImageRight.add(lblHinh4);
		
		JPanel panelBottom = new JPanel(new GridLayout(1, 2));
		panelThongTin.add(Box.createVerticalStrut(5));
		panelThongTin.add(panelBottom);
		JPanel panelBotLeft = new JPanel(new GridLayout(2, 1));
		panelBottom.add(panelBotLeft);
		txtAMoTa = new JTextArea("Không có mô tả");
		JScrollPane scrollMoTa = new JScrollPane(txtAMoTa, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollMoTa.setPreferredSize(new Dimension(500, 50));
		scrollMoTa.setBorder(BorderFactory.createEmptyBorder());
		panelBotLeft.add(scrollMoTa);
		txtAMoTa.setFont(new Font("Arial", Font.ITALIC, 14));
		txtAMoTa.setWrapStyleWord(true);
		txtAMoTa.setLineWrap(true);
		txtAMoTa.setEditable(false);
		
		JPanel panelTT = new JPanel(new GridLayout(4, 2));
		panelBotLeft.add(panelTT);
		
		JLabel lblTT1 = new JLabel("Khởi hành: ");
		lblTT1.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT1.setForeground(Color.BLUE);
		panelTT.add(lblTT1);
		
		panelTT.add(lblKhoiHanh = new JLabel("..."));
		lblKhoiHanh.setFont(new Font("Arial", Font.PLAIN, 14));
		lblKhoiHanh.setForeground(Color.BLUE);
		
		JLabel lblTT2 = new JLabel("Thời gian: ");
		lblTT2.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT2.setForeground(Color.BLUE);
		panelTT.add(lblTT2);
		
		panelTT.add(lblTime = new JLabel("..."));
		lblTime.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTime.setForeground(Color.BLUE);
		
		JLabel lblTT3 = new JLabel("Nơi khởi hành: ");
		lblTT3.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT3.setForeground(Color.BLUE);
		panelTT.add(lblTT3);
		
		panelTT.add(lblNoiKH = new JLabel("..."));
		lblNoiKH.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNoiKH.setForeground(Color.BLUE);
		
		JLabel lblTT4 = new JLabel("Số chỗ còn nhận: ");
		lblTT4.setFont(new Font("Arial", Font.BOLD, 16));
		lblTT4.setForeground(Color.BLUE);
		panelTT.add(lblTT4);
		
		panelTT.add(lblCho = new JLabel("..."));
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
		pnTT8.add(lblKhachSan = new JLabel());
		panelBotRight.add(pnTT8);
		
		JPanel pnTT9 = new JPanel(new FlowLayout());
		pnTT9.add(lblPhuongTien = new JLabel());
		panelBotRight.add(pnTT9);
		
		JPanel pnTT10 = new JPanel(new FlowLayout());
		pnTT10.add(lblNoiDen = new JLabel());
		panelBotRight.add(pnTT10);
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDonHang.addActionListener(this);
		btnQuanLi.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnKH.addActionListener(this);
		
		tblTour.addMouseListener(this);
		btnLoc.addActionListener(this);
		btnTim.addActionListener(this);
		btnDatTour.addActionListener(this);
		btnReset.addActionListener(this);
		tblHead.addMouseListener(this);
		
		btnTrangChu.addMouseListener(this);
		btnTour.addMouseListener(this);
		btnDonHang.addMouseListener(this);
		btnKH.addMouseListener(this);
		btnQuanLi.addMouseListener(this);
		btnNhanVien.addMouseListener(this);
		btnLoc.addMouseListener(this);
		btnTim.addMouseListener(this);
		btnDatTour.addMouseListener(this);
		btnReset.addMouseListener(this);
		
		dsTour = tourBus.getTourGanNhat();
		dataArrayToTable(dsTour);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnTrangChu) {
			setVisible(false);
			new Home_GUI(nv).setVisible(true);
		}else if(o==btnDonHang) {
			setVisible(false);
			new QuanLiHoaDon_GUI(nv).setVisible(true);
		}else if(o==btnQuanLi){
			setVisible(false);
			new QuanLiTour_GUI(nv).setVisible(true);
		}else if(o==btnTour) {
			setVisible(false);
			new Tour_GUI(nv).setVisible(true);
		}else if(o==btnNhanVien){
			setVisible(false);
			new NhanVien_GUI(nv).setVisible(true);
		}else if(o==btnKH){
			setVisible(false);
			new KhachHang_GUI(nv).setVisible(true);
		}else if(o==btnLoc) {
			locTour();
		}else if(o==btnReset) {
			reset();
		}else if(o==btnTim) {
			timTour();
		}else if(o==btnDatTour) {
			int index = tblTour.getSelectedRow();
			if(index!=-1) {
				if(validData()) {
					frameDatTour = new DatTour_GUI(dsTour.get(index), nv);
					frameDatTour.setVisible(true);
				}
			}else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn Tour muốn đặt!");
			}
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o==tblTour) {
			int r = tblTour.getSelectedRow();
			lblTitleTour.setText("["+tblModel.getValueAt(r, 0)+"] "+ tblModel.getValueAt(r, 1));
			lblGia.setText(tblModel.getValueAt(r, 5).toString()+"đ/khách");
			
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
			lblKhoiHanh.setText(tblModel.getValueAt(r, 3).toString());
			
			//tinh so ngay
			java.util.Date startDate = null, endDate = null;
			
			try {
				startDate = inputFormat.parse(dsTour.get(r).getNgayDi().toString());
				endDate = inputFormat.parse(dsTour.get(r).getNgayKetThuc().toString());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			long differenceInMillis = endDate.getTime() - startDate.getTime();
			long differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);
			lblTime.setText(String.valueOf(differenceInDays) + "ngày");
			
			lblNoiKH.setText(dsTour.get(r).getDiemKH().getTenDiaDiem());
			
			int soCho = dsTour.get(r).getSoCho();
			lblCho.setText(String.valueOf(soCho-hdBus.getSoLuongKhach(dsTour.get(r).getMaTour())));
			
			txtAMoTa.setText(dsTour.get(r).getMoTa());
			for(int i=0; i< cmbPhuongTien.getItemCount(); i++)
				if(cmbPhuongTien.getItemAt(i).getMaPT().equalsIgnoreCase(dsTour.get(r).getPhuongTien().getMaPT()))
					lblPhuongTien.setText(cmbPhuongTien.getItemAt(i).getTenPT());
			lblKhachSan.setText(dsTour.get(r).getKhachSan());
			lblNoiDen.setText(dsTour.get(r).getDiemDen().getTenDiaDiem());
			
			//hien thi hinh anh
			try {
				ImageIcon hinh1 = new ImageIcon(dsTour.get(r).getDsAnh().get(0));
				Image image1 = hinh1.getImage();
				Image scaledImage1 = image1.getScaledInstance(550, 300, Image.SCALE_SMOOTH);
				ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
				lblHinh1.setIcon(scaledIcon1);
				
				ImageIcon hinh2 = new ImageIcon(dsTour.get(r).getDsAnh().get(1));
				Image image2 = hinh2.getImage();
				Image scaledImage2= image2.getScaledInstance(230, 140, Image.SCALE_SMOOTH);
				ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
				lblHinh2.setIcon(scaledIcon2);
		
				ImageIcon hinh3 = new ImageIcon(dsTour.get(r).getDsAnh().get(2));
				Image image3 = hinh3.getImage();
				Image scaledImage3= image3.getScaledInstance(230, 140, Image.SCALE_SMOOTH);
				ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
				lblHinh3.setIcon(scaledIcon3);
				
				ImageIcon hinh4 = new ImageIcon(dsTour.get(r).getDsAnh().get(3));
				Image image4 = hinh4.getImage();
				Image scaledImage4= image4.getScaledInstance(470, 150, Image.SCALE_SMOOTH);
				ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
				lblHinh4.setIcon(scaledIcon4);
			} catch (Exception e1) {
				// TODO: handle exception
			}
		}else if(o==tblHead) {
			int col = tblHead.columnAtPoint(e.getPoint());
			switch(col) {
			case 0:
				Collections.sort(dsTour, Comparator.comparing(tour->((TourDuLich)tour).getMaTour()));
				break;
			case 1:
				Collections.sort(dsTour, Comparator.comparing(tour->((TourDuLich)tour).getTenTour()));
				break;
			case 2:
				Collections.sort(dsTour, Comparator.comparing(tour->((TourDuLich)tour).getSoCho()));
				break;
			case 3:
				Collections.sort(dsTour, Comparator.comparing(tour->((TourDuLich)tour).getNgayDi()));
				break;
			case 4:
				Collections.sort(dsTour, Comparator.comparing(tour->((TourDuLich)tour).getNgayKetThuc()));
				break;
			case 5:
				Collections.sort(dsTour, Comparator.comparing(tour->((TourDuLich)tour).getGia()));
				break;
			}
			paintColumnSelected(col);
			dataArrayToTable(dsTour);
		}
	}
	public void dataArrayToTable(ArrayList<TourDuLich> dsTour) {
		tblModel.setRowCount(0);
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
		DecimalFormat df = new DecimalFormat("#,###.##");
		for(TourDuLich x : dsTour) {
			tblModel.addRow(new Object[] {x.getMaTour(), x.getTenTour(), x.getSoCho(), outputFormat.format(x.getNgayDi()) , outputFormat.format(x.getNgayKetThuc()) , df.format(x.getGia()) });
		}
	}
	public void paintColumnSelected(int col) {
		DefaultTableCellRenderer colorWhiteRenderer = new DefaultTableCellRenderer();
		colorWhiteRenderer.setBackground(Color.WHITE);
		for(int i=0;i<6;i++) {
			tblTour.getColumnModel().getColumn(i).setCellRenderer(colorWhiteRenderer);
		}
		DefaultTableCellRenderer colorSelectedRenderer = new DefaultTableCellRenderer();
		colorSelectedRenderer.setBackground(new Color(255, 255, 224));
		tblTour.getColumnModel().getColumn(col).setCellRenderer(colorSelectedRenderer);
	}
	public void reset() {
		cmbDi.setSelectedIndex(0);
		cmbDen.setSelectedIndex(0);
		cmbSoNgay.setSelectedIndex(0);
		cmbPhuongTien.setSelectedIndex(0);
		spinner.setValue(1);
		UtilDateModel model = (UtilDateModel) datePicker.getModel();
		model.setValue(null);
		model.setSelected(false);
		txtTim.setText(null);
		lblTourTim.setText(null);
		dsTour = tourBus.getTourGanNhat();
		dataArrayToTable(dsTour);
	}
	public void timTour() {
		String maTim = txtTim.getText();
		ArrayList<TourDuLich>	dsTim = tourBus.timTour(maTim);
		if(dsTim!=null) {
			dsTour = dsTim;
			dataArrayToTable(dsTour);
			lblTourTim.setText( "Đã tìm được "+dsTim.size()+" Tour.");
		}else {
			lblTourTim.setText( "Không tìm thấy tour phù hợp !");
		}
	}
	public void locTour() {
		DiaDiem diemDi = (DiaDiem) cmbDi.getSelectedItem();
		DiaDiem diemDen = (DiaDiem) cmbDen.getSelectedItem();
		int soNgay = Integer.parseInt(cmbSoNgay.getSelectedItem().toString());
		int soNguoi = Integer.parseInt(spinner.getValue().toString());
		PhuongTien phuongTien = (PhuongTien) cmbPhuongTien.getSelectedItem();
		
		DateModel<?> model = datePicker.getModel();
		int day = model.getDay();
		int month = model.getMonth();
		int year = model.getYear();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		java.sql.Date date = new java.sql.Date(calendar.getTimeInMillis());
		
		ArrayList<TourDuLich>	dsLoc = tourBus.locTour(diemDi.getMaDiaDiem(), diemDen.getMaDiaDiem(), soNgay, date, soNguoi, phuongTien.getMaPT());
		if(dsLoc.size()>0) {
			dsTour = dsLoc;
			dataArrayToTable(dsTour);
			lblTourTim.setText( "Đã tìm được "+dsLoc.size()+" Tour phù hợp.");
		}else {
			lblTourTim.setText( "Không tìm thấy tour phù hợp !");
		}
	}
	public boolean validData() {
		int index = tblTour.getSelectedRow();
		if(Date.valueOf(LocalDate.now()).after(dsTour.get(index).getNgayDi())) {
			JOptionPane.showMessageDialog(this, "Tour đã đi! Không thể đặt!");
			return false;
		}
		int soCho = dsTour.get(index).getSoCho();
		int conLai = soCho-hdBus.getSoLuongKhach(dsTour.get(index).getMaTour());
		if(conLai<=0) {
			JOptionPane.showMessageDialog(this, "Đã hết chỗ!");
			return false;
		}
		return true;
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
		if(e.getSource()!=tblTour &&  e.getSource()!=tblHead) {
			JButton button = (JButton) e.getSource();
			button.setBorder(new CompoundBorder(
					    new MatteBorder(0, 0, 2, 0, new Color(220, 20, 60)),
					    button.getBorder()
					));
		}	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()!=tblTour && e.getSource()!=tblHead) {
			JButton button = (JButton) e.getSource();
			if(e.getSource()==btnTrangChu || e.getSource()==btnTour || e.getSource()==btnDonHang || e.getSource()==btnKH || e.getSource()==btnQuanLi)
			    button.setBorder(new CompoundBorder(
					    new MatteBorder(0, 0, 0, 0, new Color(255, 69, 0)),
					    new EmptyBorder(10, 10, 10, 10)
					));
			else if(e.getSource()==btnNhanVien)
			    button.setBorder(new CompoundBorder(
					    new MatteBorder(0, 0, 0, 0, new Color(255, 69, 0)),
					    BorderFactory.createEmptyBorder(5, 10, 5, 10)
					));
			else if(e.getSource()==btnTim){
				button.setBorder(new CompoundBorder(
					    new MatteBorder(0, 0, 0, 0, new Color(255, 69, 0)),
					    BorderFactory.createEmptyBorder(5, 20, 5, 20)
					));
			}
			else if(e.getSource()==btnDatTour){
				button.setBorder(new CompoundBorder(
					    new MatteBorder(0, 0, 0, 0, new Color(255, 69, 0)),
					    BorderFactory.createEmptyBorder(10, 20, 10, 20)
					));
			}else if(e.getSource()==btnReset || e.getSource()==btnLoc){
				button.setBorder(new CompoundBorder(
					    new MatteBorder(0, 0, 0, 0, new Color(255, 69, 0)),
					    BorderFactory.createEmptyBorder(5, 10, 5, 10)
					));
			}
		}
	}
}	
