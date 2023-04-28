package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.TourDuLich;

public class HoaDon_GUI extends JFrame{
	private HoaDon hd;
	private NhanVien nv;
	private TourDuLich tour;
	private KhachHang kh;
	public HoaDon_GUI(HoaDon hd, NhanVien nv, TourDuLich tour, KhachHang kh) {
		setTitle("Hóa đơn");
		setSize(625, 650);
		setLocationRelativeTo(null);
		setResizable(false);
		this.hd = hd;
		this.kh = kh;
		this.tour = tour;
		this.nv = nv;
		createGUI();
	}
	public void createGUI() {
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
		//panelNorth.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
		add(panelNorth, BorderLayout.NORTH);
		Box b1 = Box.createHorizontalBox();
		ImageIcon imgLogo = new ImageIcon("img/vietour_logo.png");
		b1.add(new JLabel(imgLogo));
		panelNorth.add(b1);
		
		Box b2 = Box.createHorizontalBox();
		JLabel lblTitle = new JLabel("HÓA ĐƠN THANH TOÁN");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		b2.add(lblTitle);
		panelNorth.add(Box.createVerticalStrut(10));
		panelNorth.add(b2);
		
		JPanel panelTTHD = new JPanel(new GridLayout(4, 2, 40, 0));
		panelTTHD.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
		panelNorth.add(Box.createVerticalStrut(10));
		panelNorth.add(panelTTHD);
		
		JPanel panelSoHD = new JPanel();
		JLabel lblSoHD = new JLabel("Số HD");
		lblSoHD.setFont(new Font("Arial", Font.BOLD, 14));
		panelSoHD.add(lblSoHD);
		panelSoHD.setBackground(new Color(153, 204, 255));
		panelTTHD.add(panelSoHD);
		
		JPanel panelTenNV = new JPanel();
		JLabel lblTenNV = new JLabel("Tên NV");
		lblSoHD.setFont(new Font("Arial", Font.BOLD, 14));
		panelTenNV.add(lblTenNV);
		panelTenNV.setBackground(new Color(153, 204, 255));
		panelTTHD.add(panelTenNV);
		
		JPanel panelGetHD = new JPanel();
		JLabel lblGetHD = new JLabel(hd.getSoHoaDon());
		lblGetHD.setFont(new Font("Arial", Font.PLAIN, 12));
		panelGetHD.add(lblGetHD);
		panelTTHD.add(panelGetHD);
		
		JPanel panelGetNV = new JPanel();
		JLabel lblGetNV = new JLabel(nv.getMaNV());
		lblGetNV.setFont(new Font("Arial", Font.PLAIN, 12));
		panelGetNV.add(lblGetNV);
		panelTTHD.add(panelGetNV);
		
		JPanel panelNgayLap = new JPanel();
		JLabel lblNgayLap = new JLabel("Ngày lập HD");
		lblNgayLap.setFont(new Font("Arial", Font.BOLD, 14));
		panelNgayLap.add(lblNgayLap);
		panelNgayLap.setBackground(new Color(153, 204, 255));
		panelTTHD.add(panelNgayLap);
		
		JPanel panelMaKH = new JPanel();
		JLabel lblMaKH = new JLabel("Tên KH");
		lblNgayLap.setFont(new Font("Arial", Font.BOLD, 14));
		panelMaKH.add(lblMaKH);
		panelMaKH.setBackground(new Color(153, 204, 255));
		panelTTHD.add(panelMaKH);
		
		JPanel panelGetNgay = new JPanel();
		JLabel lblGetNgay = new JLabel(hd.getNgayTaoHD().toString());
		lblGetNgay.setFont(new Font("Arial", Font.PLAIN, 12));
		panelGetNgay.add(lblGetNgay);
		panelTTHD.add(panelGetNgay);
		
		JPanel panelGetKH = new JPanel();
		JLabel lblGetKH = new JLabel(kh.getTenKH());
		lblGetKH.setFont(new Font("Arial", Font.PLAIN, 12));
		panelGetKH.add(lblGetKH);
		panelTTHD.add(panelGetKH);
		
		JPanel pnLine = new JPanel();
		pnLine.add(new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"));
		panelNorth.add(pnLine);
		
		//thong tin chi tiet hoa don
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		add(panelCenter, BorderLayout.CENTER);
		
		JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTenTour = new JLabel("Tên Tour: ");
		lblTenTour.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel lblGetTenTour = new JLabel(/*tour.getTenTour()*/ "Tour du lịch xyz abc def");
		lblGetTenTour.setFont(new Font("Arial", Font.PLAIN, 14));
		pn1.add(lblTenTour);
		pn1.add(lblGetTenTour);
		panelCenter.add(pn1);
		
		JPanel panelChiTiet = new JPanel(new GridLayout(5, 4, 20, 20));
		panelCenter.add(panelChiTiet);
		
		JLabel lblDiemDi = new JLabel("Điểm đi: ");
		lblDiemDi.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblDiemDi);
		
		JLabel lblGetDiemDi = new JLabel(/*tour.getDiemKH().getTenDiaDiem()*/ "Gia Lai");
		lblGetDiemDi.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetDiemDi);
		
		JLabel lblDiemDen = new JLabel("Điểm đến: ");
		lblDiemDen.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblDiemDen);
		
		JLabel lblGetDiemDen = new JLabel(/*tour.getDiemKH().getTenDiaDiem()*/ "Đà Lạt");
		lblGetDiemDen.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetDiemDen);
		
		JLabel lblPT = new JLabel("Phương tiện: ");
		lblPT.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblPT);
		
		JLabel lblGetPhuongTien = new JLabel(/*tour.getDiemKH().getTenDiaDiem()*/ "Xe khách");
		lblGetPhuongTien.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetPhuongTien);
		
		JLabel lblKS = new JLabel("Khách sạn: ");
		lblKS.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblKS);
		
		JLabel lblGetKS = new JLabel(/*tour.getDiemKH().getTenDiaDiem()*/ "Khách sạn 5 sao");
		lblGetKS.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetKS);
		
		JLabel lblNgayDi = new JLabel("Ngày đi: ");
		lblNgayDi.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblNgayDi);
		
		JLabel lblGetNgayDi = new JLabel(/*tour.getDiemKH().getTenDiaDiem()*/ "28/04/2023");
		lblGetNgayDi.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetNgayDi);
		
		JLabel lblNgayKT = new JLabel("Ngày kết thúc: ");
		lblNgayKT.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblNgayKT);
		
		JLabel lblGetNgayKT = new JLabel(/*tour.getDiemKH().getTenDiaDiem()*/ "30/04/2023");
		lblGetNgayKT.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetNgayKT);
		
		panelChiTiet.add(new JLabel(""));
		panelChiTiet.add(new JLabel(""));
		
		
		JLabel lblSoLuong = new JLabel("SL thành viên: ");
		lblSoLuong.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblSoLuong);
		
		JLabel lblGetSL = new JLabel(/*tour.getDiemKH().getTenDiaDiem()*/ "4");
		lblGetSL.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetSL);
		
		panelChiTiet.add(new JLabel(""));
		panelChiTiet.add(new JLabel(""));
		
		JLabel lblThanhTien = new JLabel("Thành Tiền: ");
		lblThanhTien.setFont(new Font("Arial", Font.BOLD, 17));
		panelChiTiet.add(lblThanhTien);
		
		JLabel lblGetThanhTien = new JLabel(/*tour.getDiemKH().getTenDiaDiem()*/ "12500000 đ");
		lblGetThanhTien.setFont(new Font("Arial", Font.PLAIN, 17));
		panelChiTiet.add(lblGetThanhTien);
		
		JPanel pnLine2 = new JPanel();
		pnLine2.add(new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"));
		panelCenter.add(Box.createVerticalStrut(10));
		panelCenter.add(pnLine2);
		
		JPanel panelSouth = new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		JLabel lblKet = new JLabel("Cảm ơn quý khách!");
		lblKet.setFont(new Font("Arial", Font.BOLD, 24));
		lblKet.setPreferredSize(new Dimension(225, 75));
		panelSouth.add(lblKet);
	}
	public static void main(String[] args) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String timeNow = timeFormat.format(new java.util.Date());
		java.util.Date utilDate;
		try {
			utilDate = timeFormat.parse(timeNow);
			java.sql.Timestamp sqlTimestamp  = new java.sql.Timestamp(utilDate.getTime());
			new HoaDon_GUI(new HoaDon("HD001", sqlTimestamp), new NhanVien("NV002"), new TourDuLich(), new KhachHang("KH001",  "","Phạm Hữu Thuận", "", "")).setVisible(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
