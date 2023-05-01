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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
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

import org.jdatepicker.DateModel;
import org.jdatepicker.JDateComponent;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import BUS.HoaDon_Bus;
import BUS.KhachHang_Bus;
import BUS.ThanhVien_Bus;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.ThanhVien;
import Entity.TourDuLich;
import Util.CodeGenerator;

public class DatTour_GUI extends JFrame implements ActionListener, MouseListener{
	private JButton btnThanhToan, btnClose, btnTao, btnThem, btnSua, btnXoa, btnDaCoKH;
	private TourDuLich tour;
	private JTextField txtHoTenKH, txtEmail, txtSDT, txtDiaChi, txtHoTenTV;
	private JLabel lblSoHD, lblNgayTao, lblTenKH, lblSoKhach, lblNguoiLon, lblTreEm, lblThanhTien;
	private JComboBox<String> cmbGioiTinh, cmbLuaTuoi;
	private JDatePickerImpl ngaySinh;
	private DefaultTableModel modelTV;
	private JTable tblTV;
	private HoaDon_Bus hdBus;
	private KhachHang_Bus khBus;
	private ThanhVien_Bus tvBus;
	private CodeGenerator sinhMa;
	private NhanVien nv;
	private HoaDon hd;
	private KhachHang kh;
	private ArrayList<ThanhVien> dsTV;
	public DatTour_GUI(TourDuLich tour, NhanVien nv) {
		setSize(1000, 750);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		this.tour = tour;
		this.nv = nv;
		sinhMa = new CodeGenerator();
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String timeNow = timeFormat.format(new Date());
		java.util.Date utilDate;
		try {
			utilDate = timeFormat.parse(timeNow);
			java.sql.Timestamp sqlTimestamp  = new java.sql.Timestamp(utilDate.getTime());
			this.hd = new HoaDon(sinhMa.sinhMaHD(), sqlTimestamp, tour,nv);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hdBus = new HoaDon_Bus();
		khBus = new KhachHang_Bus();
		tvBus = new ThanhVien_Bus();
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
		pnTaoKH.add(btnTao=new JButton("Tạo khách hàng", new ImageIcon("img/plus1.png")));
		btnTao.setForeground(Color.WHITE);
		btnTao.setBackground(new Color(30, 144, 255));
		pnTaoKH.add(Box.createHorizontalStrut(20));
		pnTaoKH.add(btnDaCoKH=new JButton("Đã Có Thông Tin", new ImageIcon("img/user-list.png")));
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
		pnLuaTuoi.add(cmbLuaTuoi = new JComboBox<>(luaTuoi));
		
		//tao button them sua xoa khach hang
		JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelCenter.add(panelButton);
		panelButton.add(btnThem = new JButton("Thêm", new ImageIcon("img/plus1.png")));
		panelButton.add(Box.createHorizontalStrut(10));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		panelButton.add(btnSua = new JButton("Sửa", new ImageIcon("img/edit-user.png")));
		panelButton.add(Box.createHorizontalStrut(10));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		panelButton.add(btnXoa = new JButton("Xóa", new ImageIcon("Img/delete.png")));
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

		panelThongTinHD.add(new JLabel(hd.getSoHoaDon()));
		panelThongTinHD.add(new JLabel("Ngày tạo:"));
		panelThongTinHD.add(new JLabel(hd.getNgayTaoHD().toString()));
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
		pnHanhKhach.add(lblSoKhach = new JLabel("0 người"));
		pnHanhKhach.add(new JLabel("Người lớn"));
		pnHanhKhach.add(lblNguoiLon = new JLabel("0 người"));
		pnHanhKhach.add(new JLabel("Trẻ em"));
		pnHanhKhach.add(lblTreEm = new JLabel("0 người"));
		JLabel lblGiaTD = new JLabel("Giá Tour");
		lblGiaTD.setFont(new Font("Arial", Font.PLAIN, 16));
		pnHanhKhach.add(lblGiaTD);
		DecimalFormat df = new DecimalFormat("#,###.##");
		JLabel lblGia = new JLabel(df.format(tour.getGia())+"đ");
		lblGia.setFont(new Font("Arial", Font.PLAIN, 16));
		pnHanhKhach.add(lblGia);
		JLabel lblTTTD = new JLabel("Thành tiền");
		lblTTTD.setFont(new Font("Arial", Font.PLAIN, 16));
		pnHanhKhach.add(lblTTTD);
		pnHanhKhach.add(lblThanhTien = new JLabel("0 đ"));
		lblThanhTien.setFont(new Font("Arial", Font.PLAIN, 16));
		
		//tao phan button
		JPanel panelBtnThanhToan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBtnThanhToan.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));
		panelThanhToan.add(panelBtnThanhToan, BorderLayout.SOUTH);
		panelBtnThanhToan.add(btnThanhToan = new JButton("Thanh Toán", new ImageIcon("img/money.png")));
		btnThanhToan.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 18));
		btnThanhToan.setBounds(0, 0, 100, 50);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setBackground(new Color(32,178,170));
		panelBtnThanhToan.add(Box.createHorizontalStrut(30));
		panelBtnThanhToan.add(btnClose = new JButton("Thoát", new ImageIcon("img/back.png")));
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
		tblTV.addMouseListener(this);
		
		hdBus.themHoaDon(hd);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnClose) {
			hdBus.deleteHoaDon(hd.getSoHoaDon());
			dispose();
		}else if(o == btnTao) {
			if(validDataKH()) {
				KhachHang khNew = convertKH();
				if(khBus.addKhachHang(khNew)) {
					kh = khNew;
					lblTenKH.setText(khNew.getTenKH());
					JOptionPane.showMessageDialog(this, "Tạo thành công!");
					hd.setKh(khNew);
					hdBus.updateHoaDon(hd);
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
				hd.setKh(kh);
				hdBus.updateHoaDon(hd);
			}else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
		}else if(o==btnThem) {
			if(validDataTV()) {
				ThanhVien newTV = convertTV();
				if(tvBus.addThanhVien(newTV)) {
					addRowTable(newTV);
					dsTV.add(newTV);
					hd.setDsTV(dsTV);
					lblSoKhach.setText(dsTV.size()+" người");
					int soTre = getSoTreEm();
					lblTreEm.setText(soTre+" người");
					lblNguoiLon.setText((dsTV.size()-soTre)+" người");
					DecimalFormat df = new DecimalFormat("#,###.##");
					lblThanhTien.setText(df.format(hd.tinhThanhTien())+" đ");
					clearTV();
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
				}else {
					JOptionPane.showMessageDialog(this, "Thêm thất bại! Đã có lỗi xảy ra!");
				}
			}
		}else if(o==btnSua) {
			if(validDataTV()) {
				ThanhVien newTV = convertTV();
				if(tvBus.updateThanhVien(newTV)) {
					dsTV.set(dsTV.indexOf(newTV), newTV);
					hd.setDsTV(dsTV);
					dataToTable(dsTV);
					int soTre = getSoTreEm();
					lblTreEm.setText(soTre+" người");
					lblNguoiLon.setText((dsTV.size()-soTre)+" người");
					JOptionPane.showMessageDialog(this, "Update thành công!");
				}else {
					JOptionPane.showMessageDialog(this, "Update thất bại! Đã có lỗi xảy ra!");
				}
			}
		}
		else if(o==btnXoa) {
			xoaTV();
		}else if(o==btnThanhToan) {
			if(checkThanhToan()) {
				setVisible(false);
				new HoaDon_GUI(hd, nv, tour, kh).setVisible(true);
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
		if(!ptTenKH) {
			JOptionPane.showMessageDialog(this, "Error: Tên chỉ chứa chữ, số và kí tự khoảng trắng '");
			return false;
		}
		if(!ptSDT) {
			JOptionPane.showMessageDialog(this, "Error: SDT chỉ gồm các chữ số và độ dài 10-11 số!");
			return false;
		}
		if(!ptMail) {
			JOptionPane.showMessageDialog(this, "Error: Mail phải theo định dạng example@domain.com");
			return false;
		}
		if(!ptDiaChi) {
			JOptionPane.showMessageDialog(this, "Error: Địa chỉ gồm chứa chữ, số và kí tự đặc biệt");
			return false;
		}
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
	public boolean validDataTV() {
		String hoTen = txtHoTenTV.getText().trim();
		
		boolean ptHoTen = Pattern.matches("[a-zA-Z0-9aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
				+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
				+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ _']+", hoTen);
		DateModel<?> model = ngaySinh.getModel();
		int day = model.getDay();
		int month = model.getMonth();
		int year = model.getYear();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		java.sql.Date birthDate = new java.sql.Date(calendar.getTimeInMillis());
		
		if(!ptHoTen) {
			JOptionPane.showMessageDialog(this, "Lỗi! Tên chỉ được nhập chữ và kí tự khoảng trắng hoặc '");
			txtHoTenTV.requestFocus();
			return false;
		}
		if(java.sql.Date.valueOf(LocalDate.now()).before(birthDate)) {
			JOptionPane.showMessageDialog(this, "Error: Ngày sinh không được sau ngày hiện tại!");
			ngaySinh.requestFocus();
			return false;
		}
		return true;
	}
	public ThanhVien convertTV() {
		String hoTen = txtHoTenTV.getText().trim();
		
		boolean gioiTinh = false;
		if(cmbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nam"))
			gioiTinh = true;
		
		boolean luaTuoi = false;
		if(cmbLuaTuoi.getSelectedItem().toString().equalsIgnoreCase("Người lớn"))
			luaTuoi = true;
		
		DateModel<?> model = ngaySinh.getModel();
		int day = model.getDay();
		int month = model.getMonth();
		int year = model.getYear();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		java.sql.Date date = new java.sql.Date(calendar.getTimeInMillis());
		
		return new ThanhVien(sinhMa.sinhMaTV(), hoTen, gioiTinh, date, luaTuoi, hd);
	}
	public void addRowTable(ThanhVien tv) {
		modelTV.addRow(new Object[] {tv.getMaTV(), tv.getTenTV(), tv.isGioiTinh()?"Nam":"Nữ",tv.getNgaySinh(), tv.isLuaTuoi()?"Người lớn":"Trẻ em"});
	}
	public void dataToTable(ArrayList<ThanhVien> ds) {
		modelTV.setRowCount(0);
		for(ThanhVien tv: ds)
			addRowTable(tv);
	}
	public void xoaTV() {
		int index = tblTV.getSelectedRow();
		if(index!=-1) {
			String maTV = tblTV.getValueAt(index, 0).toString();
			if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thành viên "+maTV, "Cảnh báo!", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				if(tvBus.deleteThanhVien(maTV)) {
					modelTV.removeRow(index);
					dsTV.remove(index);
					lblSoKhach.setText(dsTV.size()+"");
					int soTre = getSoTreEm();
					lblTreEm.setText(soTre+" người");
					lblNguoiLon.setText((dsTV.size()-soTre)+" người");
					hd.setDsTV(dsTV);
					DecimalFormat df = new DecimalFormat("#,###.##");
					lblThanhTien.setText(df.format(hd.tinhThanhTien())+" đ");
					clearTV();
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				}else {
					JOptionPane.showMessageDialog(this, "Xóa thất bại! Đã xảy ra lỗi!");
				}
			}
		}else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn thành viên cần xóa!");
		}
	}
	public int getSoTreEm() {
		int tre = 0;
		for(ThanhVien tv: dsTV) {
			if(!tv.isLuaTuoi())
				tre++;
		}
		return tre;
	}
	public void clearTV() {
		int index = tblTV.getSelectedRow();
		txtHoTenTV.setText(null);
		cmbGioiTinh.setSelectedItem(0);
		cmbLuaTuoi.setSelectedItem(0);
		UtilDateModel modelDate = (UtilDateModel) ngaySinh.getModel();
		modelDate.setSelected(false);
	}
	public boolean checkThanhToan() {
		if(kh==null) {
			JOptionPane.showMessageDialog(this, "Chưa có khách hàng! Cần thêm khách hàng");
			return false;
		}
		if(dsTV.size()==0) {
			JOptionPane.showMessageDialog(this, "Chưa thêm thành viên!");
			return false;
		}
		if(dsTV.size()-getSoTreEm()==0) {
			JOptionPane.showMessageDialog(this, "Cần ít nhất một người lớn đi cùng!");
			return false;
		}
		int soCho = tour.getSoCho();
		if((soCho-hdBus.getSoLuongKhach(tour.getMaTour()))<0) {
			JOptionPane.showMessageDialog(this, "Số thành viên vượt quá số chỗ còn nhận!");
			return false;
		}
		return true;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int index = tblTV.getSelectedRow();
		txtHoTenTV.setText(tblTV.getValueAt(index, 1).toString());
		cmbGioiTinh.setSelectedItem(tblTV.getValueAt(index, 2).toString());
		cmbLuaTuoi.setSelectedItem(tblTV.getValueAt(index, 4).toString());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dsTV.get(index).getNgaySinh());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		UtilDateModel modelDate = (UtilDateModel) ngaySinh.getModel();
		modelDate.setSelected(true);
		modelDate.setDate(year, month, day);
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
