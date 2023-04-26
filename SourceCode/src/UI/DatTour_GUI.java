package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import BUS.HoaDon_Bus;
import BUS.KhachHang_Bus;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.ThanhVien;
import Entity.TourDuLich;
import Util.CodeGenerator;

public class DatTour_GUI extends JFrame implements ActionListener{
	private JButton btnThanhToan, btnClose, btnTao, btnThem, btnSua, btnXoa, btnDaCoKH;
	private TourDuLich tour;
	private JTextField txtHoTenKH, txtEmail, txtSDT, txtDiaChi, txtHoTenTV;
	private JLabel lblSoHD, lblNgayTao, lblTenKH, lblSoKhach, lblNguoiLon, lblTreEm, lblThanhTien;
	private JComboBox<String> cmbGioiTinh, cmbLuaTuoi;
	private JDatePickerImpl ngaySinh;
	private DefaultTableModel modelTV;
	private JTable tblTV;
	private ArrayList<ThanhVien> dsTV;
	private HoaDon_Bus hdBus;
	private KhachHang_Bus khBus;
	private CodeGenerator sinhMa;
	private NhanVien nv;
	private HoaDon hd;
	private KhachHang kh;
	public DatTour_GUI(TourDuLich tour, NhanVien nv) {
		setSize(1000, 750);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		this.tour = tour;
		this.nv = nv;
		this.hd = new HoaDon();
		hdBus = new HoaDon_Bus();
		khBus = new KhachHang_Bus();
		sinhMa = new CodeGenerator();
		dsTV = new ArrayList<ThanhVien>();
		createGUI();
	}
	public void createGUI() {
		//tao phan header
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS));
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 20, 10, 20);
		Border lineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
		CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(lineBorder, emptyBorder);
		panelNorth.setBorder(compoundBorder);
		add(panelNorth, BorderLayout.NORTH);
		
		//add hinh anh tour
		ImageIcon headImg = new ImageIcon(tour.getDsAnh().get(0));
		Image headImage = headImg.getImage();
		Image scaledImage= headImage.getScaledInstance(400, 140, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon= new ImageIcon(scaledImage);
		JLabel lblHinh = new JLabel(scaledIcon);
		panelNorth.add(lblHinh);
		
		//thong tin tour
		JPanel panelThongTin = new JPanel();
		panelThongTin.setLayout(new BoxLayout(panelThongTin, BoxLayout.Y_AXIS));
		panelThongTin.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		panelNorth.add(panelThongTin);
		
		JPanel pnMa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMaTour = new JLabel("Mã Tour: " + tour.getMaTour());
		lblMaTour.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaTour.setForeground(new Color(0, 0, 255));
		pnMa.add(lblMaTour);
		panelThongTin.add(pnMa);
		
		JPanel pnTen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTenTour = new JLabel("["+tour.getMaTour()+"] "+ tour.getTenTour());
		lblTenTour.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenTour.setForeground(new Color(0, 0, 255));
		pnTen.add(lblTenTour);
		panelThongTin.add(pnTen);
		
		JPanel pnTimeKH = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelThongTin.add(pnTimeKH);
		JLabel lblTimeKH = new JLabel("Khởi hành: ");
		lblTimeKH.setForeground(new Color(0, 0, 255));
		lblTimeKH.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblTimeKHGet = new JLabel(tour.getNgayDi().toString());
		lblTimeKHGet.setForeground(new Color(0, 0, 255));
		lblTimeKHGet.setFont(new Font("Arial", Font.PLAIN, 12));
		pnTimeKH.add(lblTimeKH);
		pnTimeKH.add(lblTimeKHGet);
		
		JPanel pnTime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelThongTin.add(pnTime);
		JLabel lblTime = new JLabel("Thời gian: ");
		lblTime.setForeground(new Color(0, 0, 255));
		lblTime.setFont(new Font("Arial", Font.PLAIN, 12));
		LocalDate startDate = tour.getNgayDi().toLocalDate();
		LocalDate endDate = tour.getNgayKetThuc().toLocalDate();
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		JLabel lblGetTime = new JLabel(daysBetween+" ngày");
		lblGetTime.setForeground(new Color(0, 0, 255));
		lblGetTime.setFont(new Font("Arial", Font.PLAIN, 12));
		pnTime.add(lblTime);
		pnTime.add(lblGetTime);
		
		JPanel pnNoiKH = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelThongTin.add(pnNoiKH);
		JLabel lblNoiKH = new JLabel("Lịch trình: ");
		lblNoiKH.setForeground(new Color(0, 0, 255));
		lblNoiKH.setFont(new Font("Arial", Font.PLAIN, 12));
		JLabel lblGetNoiKH = new JLabel(tour.getDiemKH().getTenDiaDiem() + " - " + tour.getDiemDen().getTenDiaDiem());
		lblGetNoiKH.setForeground(new Color(0, 0, 255));
		lblGetNoiKH.setFont(new Font("Arial", Font.PLAIN, 12));
		pnNoiKH.add(lblNoiKH);
		pnNoiKH.add(lblGetNoiKH);
		
		JPanel pnSoChoCon = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelThongTin.add(pnSoChoCon);
		JLabel lblSoChoCon = new JLabel("Số chỗ còn nhận: ");
		lblSoChoCon.setForeground(new Color(0, 0, 255));
		lblSoChoCon.setFont(new Font("Arial", Font.PLAIN, 12));
		int soCho = tour.getSoCho();
		JLabel lblGetSoChoCon = new JLabel(String.valueOf(soCho-hdBus.getSoLuongKhach(tour.getMaTour())));
		lblGetSoChoCon.setForeground(new Color(0, 0, 255));
		lblGetSoChoCon.setFont(new Font("Arial", Font.PLAIN, 12));
		pnSoChoCon.add(lblSoChoCon);
		pnSoChoCon.add(lblGetSoChoCon);
		
		//them khach hang va them thanh vien
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(panelCenter, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTitle = new JLabel("Tổng quan về chuyến đi");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		pnTitle.add(lblTitle);
		panelCenter.add(pnTitle);
		
		JPanel pnTTLL = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTTLL = new JLabel("Thông tin liên lạc");
		lblTTLL.setFont(new Font("Arial", Font.PLAIN, 16));
		pnTTLL.add(lblTTLL);
		panelCenter.add(pnTTLL);	
		
		JPanel pnThongTin = new  JPanel(new GridLayout(4, 2, 75, 0));
		pnThongTin.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		panelCenter.add(pnThongTin);
		
		JLabel lblHoTen = new JLabel("Họ và tên:");
		pnThongTin.add(lblHoTen);
		
		JLabel lblEmail = new JLabel("Email:");
		pnThongTin.add(lblEmail);
		
		pnThongTin.add(txtHoTenKH = new JTextField());
		pnThongTin.add(txtEmail = new JTextField());
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		pnThongTin.add(lblSDT);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		pnThongTin.add(lblDiaChi);
		
		pnThongTin.add(txtSDT = new JTextField());
		pnThongTin.add(txtDiaChi = new JTextField());
		
		JPanel pnTaoKH = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelCenter.add(pnTaoKH);
		pnTaoKH.add(btnTao=new JButton("Tạo khách hàng"));
		btnTao.setForeground(Color.WHITE);
		btnTao.setBackground(new Color(30, 144, 255));
		pnTaoKH.add(Box.createHorizontalStrut(20));
		pnTaoKH.add(btnDaCoKH=new JButton("Đã Có Thông Tin"));
		btnDaCoKH.setForeground(Color.WHITE);
		btnDaCoKH.setBackground(new Color(30, 144, 255));
		
		JPanel pnThongTinKhach = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelCenter.add(pnThongTinKhach);
		JLabel lblThongTinKhach = new JLabel("Nhập thông tin khách");
		lblThongTinKhach.setFont(new Font("Arial", Font.PLAIN, 16));
		pnThongTinKhach.add(lblThongTinKhach);
		
		JPanel pnNhapKhach = new JPanel();
		pnNhapKhach.setLayout(new BoxLayout(pnNhapKhach, BoxLayout.X_AXIS));
		panelCenter.add(pnNhapKhach);
		
		JPanel pnHoTen = new JPanel(new GridLayout(2, 1));
		pnNhapKhach.add(pnHoTen);
		pnHoTen.add(new JLabel("Họ và tên"));
		pnHoTen.add(txtHoTenTV= new JTextField(20));
		
		JPanel pnGioiTinh = new JPanel(new GridLayout(2, 1));
		pnNhapKhach.add(Box.createHorizontalStrut(10));
		pnNhapKhach.add(pnGioiTinh);
		pnGioiTinh.add(new JLabel("Giới tính"));
		String gioiTinh[] = {"Nam", "Nữ"};
		pnGioiTinh.add(cmbGioiTinh = new JComboBox<>(gioiTinh));
		
		JPanel pnNgaySinh = new JPanel(new GridLayout(2, 1));
		pnNhapKhach.add(Box.createHorizontalStrut(10));
		pnNhapKhach.add(pnNgaySinh);
		pnNgaySinh.add(new JLabel("Ngày sinh"));
		UtilDateModel model = new UtilDateModel();
		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
		ngaySinh = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		ngaySinh.setPreferredSize(new Dimension(100, 28));
		pnNgaySinh.add(ngaySinh);
		
		JPanel pnLuaTuoi = new JPanel(new GridLayout(2, 1));
		pnNhapKhach.add(Box.createHorizontalStrut(10));
		pnNhapKhach.add(pnLuaTuoi);
		pnLuaTuoi.add(new JLabel("Lứa tuổi"));
		String luaTuoi[] = {"Trẻ em", "Người lớn"};
		pnLuaTuoi.add(cmbGioiTinh = new JComboBox<>(luaTuoi));
		
		//tao button them sua xoa khach hang
		JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelCenter.add(panelButton);
		panelButton.add(btnThem = new JButton("Thêm"));
		panelButton.add(Box.createHorizontalStrut(10));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		panelButton.add(btnSua = new JButton("Sửa"));
		panelButton.add(Box.createHorizontalStrut(10));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		panelButton.add(btnXoa = new JButton("Xóa"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		
		//tao table thanhvien
		String cols[] = {"Mã TV", "Họ và Tên", "Giới tính", "Ngày sinh", "Lứa tuổi"};
		modelTV = new DefaultTableModel(cols, 0);
		tblTV = new JTable(modelTV);
		JScrollPane scrollTable = new JScrollPane(tblTV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelCenter.add(scrollTable);
		
		//tao phan thong tin thanh toan
		JPanel panelThanhToan = new JPanel();
		panelThanhToan.setLayout(new BoxLayout(panelThanhToan, BoxLayout.Y_AXIS));
		panelThanhToan.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 5));
		add(panelThanhToan, BorderLayout.EAST);
		
		//thong tin hoa don
		JPanel panelThongTinHD = new JPanel();
		panelThongTinHD.setLayout(new GridLayout(4, 2, 0, 10));
		panelThanhToan.add(panelThongTinHD);
		panelThongTinHD.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
		panelThongTinHD.add(new JLabel("Hóa đơn số:"));
		hd.setSoHoaDon(sinhMa.sinhMaHD());
		panelThongTinHD.add(new JLabel(hd.getSoHoaDon()));
		panelThongTinHD.add(new JLabel("Ngày tạo:"));
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		String timeNow = timeFormat.format(new Date());
		panelThongTinHD.add(new JLabel(timeNow));
		panelThongTinHD.add(new JLabel("Tên nhân viên:"));
		panelThongTinHD.add(new JLabel(nv.getTenNV()));
		panelThongTinHD.add(new JLabel("Tên khách hàng:"));
		panelThongTinHD.add(lblTenKH = new JLabel("..."));
		
		JPanel pnLine = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnLine.add(new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"));
		panelThanhToan.add(pnLine);
		
		JPanel pnTT = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTomTat = new JLabel("Tóm tắt chuyến đi");
		lblTomTat.setFont(new Font("Arial", Font.PLAIN, 20));
		pnTT.add(lblTomTat);
		panelThanhToan.add(pnTT);
		
		JPanel detailKH = new JPanel(new GridLayout(1, 2));
		JPanel pnImgIcon = new JPanel(new FlowLayout(FlowLayout.LEADING));
		panelThanhToan.add(detailKH);
		ImageIcon headImgTT = new ImageIcon(tour.getDsAnh().get(0));
		Image headImageTT = headImgTT.getImage();
		Image scaledImageTT = headImageTT.getScaledInstance(175, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIconTT= new ImageIcon(scaledImageTT);
		JLabel lblHinhTT = new JLabel(scaledIconTT);
		pnImgIcon.add(lblHinhTT);
		detailKH.add(pnImgIcon);
		
		JPanel timeKH = new JPanel(new FlowLayout(FlowLayout.CENTER));
		detailKH.add(timeKH);
		
		ImageIcon headImgLT = new ImageIcon("Img/lichtrinh.png");
		Image headImageLT = headImgLT.getImage();
		Image scaledImageLT = headImageLT.getScaledInstance(30, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIconLT= new ImageIcon(scaledImageLT);
		JLabel lblHinhLT = new JLabel(scaledIconLT);
		timeKH.add(lblHinhLT);
		
		JPanel dateKH = new JPanel();
		timeKH.add(dateKH);
		dateKH.setLayout(new BoxLayout(dateKH, BoxLayout.Y_AXIS));
		String start = "<html>Bắt đầu chuyến đi<br>"+ tour.getNgayDi().toString() +"</html>";
		JLabel lblStart = new JLabel(start);
		dateKH.add(lblStart);
		dateKH.add(Box.createVerticalStrut(40));
		String end = "<html>Kết thúc chuyến đi<br>"+ tour.getNgayKetThuc().toString() +"</html>";
		JLabel lblEnd = new JLabel(end);
		dateKH.add(lblEnd);
		
		JPanel pnHanhKhach = new JPanel(new GridLayout(5, 2, 30, 15));
		pnHanhKhach.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 20));
		panelThanhToan.add(pnHanhKhach);
		pnHanhKhach.add(new JLabel("Hành khách"));
		pnHanhKhach.add(lblSoKhach = new JLabel("... người"));
		pnHanhKhach.add(new JLabel("Người lớn"));
		pnHanhKhach.add(lblNguoiLon = new JLabel("... người"));
		pnHanhKhach.add(new JLabel("Trẻ em"));
		pnHanhKhach.add(lblTreEm = new JLabel("... người"));
		JLabel lblGiaTD = new JLabel("Giá Tour");
		lblGiaTD.setFont(new Font("Arial", Font.PLAIN, 18));
		pnHanhKhach.add(lblGiaTD);
		JLabel lblGia = new JLabel(tour.getGia()+"đ");
		lblGia.setFont(new Font("Arial", Font.PLAIN, 18));
		pnHanhKhach.add(lblGia);
		JLabel lblTTTD = new JLabel("Thành tiền");
		lblTTTD.setFont(new Font("Arial", Font.PLAIN, 18));
		pnHanhKhach.add(lblTTTD);
		pnHanhKhach.add(lblThanhTien = new JLabel("...đ"));
		lblThanhTien.setFont(new Font("Arial", Font.PLAIN, 18));
		
		//tao phan button
		JPanel panelBtnThanhToan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBtnThanhToan.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));
		panelThanhToan.add(panelBtnThanhToan, BorderLayout.SOUTH);
		panelBtnThanhToan.add(btnThanhToan = new JButton("Thanh Toán"));
		btnThanhToan.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 18));
		btnThanhToan.setBounds(0, 0, 100, 50);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setBackground(new Color(32,178,170));
		panelBtnThanhToan.add(Box.createHorizontalStrut(50));
		panelBtnThanhToan.add(btnClose = new JButton("Thoát"));
		btnClose.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnClose.setFont(new Font("Arial", Font.BOLD, 18));
		btnClose.setBounds(0, 0, 100, 50);
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(new Color(255,127,80));
		
		btnThanhToan.addActionListener(this);
		btnClose.addActionListener(this);
		btnTao.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnDaCoKH.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnClose) {
			dispose();
		}else if(o == btnTao) {
			if(validDataKH()) {
				KhachHang khNew = convertKH();
				if(khBus.addKhachHang(khNew)) {
					kh = khNew;
					lblTenKH.setText(khNew.getTenKH());
					JOptionPane.showMessageDialog(this, "Tạo thành công!");
				}else {
					JOptionPane.showMessageDialog(this, "Tạo thất bại! Sđt đã được sử dụng hoặc đã có lỗi xảy ra!");
				}
			}
		}else if(o==btnDaCoKH) {
			String sdt = JOptionPane.showInputDialog(null, "Nhập số điện thoại");
			kh = khBus.getKhachHangTheoSDT(sdt);
			if(kh!=null) {
				txtHoTenKH.setText(kh.getTenKH());
				txtSDT.setText(kh.getSdt());
				txtEmail.setText(kh.getEmail());
				txtDiaChi.setText(kh.getDiaChi());
				lblTenKH.setText(kh.getTenKH());
			}else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
		}
	}
	public boolean validDataKH() {
		String tenKH = txtHoTenKH.getText().trim();
		String sdt = txtSDT.getText().trim();
		String mail = txtEmail.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		
		boolean ptTenKH  = Pattern.matches("[a-zA-Z0-9aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
				+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
				+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ '_]+", tenKH);
		boolean ptSDT = Pattern.matches("[0-9]{10,11}", sdt);
		boolean ptMail = Pattern.matches("\\w+@\\w+((mail(\\.)com)||((\\.)com))?(\\.\\w+)", mail);
		boolean ptDiaChi = Pattern.matches("[a-zA-Z0-9aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
				+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
				+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ '*()_+{}\\\\\\\\[\\\\\\\\]:;,]+", diaChi);
		return true;
	}
	public KhachHang convertKH() {
		String tenKH = txtHoTenKH.getText().trim();
		String sdt = txtSDT.getText().trim();
		String mail = txtEmail.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String maKH = sinhMa.sinhMaKH();
		return new KhachHang(maKH, sdt, tenKH, mail, diaChi);
	}
	
}
