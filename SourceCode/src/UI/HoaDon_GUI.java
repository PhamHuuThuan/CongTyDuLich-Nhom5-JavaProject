package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.text.Document;

import BUS.PhuongTien_Bus;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhuongTien;
import Entity.TourDuLich;

public class HoaDon_GUI extends JFrame{
	private JButton btnIn;
	private HoaDon hd;
	private NhanVien nv;
	private TourDuLich tour;
	private KhachHang kh;
	private PhuongTien_Bus ptBus;
	private JMenu menuInHD;
	public HoaDon_GUI(HoaDon hd, NhanVien nv, TourDuLich tour, KhachHang kh) {
		setTitle("Hóa đơn");
		setSize(625, 650);
		setLocationRelativeTo(null);
		setResizable(false);
		this.hd = hd;
		this.kh = kh;
		this.tour = tour;
		this.nv = nv;
		ptBus = new PhuongTien_Bus();
		createGUI();
	}
	public void createGUI() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuInHD = new JMenu("Xuất hóa đơn");
		menuBar.add(menuInHD);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
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
		JLabel lblGetTenTour = new JLabel(tour.getTenTour());
		lblGetTenTour.setFont(new Font("Arial", Font.PLAIN, 14));
		pn1.add(lblTenTour);
		pn1.add(lblGetTenTour);
		panelCenter.add(pn1);
		
		JPanel panelChiTiet = new JPanel(new GridLayout(5, 4, 20, 20));
		panelCenter.add(panelChiTiet);
		
		JLabel lblDiemDi = new JLabel("Điểm đi: ");
		lblDiemDi.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblDiemDi);
		
		JLabel lblGetDiemDi = new JLabel(tour.getDiemKH().getTenDiaDiem());
		lblGetDiemDi.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetDiemDi);
		
		JLabel lblDiemDen = new JLabel("Điểm đến: ");
		lblDiemDen.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblDiemDen);
		
		JLabel lblGetDiemDen = new JLabel(tour.getDiemDen().getTenDiaDiem());
		lblGetDiemDen.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetDiemDen);
		
		JLabel lblPT = new JLabel("Phương tiện: ");
		lblPT.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblPT);
		PhuongTien phuongTien = ptBus.timPhuongTien(tour.getPhuongTien().getMaPT());
		JLabel lblGetPhuongTien = new JLabel(phuongTien.getTenPT());
		lblGetPhuongTien.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetPhuongTien);
		
		JLabel lblKS = new JLabel("Khách sạn: ");
		lblKS.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblKS);
		
		JLabel lblGetKS = new JLabel(tour.getKhachSan());
		lblGetKS.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetKS);
		
		JLabel lblNgayDi = new JLabel("Ngày đi: ");
		lblNgayDi.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblNgayDi);
		
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
		JLabel lblGetNgayDi = new JLabel(outputFormat.format(tour.getNgayDi()));
		lblGetNgayDi.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetNgayDi);
		
		JLabel lblNgayKT = new JLabel("Ngày kết thúc: ");
		lblNgayKT.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblNgayKT);
		
		JLabel lblGetNgayKT = new JLabel(outputFormat.format(tour.getNgayKetThuc()));
		lblGetNgayKT.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetNgayKT);
		
		panelChiTiet.add(new JLabel(""));
		panelChiTiet.add(new JLabel(""));
		
		
		JLabel lblSoLuong = new JLabel("SL thành viên: ");
		lblSoLuong.setFont(new Font("Arial", Font.BOLD, 14));
		panelChiTiet.add(lblSoLuong);
		
		JLabel lblGetSL = new JLabel(hd.getDsTV().size()+"");
		lblGetSL.setFont(new Font("Arial", Font.PLAIN, 14));
		panelChiTiet.add(lblGetSL);
		
		panelChiTiet.add(new JLabel(""));
		panelChiTiet.add(new JLabel(""));
		
		JLabel lblThanhTien = new JLabel("Thành Tiền: ");
		lblThanhTien.setFont(new Font("Arial", Font.BOLD, 16));
		panelChiTiet.add(lblThanhTien);
		
		JLabel lblGetThanhTien = new JLabel(hd.tinhThanhTien()+" đ");
		lblGetThanhTien.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGetThanhTien.setForeground(new Color(220, 20, 60));
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
	public void saveJFrameAsPdf(String pdfFilename) throws Exception {
	    // Capture screenshot of JFrame
	    Rectangle rect = getBounds();
	    BufferedImage image = new Robot().createScreenCapture(rect);
	    ImageIO.write(image, "png", new File("screenshot.png"));

	    // Create PDF document containing screenshot
	    com.itextpdf.text.Document document = new com.itextpdf.text.Document();
	    com.itextpdf.text.pdf.PdfWriter.getInstance(document, new FileOutputStream(pdfFilename));
	    document.open();
	    com.itextpdf.text.Image pdfImage = com.itextpdf.text.Image.getInstance("screenshot.png");
	    document.add(pdfImage);
	    document.close();
	    
	    new File("screenshot.png").delete();
	}
}
