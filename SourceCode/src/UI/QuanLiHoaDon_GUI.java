package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.jdatepicker.DateModel;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import BUS.HoaDon_Bus;
import BUS.NhanVien_Bus;
import BUS.ThanhVien_Bus;
import Entity.HoaDon;
import Entity.NhanVien;

public class QuanLiHoaDon_GUI extends JFrame implements ActionListener, MouseListener{
	private JButton btnTrangChu, btnTour, btnDonHang, btnKH, btnQuanLi, btnNhanVien, btnTim, btnChiTietHD, btnLoc;
	private JTextField txtSDT;
	private JComboBox<NhanVien> cboNV;
	private JDatePickerImpl ngayLap;
	private DefaultTableModel tblModel;
	private JTable tblHD;
	private NhanVien nv;
	private HoaDon_Bus hdBus;
	private ThanhVien_Bus tvBus;
	private NhanVien_Bus nvBus;
	private ArrayList<HoaDon> ds;
	public QuanLiHoaDon_GUI(NhanVien nv) {
		setTitle("Vietour - Phần mềm quản lí tour du lịch");
		setSize(1200, 820);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/travel.png"));
		this.nv = nv;
		hdBus = new HoaDon_Bus();
		tvBus = new ThanhVien_Bus();
		nvBus = new NhanVien_Bus();
		ds=  new ArrayList<>();
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
		btnTour.setBackground(new Color(60, 179, 113));
		btnTour.setForeground(new Color(255, 255, 255));
		btnTour.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgHD = new ImageIcon("img/ticket.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnDonHang = new JButton("Hóa Đơn", imgHD));
		btnDonHang.setFont(new Font("Arial", Font.BOLD, 14));
		btnDonHang.setBackground(Color.WHITE);
		btnDonHang.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnDonHang.setBackground(new Color(255, 165, 0));
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
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		add(panelCenter,BorderLayout.CENTER);
		
		Box b = Box.createHorizontalBox();
		b.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
		b.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
		JPanel panelSearch = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelSearch.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
		b.add(panelSearch);
		b.add(Box.createHorizontalStrut(10));
		panelCenter.add(b);
		
		//tim kiem
		panelSearch.add(new JLabel("SĐT KH: "));
		panelSearch.add(txtSDT = new JTextField(15));
		panelSearch.add(Box.createHorizontalStrut(20));
		panelSearch.add(btnTim = new JButton("Tìm", new ImageIcon("Img/search-icon.png")));
		txtSDT.setBorder(new CompoundBorder(
			    new MatteBorder(0, 0, 1, 0, new Color(0, 250, 154)),
			    new EmptyBorder(5, 10, 5, 10)
			));
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		//loc hoa don
		JPanel panelLoc = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelLoc.setBorder(BorderFactory.createTitledBorder("Lọc hóa đơn"));
		b.add(panelLoc);
		
		panelLoc.add(new JLabel("Nhân Viên:"));
		panelLoc.add(cboNV = new JComboBox<NhanVien>());
		panelLoc.add(Box.createHorizontalStrut(25));
		cboNV.addItem(null);
		for(NhanVien nv : nvBus.getALLNhanVien()) {
			cboNV.addItem(nv);
		}
		
		panelLoc.add(new JLabel("Ngày lập:"));
		UtilDateModel model = new UtilDateModel();
		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
		ngayLap = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		panelLoc.add(ngayLap);
		panelLoc.add(Box.createHorizontalStrut(25));
		panelLoc.add(btnLoc = new JButton("Lọc", new ImageIcon("img/loc.png")));
		
		cboNV.setPreferredSize(ngayLap.getPreferredSize());
		
		String cols[] = {"Số HĐ", "Nhân Viên Tạo", "Tên Khách Hàng", "Ngày Lập HD", "Tên Tour", "Giá Tour", "Thành Tiền"};
		tblModel = new DefaultTableModel(cols, 0);
		tblHD = new JTable(tblModel);
		tblHD.setFont(new Font("Arial", Font.PLAIN, 14));
		tblHD.setRowHeight(25);
		tblHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblHD.getColumnModel().getColumn(0).setPreferredWidth(75);
		tblHD.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblHD.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblHD.getColumnModel().getColumn(3).setPreferredWidth(150);
		tblHD.getColumnModel().getColumn(4).setPreferredWidth(300);
		tblHD.getColumnModel().getColumn(5).setPreferredWidth(120);
		tblHD.getColumnModel().getColumn(6).setPreferredWidth(120);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		tblHD.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		tblHD.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		tblHD.getTableHeader().setBackground(new Color(30, 144, 255));
		tblHD.getTableHeader().setForeground(Color.WHITE);
		tblHD.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		JScrollPane jScrollPane = new JScrollPane(tblHD, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelCenter.add(jScrollPane);
		
		JPanel panelSouth = new JPanel();
		add(panelSouth,BorderLayout.SOUTH);
		panelSouth.add(btnChiTietHD = new JButton("Xem chi tiết hóa đơn", new ImageIcon("Img/bills.png")));
		panelSouth.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		btnTim.setFont(new Font("Arial", Font.BOLD, 14));
		btnTim.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnTim.setBackground(new Color(100, 149, 237));
		btnTim.setForeground(new Color(255, 255, 255));
		
		btnLoc.setFont(new Font("Arial", Font.BOLD, 14));
		btnLoc.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnLoc.setBackground(new Color(100, 149, 237));
		btnLoc.setForeground(new Color(255, 255, 255));
		
		btnChiTietHD.setFont(new Font("Arial", Font.BOLD, 16));
		btnChiTietHD.setBorder(new EmptyBorder(15, 50, 15, 50));
		btnChiTietHD.setBackground(new Color(255, 160, 122));
		btnChiTietHD.setForeground(new Color(255, 255, 255));
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDonHang.addActionListener(this);
		btnQuanLi.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnKH.addActionListener(this);
		btnTim.addActionListener(this);
		btnLoc.addActionListener(this);
		btnChiTietHD.addActionListener(this);
		
		btnTrangChu.addMouseListener(this);
		btnTour.addMouseListener(this);
		btnDonHang.addMouseListener(this);
		btnKH.addMouseListener(this);
		btnQuanLi.addMouseListener(this);
		btnNhanVien.addMouseListener(this);
		btnLoc.addMouseListener(this);
		btnTim.addMouseListener(this);
		btnChiTietHD.addMouseListener(this);
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
		}else if(o==btnTim) {
			timTheoSDT();
		}else if(o==btnLoc) {
			locTour();
		}else if(o==btnChiTietHD) {
			xemChiTietHD();
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
		JButton button = (JButton) e.getSource();
		button.setBorder(new CompoundBorder(
				    new MatteBorder(0, 0, 2, 0, new Color(220, 20, 60)),
				    button.getBorder()
				));
	}
	@Override
	public void mouseExited(MouseEvent e) {
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
		else if(e.getSource()==btnChiTietHD) {
			button.setBorder(new CompoundBorder(
				    new MatteBorder(0, 0, 0, 0, new Color(255, 69, 0)),
				    new EmptyBorder(15, 50, 15, 50)
				));
		}
		else {
			button.setBorder(new CompoundBorder(
				    new MatteBorder(0, 0, 0, 0, new Color(255, 69, 0)),
				    new EmptyBorder(10, 20, 10, 20)
				));
		}
	}
	public void addRow(HoaDon hd) {
		DecimalFormat df = new DecimalFormat("#,###");
		SimpleDateFormat fmD = new SimpleDateFormat("dd/MM/yyyy");
		tblModel.addRow(new Object[] {hd.getSoHoaDon(), hd.getNv().getTenNV(), hd.getKh().getTenKH(), fmD.format(hd.getNgayTaoHD()) , hd.getTour().getTenTour(), df.format(hd.getTour().getGia()) , df.format(hd.tinhThanhTien())});
	}
	public void timTheoSDT(){
		String sdt = txtSDT.getText().trim();
		boolean ptSDT = Pattern.matches("[0-9]{10,11}", sdt);
		if(!ptSDT) {
			JOptionPane.showMessageDialog(this, "Error: SDT chỉ gồm các chữ số và độ dài 10-11 số!");
			return;
		}
		dataToTable(hdBus.getHoaDonTheoSoDT(sdt));
	}
	public void dataToTable(ArrayList<HoaDon> dsHD) {
		tblModel.setRowCount(0);
		ds = dsHD;
		for(HoaDon hd: ds) {
			hd.setDsTV(tvBus.getThanhVienTheoMaHD(hd.getSoHoaDon()));
			addRow(hd);
		}
	}
	public void locTour() {
		NhanVien nv = (NhanVien) cboNV.getSelectedItem();
		DateModel<?> model = ngayLap.getModel();
		int day = model.getDay();
		int month = model.getMonth();
		int year = model.getYear();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		java.sql.Date date = new java.sql.Date(calendar.getTimeInMillis());
		
		if(nv==null && ngayLap.getModel().getValue()==null) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày và nhân viên");
		}else if(nv==null) {
			dataToTable(hdBus.getHoaDonTheoNgayLap(date));
		}else if(ngayLap.getModel().getValue()==null) {
			dataToTable(hdBus.getHoaDonTheoNhanVien(nv));
		}else {
			dataToTable(hdBus.getHoaDonTheoNhanVienVaNgayLap(nv, date));
		}
	}
	public void xemChiTietHD() {
		int index = tblHD.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "Bạn cần chọn hóa đơn muốn xem!");
			return;
		}
		new HoaDon_GUI(ds.get(index), nv, ds.get(index).getTour(), ds.get(index).getKh()).setVisible(true);;
	}
}
