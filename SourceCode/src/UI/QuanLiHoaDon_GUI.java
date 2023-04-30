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
import java.time.LocalDate;
import java.util.Date;
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
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Entity.NhanVien;

public class QuanLiHoaDon_GUI extends JFrame implements ActionListener, MouseListener{
	private JButton btnTrangChu, btnTour, btnDonHang, btnKH, btnQuanLi, btnNhanVien, btnTim, btnChiTietHD, btnLoc;
	private JTextField txtSDT;
	private JComboBox<NhanVien> cboNV;
	private JDatePickerImpl ngayLap;
	private DefaultTableModel tblModel;
	private JTable tblHD;
	private NhanVien nv;
	public QuanLiHoaDon_GUI(NhanVien nv) {
		setTitle("Vietour - Phan mem quan li tour du lich");
		setSize(1200, 820);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/travel.png"));
		this.nv = nv;
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
		panelSearch.add(new JLabel("SĐT: "));
		panelSearch.add(txtSDT = new JTextField(15));
		panelSearch.add(Box.createHorizontalStrut(20));
		panelSearch.add(btnTim = new JButton("Tìm"));
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
		panelLoc.add(btnLoc = new JButton("Lọc"));
		
		cboNV.setPreferredSize(ngayLap.getPreferredSize());
		
		String cols[] = {"Số HĐ", "Nhân Viên Tạo", "Tên Khách Hàng", "Ngày Lập HD", "Tên Tour", "Giá Tour", "Thành Tiền"};
		tblModel = new DefaultTableModel(cols, 0);
		tblHD = new JTable(tblModel);
		JScrollPane jScrollPane = new JScrollPane(tblHD, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelCenter.add(jScrollPane);
		
		JPanel panelSouth = new JPanel();
		add(panelSouth,BorderLayout.SOUTH);
		panelSouth.add(btnChiTietHD = new JButton("Xem chi tiết hóa đơn"));
		panelSouth.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		btnTim.setFont(new Font("Arial", Font.BOLD, 14));
		btnTim.setBorder(new EmptyBorder(10, 30, 10, 30));
		btnTim.setBackground(new Color(100, 149, 237));
		btnTim.setForeground(new Color(255, 255, 255));
		
		btnLoc.setFont(new Font("Arial", Font.BOLD, 14));
		btnLoc.setBorder(new EmptyBorder(10, 30, 10, 30));
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
	public static void main(String[] args) {
		NhanVien nv = new NhanVien("NV001", "0123456789", "12345", "Phạm Hữu Thuận", java.sql.Date.valueOf(LocalDate.of(2003, 5, 14)), true, "064xxxxxxxxx",  java.sql.Date.valueOf(LocalDate.of(2023, 3, 15)));
		new QuanLiHoaDon_GUI(nv).setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnTrangChu) {
			setVisible(false);
			new Home_GUI(nv).setVisible(true);
		}else if(o==btnDonHang) {
			
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
				    new EmptyBorder(10, 30, 10, 30)
				));
		}
	}
}
