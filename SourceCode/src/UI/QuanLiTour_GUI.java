package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
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
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jdatepicker.DateModel;
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

public class QuanLiTour_GUI extends JFrame implements ActionListener, MouseListener{
	private JButton btnTrangChu, btnTour, btnDiaDiem, btnThongKe, btnNhanVien;
	private JLabel lblKhachSan, lblPhuongTien,lblNoiDen,lblCho,lblNoiKH,lblTime,lblKhoiHanh,lblHinh1, lblHinh2, lblHinh3, lblHinh4, lblTourTim, lblGia, lblTitleTour;
	private JTextArea txtAMoTa, txtAInputMoTa;
	private JTable tblTour;
	private DefaultTableModel tblModel;
	private JTableHeader tblHead;
	private JButton btnTim;
	private JTextField txtMaTour, txtTenTour, txtGia ,txtTim;
	private JComboBox<PhuongTien> cmbPhuongTien;
	private JComboBox<DiaDiem> cmbDiemKH, cmbDiemDen;
	private JComboBox<String> cmbKhachSan;
	private SpinnerModel modelSpin;
	private JSpinner spinSoCho;
	private JDatePickerImpl ngayKH, ngayKT;
	private JButton btnThem, btnSua, btnReset, btnXoa, btnAnh1, btnAnh2, btnAnh3, btnAnh4;
	private DiaDiem_Bus dd_Bus;
	private Tour_Bus tour_Bus;
	private HoaDon_Bus hd_Bus;
	private PhuongTien_Bus ptBus;
	private ArrayList<TourDuLich> dsTour;
	private ArrayList<String> dsAnh;
	private CodeGenerator maTourGenerator;
	private NhanVien nv;
	
	public QuanLiTour_GUI(NhanVien nv) {
		setTitle("Vietour - Phan mem quan li tour du lich");
		setSize(1200, 820);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/travel.png"));
		this.nv = nv;
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hd_Bus  = new HoaDon_Bus();
		dd_Bus = new DiaDiem_Bus();
		tour_Bus = new Tour_Bus();
		ptBus = new PhuongTien_Bus();
		maTourGenerator = new CodeGenerator();
		createGUI();
		
	}
	public void createGUI() {
		//menu
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
		
		ImageIcon imgTour = new ImageIcon("img/add.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnTour = new JButton("Tour", imgTour));
		btnTour.setFont(new Font("Arial", Font.BOLD, 14));
		btnTour.setBackground(Color.WHITE);
		btnTour.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTour.setBackground(new Color(255, 165, 0));
		btnTour.setForeground(new Color(255, 255, 255));
		btnTour.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgLogo = new ImageIcon("img/vietour_logo.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(new JLabel(imgLogo));
		
		ImageIcon imgHD = new ImageIcon("img/locationadd.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnDiaDiem = new JButton("Địa Điểm", imgHD));
		btnDiaDiem.setFont(new Font("Arial", Font.BOLD, 14));
		btnDiaDiem.setBackground(Color.WHITE);
		btnDiaDiem.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnDiaDiem.setBackground(new Color(60, 179, 113));
		btnDiaDiem.setForeground(new Color(255, 255, 255));
		btnDiaDiem.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgKH = new ImageIcon("img/trend.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnThongKe = new JButton("Thống Kê", imgKH));
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btnThongKe.setBackground(Color.WHITE);
		btnThongKe.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnThongKe.setBackground(new Color(60, 179, 113));
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setPreferredSize(btnThongKe.getPreferredSize());
		
		panelHead.add(Box.createHorizontalStrut(20));
		ImageIcon imgUser = new ImageIcon("img/user.png");
		panelHead.add(btnNhanVien = new JButton(": "+nv.getTenNV(), imgUser));
		btnNhanVien.setBackground(new Color(250,  128, 144));
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 12));
		
		//thao tac them,xoa,sua,reset
		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));
		panelAdd.setBorder(BorderFactory.createTitledBorder("Thông tin Tour"));
		JScrollPane scrollAdd = new JScrollPane(panelAdd, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollAdd.getVerticalScrollBar().setUnitIncrement(15);
		add(scrollAdd, BorderLayout.WEST);
		
		JPanel pnMa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMa = new JLabel("Mã Tour");
		lblMa.setFont(new Font("Arial", Font.BOLD, 14));
		lblMa.setForeground(new Color(0, 102, 204));
		pnMa.add(lblMa);
		panelAdd.add(pnMa);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtMaTour=new JTextField());
		panelAdd.add(Box.createVerticalStrut(5));
		txtMaTour.setEditable(false);
		
		JPanel pnTen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTenTour = new JLabel("Tên Tour");
		lblTenTour.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenTour.setForeground(new Color(0, 102, 204));
		pnTen.add(lblTenTour);
		panelAdd.add(pnTen);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtTenTour=new JTextField());
		txtTenTour.setPreferredSize(txtMaTour.getPreferredSize());
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnMoTa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMoTa = new JLabel("Mô tả");
		lblMoTa.setFont(new Font("Arial", Font.BOLD, 14));
		lblMoTa.setForeground(new Color(0, 102, 204));
		pnMoTa.add(lblMoTa);
		panelAdd.add(pnMoTa);
		panelAdd.add(Box.createVerticalStrut(5));
		txtAInputMoTa = new JTextArea(5,0);
		JScrollPane scrollMoTaInput = new JScrollPane(txtAInputMoTa, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollMoTaInput.setPreferredSize(new Dimension(150, 50));
		scrollMoTaInput.setBorder(BorderFactory.createEmptyBorder());
		txtAInputMoTa.setFont(new Font("Arial", Font.ITALIC, 14));
		txtAInputMoTa.setWrapStyleWord(true);
		txtAInputMoTa.setLineWrap(true);
		panelAdd.add(scrollMoTaInput);
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnSoCho = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSoCho = new JLabel("Số chỗ");
		lblSoCho.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoCho.setForeground(new Color(0, 102, 204));
		pnSoCho.add(lblSoCho);
		panelAdd.add(pnSoCho);
		panelAdd.add(Box.createVerticalStrut(5));
		modelSpin = new SpinnerNumberModel(20, 1, 60, 1);
		spinSoCho = new JSpinner(modelSpin);
		panelAdd.add(spinSoCho);
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnNgayDi = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNgayDi = new JLabel("Ngày đi");
		lblNgayDi.setFont(new Font("Arial", Font.BOLD, 14));
		lblNgayDi.setForeground(new Color(0, 102, 204));
		pnNgayDi.add(lblNgayDi);
		panelAdd.add(pnNgayDi);
		panelAdd.add(Box.createVerticalStrut(5));
		UtilDateModel model = new UtilDateModel();
		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		JDatePanelImpl datePanelKH = new JDatePanelImpl(model, properties);
		ngayKH = new JDatePickerImpl(datePanelKH, new DateComponentFormatter());
		panelAdd.add(ngayKH);
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnNgayKT= new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNgayKT = new JLabel("Ngày kết thúc");
		lblNgayKT.setFont(new Font("Arial", Font.BOLD, 14));
		lblNgayKT.setForeground(new Color(0, 102, 204));
		pnNgayKT.add(lblNgayKT);
		panelAdd.add(pnNgayKT);
		panelAdd.add(Box.createVerticalStrut(5));
		UtilDateModel modelKT = new UtilDateModel();
		Properties propertiesKT = new Properties();
		propertiesKT.put("text.today", "Today");
		propertiesKT.put("text.month", "Month");
		propertiesKT.put("text.year", "Year");
		JDatePanelImpl datePanelKT = new JDatePanelImpl(modelKT, propertiesKT);
		ngayKT = new JDatePickerImpl(datePanelKT, new DateComponentFormatter());
		panelAdd.add(ngayKT);
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnPT = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPT = new JLabel("Phương Tiện");
		lblPT.setFont(new Font("Arial", Font.BOLD, 14));
		lblPT.setForeground(new Color(0, 102, 204));
		pnPT.add(lblPT);
		panelAdd.add(pnPT);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(cmbPhuongTien = new JComboBox<PhuongTien>());
		for(PhuongTien pt : ptBus.getAllPhuongTien()) {
			cmbPhuongTien.addItem(pt);
		}
		
		JPanel pnDiemDi = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDiemDi = new JLabel("Điểm khởi hành");
		lblDiemDi.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiemDi.setForeground(new Color(0, 102, 204));
		pnDiemDi.add(lblDiemDi);
		panelAdd.add(pnDiemDi);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(cmbDiemKH = new JComboBox<DiaDiem>());
		for(DiaDiem dd : dd_Bus.getAllDiemDi()) {
			cmbDiemKH.addItem(dd);
		}
		
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnDiemDen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDiemDen = new JLabel("Điểm đến");
		lblDiemDen.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiemDen.setForeground(new Color(0, 102, 204));
		pnDiemDen.add(lblDiemDen);
		panelAdd.add(pnDiemDen);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(cmbDiemDen = new JComboBox<DiaDiem>());
		for(DiaDiem dd : dd_Bus.getAllDiemDuLich()) {
			cmbDiemDen.addItem(dd);
		}
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnKS = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblKS = new JLabel("Khách sạn");
		lblKS.setFont(new Font("Arial", Font.BOLD, 14));
		lblKS.setForeground(new Color(0, 102, 204));
		pnKS.add(lblKS);
		panelAdd.add(pnKS);
		panelAdd.add(Box.createVerticalStrut(5));
		String khachSan[] = {"Khách sạn 5 sao", "Khách sạn 4 sao", "Khách sạn 3 sao", "Khách sạn 2 sao", "Khách sạn 1 sao"};
		panelAdd.add(cmbKhachSan= new JComboBox<>(khachSan));
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnGia = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGiaTour = new JLabel("Giá Tour");
		lblGiaTour.setFont(new Font("Arial", Font.BOLD, 14));
		lblGiaTour.setForeground(new Color(0, 102, 204));
		pnGia.add(lblGiaTour);
		panelAdd.add(pnGia);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtGia=new JTextField());
		panelAdd.add(Box.createVerticalStrut(5));
		
		Box b1 = Box.createHorizontalBox();
		JLabel lblAnh1 = new JLabel("Ảnh 1:");
		lblAnh1.setFont(new Font("Arial", Font.BOLD, 14));
		lblAnh1.setForeground(new Color(0, 102, 204));
		b1.add(lblAnh1);
		b1.add(btnAnh1=new JButton(new ImageIcon("Img/add-image.png")));
		btnAnh1.setForeground(Color.WHITE);
		btnAnh1.setBackground(new Color(95, 158, 160));
		btnAnh1.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 7));
		b1.add(Box.createHorizontalStrut(5));
		JLabel lblAnh2 = new JLabel("Ảnh 2:");
		lblAnh2.setFont(new Font("Arial", Font.BOLD, 14));
		lblAnh2.setForeground(new Color(0, 102, 204));
		b1.add(lblAnh2);
		b1.add(btnAnh2=new JButton(new ImageIcon("Img/add-image.png")));
		btnAnh2.setForeground(Color.WHITE);
		btnAnh2.setBackground(new Color(95, 158, 160));
		btnAnh2.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 7));
		b1.add(Box.createHorizontalStrut(5));
		panelAdd.add(b1);
		panelAdd.add(Box.createVerticalStrut(5));
		
		Box b2 = Box.createHorizontalBox();
		JLabel lblAnh3 = new JLabel("Ảnh 3:");
		lblAnh3.setFont(new Font("Arial", Font.BOLD, 14));
		lblAnh3.setForeground(new Color(0, 102, 204));
		b2.add(lblAnh3);
		b2.add(btnAnh3=new JButton(new ImageIcon("Img/add-image.png")));
		btnAnh3.setForeground(Color.WHITE);
		btnAnh3.setBackground(new Color(95, 158, 160));
		btnAnh3.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 7));
		b2.add(Box.createHorizontalStrut(5));
		JLabel lblAnh4 = new JLabel("Ảnh 4:");
		lblAnh4.setFont(new Font("Arial", Font.BOLD, 14));
		lblAnh4.setForeground(new Color(0, 102, 204));
		b2.add(lblAnh4);
		b2.add(btnAnh4=new JButton(new ImageIcon("Img/add-image.png")));
		btnAnh4.setForeground(Color.WHITE);
		btnAnh4.setBackground(new Color(95, 158, 160));
		btnAnh4.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 7));
		b2.add(Box.createHorizontalStrut(5));
		panelAdd.add(b2);
		panelAdd.add(Box.createVerticalStrut(20));
		
		btnAnh1.setPreferredSize(new Dimension(50, 50));
		btnAnh2.setPreferredSize(new Dimension(50, 50));
		btnAnh3.setPreferredSize(new Dimension(50, 50));
		btnAnh4.setPreferredSize(new Dimension(50, 50));
		
		JPanel pnButtonTop = new JPanel(new FlowLayout());
		pnButtonTop.add(btnThem=new JButton("Thêm"));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		pnButtonTop.add(btnSua=new JButton("Sửa"));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		panelAdd.add(pnButtonTop);
		
		JPanel pnButtonBot = new JPanel(new FlowLayout());
		pnButtonBot.add(btnXoa=new JButton("Xóa"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		pnButtonBot.add(btnReset=new JButton("Reset"));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 144, 255));
		btnReset.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		panelAdd.add(pnButtonBot);
		
		btnThem.setPreferredSize(btnReset.getPreferredSize());
		btnSua.setPreferredSize(btnReset.getPreferredSize());
		btnXoa.setPreferredSize(btnReset.getPreferredSize());
		//form ds tour và chi tiết tour
		JPanel panelThongTin = new JPanel();
		panelThongTin.setLayout(new BoxLayout(panelThongTin, BoxLayout.Y_AXIS));
		add(panelThongTin, BorderLayout.CENTER);
		
		JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelThongTin.add(panelTop);
		
		panelTop.add(txtTim=new JTextField(20));
		txtTim.setFont(new Font("Arial", Font.PLAIN, 16));
		panelTop.add(btnTim = new JButton("Tìm"));
		txtTim.setToolTipText("Tìm theo mã tour hoặc tên tour");
		btnTim.setForeground(Color.WHITE);
		btnTim.setBackground(new Color(30, 144, 255));
		panelTop.add(lblTourTim = new JLabel());
		
		String cols[] = {"Mã Tour", "Tên Tour", "Số chỗ", "Ngày đi", "Ngày kết thúc", "Giá tour"};
		tblModel = new DefaultTableModel(cols, 0);
		tblTour = new JTable(tblModel);
		tblHead = new JTableHeader(tblTour.getColumnModel());
		tblHead.setReorderingAllowed(false);
		tblHead.setBackground(new Color(30, 144, 255));
		tblHead.setForeground(Color.WHITE);
		tblHead.setFont(new Font("Arial", Font.BOLD, 14));
		tblTour.setTableHeader(tblHead);
		tblTour.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblTour.getColumnModel().getColumn(0).setPreferredWidth(80);
		tblTour.getColumnModel().getColumn(1).setPreferredWidth(350);
		tblTour.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblTour.getColumnModel().getColumn(3).setPreferredWidth(125);
		tblTour.getColumnModel().getColumn(4).setPreferredWidth(125);
		tblTour.getColumnModel().getColumn(5).setPreferredWidth(160);
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
		btnDiaDiem.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnAnh1.addActionListener(this);
		btnAnh2.addActionListener(this);
		btnAnh3.addActionListener(this);
		btnAnh4.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnReset.addActionListener(this);
		btnTim.addActionListener(this);
		
		tblHead.addMouseListener(this);
		tblTour.addMouseListener(this);
		dsTour = new ArrayList<TourDuLich>();
		dsAnh = new ArrayList<String>();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnTrangChu) {
			setVisible(false);
			new Home_GUI(nv).setVisible(true);
		}else if(o==btnDiaDiem) {
			setVisible(false);
			new DiaDiem_GUI(nv).setVisible(true);
		}else if(o==btnNhanVien){
			setVisible(false);
			new NhanVien_GUI(nv).setVisible(true);
		}else if(o==btnTour) {
			setVisible(false);
			new QuanLiTour_GUI(nv).setVisible(true);	
		}else if(o==btnAnh1) {
			String strAnh1 = selectImg();
			btnAnh1.setText(strAnh1);
			if(dsAnh.size()>=1) 
				dsAnh.set(0, strAnh1);
			else
				dsAnh.add(strAnh1);
		}else if(o==btnAnh2) {
			String strAnh2 = selectImg();
			btnAnh2.setText(strAnh2);
			if(dsAnh.size()>=2) 
				dsAnh.set(1, strAnh2);
			else
				dsAnh.add(1, strAnh2);
		}else if(o==btnAnh3) {
			String strAnh3 = selectImg();
			btnAnh3.setText(strAnh3);
			if(dsAnh.size()>=3) 
				dsAnh.set(2, strAnh3);
			else
				dsAnh.add(2, strAnh3);
		}else if(o==btnAnh4) {
			String strAnh4 = selectImg();
			btnAnh4.setText(strAnh4);
			if(dsAnh.size()>=4) 
				dsAnh.set(3, strAnh4);
			else
				dsAnh.add(3, strAnh4);
		}else if(o==btnThem) {
			if(validData()) {
				TourDuLich Tour = convertTableToTour();
				if(tour_Bus.addTour(Tour)) {
					dsTour.add(Tour);
					tblModel.addRow(new Object[] {Tour.getMaTour(), Tour.getTenTour(), Tour.getSoCho(), Tour.getNgayDi(), Tour.getNgayKetThuc(), Tour.getGia()});
					updateChiTiet(tblTour.getRowCount()-1);
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
				}else {
					JOptionPane.showMessageDialog(this, "Thêm thất bại! Trùng mã!");
				}
			}
		}else if(o==btnSua) {
			if(validData()) {
				TourDuLich newTour = convertTableToTour();
				if(tour_Bus.updateTour(newTour)) {
					timTour();
					updateChiTiet(dsTour.indexOf(newTour));
					JOptionPane.showMessageDialog(this, "Sửa thành công!");
				}else {
					JOptionPane.showMessageDialog(this, "Sửa thất bại! Đã xảy ra lỗi!");
				}
			}
		}else if(o==btnXoa) {
			xoaTour();
		}else if(o==btnReset) {
			reset();
		}else if(o==btnTim) {
			timTour();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o==tblTour) {
			int r = tblTour.getSelectedRow();
	
			txtMaTour.setText(dsTour.get(r).getMaTour());
			txtTenTour.setText(dsTour.get(r).getTenTour());
			txtAInputMoTa.setText(dsTour.get(r).getMoTa());
			spinSoCho.setValue(dsTour.get(r).getSoCho());
			for(int i=0; i<cmbDiemKH.getItemCount();i++) {
				if(cmbDiemKH.getItemAt(i).getMaDiaDiem().equalsIgnoreCase(dsTour.get(r).getDiemKH().getMaDiaDiem()))
					cmbDiemKH.setSelectedIndex(i);
			}
			for(int i=0; i<cmbDiemDen.getItemCount();i++) {
				if(cmbDiemDen.getItemAt(i).getMaDiaDiem().equalsIgnoreCase(dsTour.get(r).getDiemDen().getMaDiaDiem()))
					cmbDiemDen.setSelectedIndex(i);
			}
			cmbKhachSan.setSelectedItem(dsTour.get(r).getKhachSan());
			for(int i=0; i<cmbPhuongTien.getItemCount();i++) {
				if(cmbPhuongTien.getItemAt(i).getMaPT().equalsIgnoreCase(dsTour.get(r).getPhuongTien().getMaPT()))
					cmbPhuongTien.setSelectedIndex(i);
			}
			txtGia.setText(String.valueOf(dsTour.get(r).getGia()));
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dsTour.get(r).getNgayDi());
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			UtilDateModel modelDate = (UtilDateModel) ngayKH.getModel();
			modelDate.setSelected(true);
			modelDate.setDate(year, month, day);
			
			calendar.setTime(dsTour.get(r).getNgayKetThuc());
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH);
			day = calendar.get(Calendar.DAY_OF_MONTH);
			modelDate = (UtilDateModel) ngayKT.getModel();
			modelDate.setDate(year, month, day);
			modelDate.setSelected(true);
			
			updateChiTiet(r);
			
			dsAnh = dsTour.get(r).getDsAnh();
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
	public void dataArrayToTable(ArrayList<TourDuLich> dsTour) {
		tblModel.setRowCount(0);
		for(TourDuLich x : dsTour) {
			tblModel.addRow(new Object[] {x.getMaTour(), x.getTenTour(), x.getSoCho(), x.getNgayDi(), x.getNgayKetThuc(), x.getGia()});
		}
	}
	public void reset() {
		txtMaTour.setText(null);
		txtTenTour.setText(null);
		txtAInputMoTa.setText(null);
		cmbDiemKH.setSelectedIndex(0);
		cmbDiemDen.setSelectedIndex(0);
		cmbPhuongTien.setSelectedIndex(0);
		cmbKhachSan.setSelectedIndex(0);
		spinSoCho.setValue(20);
		UtilDateModel model = (UtilDateModel) ngayKH.getModel();
		model.setValue(null);
		model.setSelected(false);
		model = (UtilDateModel) ngayKT.getModel();
		model.setValue(null);
		model.setSelected(false);
		txtGia.setText(null);
		txtTim.setText(null);
		lblTourTim.setText(null);
		dataArrayToTable(dsTour);
		dsAnh = new ArrayList<String>();
	}
	public void timTour() {
		String maTim = txtTim.getText();
		ArrayList<TourDuLich>	dsTim = tour_Bus.timTour(maTim);
		if(dsTim!=null) {
			dsTour = dsTim;
			dataArrayToTable(dsTour);
			lblTourTim.setText( "Đã tìm được "+dsTim.size()+" Tour.");
		}else {
			lblTourTim.setText( "Không tìm thấy tour phù hợp !");
		}
	}
	public String selectImg() {
		JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null;
	}
	public void xoaTour() {
		int index = tblTour.getSelectedRow();
		if(index!=-1) {
			if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa Tour: "+tblTour.getValueAt(index, 0), "Cảnh báo!", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				if(tour_Bus.deleteTour(tblTour.getValueAt(index, 0).toString())) {
					tblModel.removeRow(index);
					dsTour.remove(index);
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				}else {
					JOptionPane.showMessageDialog(this, "Xóa thất bại! Đã xảy ra lỗi!");
				}
			}else {
				JOptionPane.showMessageDialog(this, "Xóa tour thất bại! Bạn đã hủy!");
			}
		}else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn Tour muốn xóa!");
		}
	}
	public TourDuLich convertTableToTour() {
		String tenTour = txtTenTour.getText().trim().toString();
		String moTa = txtAInputMoTa.getText().trim();
		int soCho = (int) spinSoCho.getValue();
		
		DateModel<?> model = ngayKH.getModel();
		int day = model.getDay();
		int month = model.getMonth();
		int year = model.getYear();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		java.sql.Date dateKH = new java.sql.Date(calendar.getTimeInMillis());
		
		model = ngayKT.getModel();
		day = model.getDay();
		month = model.getMonth();
		year = model.getYear();
		calendar.set(year, month, day);
		java.sql.Date dateKT = new java.sql.Date(calendar.getTimeInMillis());
		PhuongTien phuongTien = (PhuongTien) cmbPhuongTien.getSelectedItem();
		DiaDiem diemKH = (DiaDiem) cmbDiemKH.getSelectedItem();
		DiaDiem diemKT = (DiaDiem) cmbDiemDen.getSelectedItem();
		String khachSan = cmbKhachSan.getSelectedItem().toString();
		double gia = Double.parseDouble(txtGia.getText().trim());
		String maTour ="";
		if(txtMaTour.getText().trim()==null || txtMaTour.getText().length()==0) {
			maTour = maTourGenerator.sinhMaTour();
		}else {
			maTour = txtMaTour.getText().trim();
		}
		return new TourDuLich(maTour, tenTour, moTa, soCho, phuongTien, dateKH, dateKT, diemKH, diemKT, khachSan, gia, dsAnh);
	}
	public void updateChiTiet(int r) {
		lblTitleTour.setText("["+tblModel.getValueAt(r, 0)+"] "+ tblModel.getValueAt(r, 1));
		double number = Double.parseDouble(tblModel.getValueAt(r, 5).toString());
		DecimalFormat formatter = new DecimalFormat("#,###");
		String formattedNumber = formatter.format(number);
		lblGia.setText(formattedNumber+"đ/khách");
		
		//format Ngay di
		String timeKH = tblModel.getValueAt(r, 3).toString();
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dateKH = null;
		try {
			dateKH = inputFormat.parse(timeKH);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String output = outputFormat.format(dateKH);
		lblKhoiHanh.setText(output);
		
		//tinh so ngay
		java.util.Date startDate = null, endDate = null;
		
		try {
			startDate = inputFormat.parse(tblModel.getValueAt(r, 3).toString());
			endDate = inputFormat.parse(tblModel.getValueAt(r, 4).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long differenceInMillis = endDate.getTime() - startDate.getTime();
		long differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);
		lblTime.setText(String.valueOf(differenceInDays) + "ngày");
		
		lblNoiKH.setText(dsTour.get(r).getDiemKH().getTenDiaDiem());
		
		int soCho = dsTour.get(r).getSoCho();
		lblCho.setText(String.valueOf(soCho-hd_Bus.getSoLuongKhach(dsTour.get(r).getMaTour())));
		
		txtAMoTa.setText(dsTour.get(r).getMoTa());
		lblPhuongTien.setText(cmbPhuongTien.getSelectedItem().toString());
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
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public boolean validData() {
		String tenTour = txtTenTour.getText().trim().toString();
		String moTa = txtAInputMoTa.getText().trim();
		int soCho = (int) spinSoCho.getValue();
		String gia = txtGia.getText().trim();
		
		DateModel<?> model = ngayKH.getModel();
		int day = model.getDay();
		int month = model.getMonth();
		int year = model.getYear();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		java.sql.Date dateKH = new java.sql.Date(calendar.getTimeInMillis());
		model = ngayKT.getModel();
		day = model.getDay();
		month = model.getMonth();
		year = model.getYear();
		calendar.set(year, month, day);
		java.sql.Date dateKT = new java.sql.Date(calendar.getTimeInMillis());
		
		boolean ptTenTour = Pattern.matches("[a-zA-Z0-9aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
				+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
				+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ~!&'*()_+{}\\\\\\\\[\\\\\\\\]:;,.<>/?-]+", tenTour);
		boolean ptMoTa = Pattern.matches("[a-zA-Z0-9aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
				+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
				+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ~!&'*()_+{}\\\\\\\\\\\\\\\\[\\\\\\\\\\\\\\\\]:;,.<>/?-]+", moTa);
		boolean ptGia = Pattern.matches("[0-9]+\\.?[0-9]+", gia);
		if(ptTenTour==false) {
			JOptionPane.showMessageDialog(this, "Error: Nhập tên sai!\nChỉ được nhập các chữ, số và _':()!-");
			txtTenTour.requestFocus();
			return false;
		}
		if(ptMoTa!=true) {
			JOptionPane.showMessageDialog(this, "Error: Nhập mô tả sai!\nChỉ được nhập các chữ, số và _':()!-");
			txtAInputMoTa.requestFocus();
			return false;
		}
		if(soCho<=0 || soCho>60) {
			JOptionPane.showMessageDialog(this, "Error: Số chỗ từ 1-60.");
			spinSoCho.requestFocus();
			return false;
		}if(Date.valueOf(LocalDate.now()).after(dateKH)) {
			JOptionPane.showMessageDialog(this, "Error: Ngày đi không được trước ngày hôm nay!");
			ngayKH.requestFocus();
			return false;
		}if(Date.valueOf(LocalDate.now()).after(dateKT) || dateKH.after(dateKT)) {
			JOptionPane.showMessageDialog(this, "Error: Ngày kết thúc không được trước ngày hôm nay và trước ngày khởi hành!");
			ngayKT.requestFocus();
			return false;
		}if(ptGia!=true) {
			JOptionPane.showMessageDialog(this, "Error: Nhập sai định dạng!\nGiá chỉ được nhập số và dấu .");
			txtGia.requestFocus();
			return false;
		}
		return true;
	}
}
