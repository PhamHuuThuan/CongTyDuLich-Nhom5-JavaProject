package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.DiaDiem_Bus;
import BUS.KhachHang_Bus;
import BUS.PhuongTien_Bus;
import Entity.DiaDiem;
import Entity.KhachHang;
import Entity.PhuongTien;
import Entity.NhanVien;
import Entity.TourDuLich;
import Util.CodeGenerator;

public class DiaDiem_GUI extends JFrame implements MouseListener,ActionListener{
	private JButton btnTrangChu, btnTour, btnDiaDiem, btnThongKe, btnNhanVien;
	private JLabel lblMaDKH,lblTenDKH,lblMaDDL,lblDiemDL,lblTenPT,lblMaPT;
	private JTextField txtMaDiemKH,txtTenDiemKH,txtMaDiemDL,txtTenDiemDL,txtMaPT,txtTenPT;
	private JTable tblDiaDiemKH,tblDiaDiemKT,tblPTien;
	private DefaultTableModel modelDDKH,modelDDKT,modelPT;
	private JButton btnThem,btnThem1,btnThem2, btnSua,btnSua1,btnSua2, btnXoa, btnXoa1, btnXoa2, btnReset, btnReset1, btnReset2;
	private DiaDiem_Bus dd_bus = new DiaDiem_Bus();
	private ArrayList<DiaDiem> dsDiaDiem;
	private PhuongTien_Bus pt_bus = new PhuongTien_Bus();
	private ArrayList<PhuongTien> dsPhuongTien;
	private CodeGenerator maDiemKHGenerator,maDiemDLGenerator,maPTGenerator;
	private NhanVien nv;
	
	public DiaDiem_GUI(NhanVien nv) {
		setTitle("Vietour - Phần mềm quản lí tour du lịch");
		setSize(1100, 750);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/travel.png"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
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
		
		ImageIcon imgTour = new ImageIcon("img/add.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnTour = new JButton("Tour", imgTour));
		btnTour.setFont(new Font("Arial", Font.BOLD, 14));
		btnTour.setBackground(Color.WHITE);
		btnTour.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTour.setBackground(new Color(60, 179, 113));
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
		btnDiaDiem.setBackground(new Color(255, 165, 0));
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
		
		//Thêm/ sửa/ xóa/ điểm khởi hành, điểm kết thúc
		JPanel panelAdd = new JPanel();
		panelAdd.add(Box.createVerticalStrut(10));
		panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));
		JPanel pnTieuDe = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTieuDe = new JLabel("ĐIỂM KHỞI HÀNH");
		lblTieuDe.setFont(new Font("Arial",Font.BOLD,15));
		lblTieuDe.setForeground(Color.BLACK);
		pnTieuDe.add(lblTieuDe);
		panelAdd.add(pnTieuDe);
		add(panelAdd,BorderLayout.WEST);
		
		JPanel pnMa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMaDKH = new JLabel("Mã điểm khởi hành");
		lblMaDKH.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaDKH.setForeground(new Color(0, 102, 204));
		pnMa.add(lblMaDKH);
		panelAdd.add(pnMa);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtMaDiemKH = new JTextField(20));
		txtMaDiemKH.setEditable(false);
		
		JPanel pnTen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTenDKH = new JLabel("Tên điểm khởi hành");
		lblTenDKH.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenDKH.setForeground(new Color(0, 102, 204));
		pnTen.add(lblTenDKH);
		panelAdd.add(pnTen);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtTenDiemKH = new JTextField(20));
		
		JPanel pnButtonTop = new JPanel(new FlowLayout());
		pnButtonTop.add(btnThem=new JButton("Thêm", new ImageIcon("img/plus1.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		pnButtonTop.add(btnSua=new JButton("Sửa", new ImageIcon("Img/edit-tour.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		pnButtonTop.add(btnXoa=new JButton("Xóa", new ImageIcon("Img/delete.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		ImageIcon imgReset = new ImageIcon("Img/reset-icon.png");
		pnButtonTop.add(btnReset=new JButton(imgReset));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 144, 255));
		btnReset.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		panelAdd.add(pnButtonTop);
		

//		//form ds tour và chi tiết dia diem
		JPanel panelThongTin = new JPanel();
		panelThongTin.add(Box.createHorizontalStrut(20));
		panelThongTin.setLayout(new BoxLayout(panelThongTin, BoxLayout.Y_AXIS));
		panelThongTin.setBorder(BorderFactory.createEmptyBorder(0, 40, 0,0));
		add(panelThongTin, BorderLayout.CENTER);
		
		JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelThongTin.add(panelTop);
		
		String cols[] = {"Mã điểm khởi hành", "Tên điểm khởi hành"};
		modelDDKH = new DefaultTableModel(cols, 0);
		tblDiaDiemKH = new JTable(modelDDKH);
		tblDiaDiemKH.setFont(new Font("Arial", Font.PLAIN, 14));
		tblDiaDiemKH.getTableHeader().setBackground(new Color(0, 0, 204));
		tblDiaDiemKH.getTableHeader().setForeground(Color.WHITE);
		tblDiaDiemKH.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tblDiaDiemKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDiaDiemKH.getColumnModel().getColumn(0).setPreferredWidth(300);
		tblDiaDiemKH.getColumnModel().getColumn(1).setPreferredWidth(470);
		JScrollPane tblScroll = new JScrollPane(tblDiaDiemKH,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tblScroll.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 130));
		panelThongTin.add(tblScroll);
		panelThongTin.add(Box.createVerticalStrut(50));
		
		//Diem du lich
		panelAdd.add(Box.createVerticalStrut(30));
		lblTieuDe = new JLabel("ĐIỂM DU LỊCH");
		pnTieuDe = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Arial",Font.BOLD,15));
		lblTieuDe.setForeground(Color.BLACK);
		panelAdd.add(pnTieuDe);
		
		JPanel pnMaDL = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMaDDL = new JLabel("Mã điểm kết thúc");
		lblMaDDL.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaDDL.setForeground(new Color(0, 102, 204));
		pnMaDL.add(lblMaDDL);
		panelAdd.add(pnMaDL);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtMaDiemDL = new JTextField(20));
		txtMaDiemDL.setEditable(false);
		
		JPanel pnDDen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDiemDen = new JLabel("Tên điểm kết thúc");
		lblDiemDen.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiemDen.setForeground(new Color(0, 102, 204));
		pnDDen.add(lblDiemDen);
		panelAdd.add(pnDDen);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtTenDiemDL = new JTextField(20));
		
		pnButtonTop = new JPanel(new FlowLayout());
		pnButtonTop.add(btnThem1=new JButton("Thêm", new ImageIcon("img/plus1.png")));
		btnThem1.setForeground(Color.WHITE);
		btnThem1.setBackground(new Color(30, 144, 255));
		btnThem1.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		pnButtonTop.add(btnSua1=new JButton("Sửa", new ImageIcon("Img/edit-tour.png")));
		btnSua1.setForeground(Color.WHITE);
		btnSua1.setBackground(new Color(30, 144, 255));
		btnSua1.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		pnButtonTop.add(btnXoa1=new JButton("Xóa", new ImageIcon("Img/delete.png")));
		btnXoa1.setForeground(Color.WHITE);
		btnXoa1.setBackground(new Color(30, 144, 255));
		btnXoa1.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		imgReset = new ImageIcon("Img/reset-icon.png");
		pnButtonTop.add(btnReset1=new JButton(imgReset));
		btnReset1.setForeground(Color.WHITE);
		btnReset1.setBackground(new Color(30, 144, 255));
		btnReset1.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		panelAdd.add(pnButtonTop);
		
//		//form ds tour và chi tiết dia diem
		String cols2[] = {"Mã điểm kết thúc", "Tên điểm kết thúc"};
		modelDDKT = new DefaultTableModel(cols2, 0);
		tblDiaDiemKT = new JTable(modelDDKT);
		tblDiaDiemKT.setFont(new Font("Arial", Font.PLAIN, 14));
		tblDiaDiemKT.getTableHeader().setBackground(new Color(0, 0, 204));
		tblDiaDiemKT.getTableHeader().setForeground(Color.WHITE);
		tblDiaDiemKT.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tblDiaDiemKT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDiaDiemKT.getColumnModel().getColumn(0).setPreferredWidth(300);
		tblDiaDiemKT.getColumnModel().getColumn(1).setPreferredWidth(470);
		tblDiaDiemKT.setSize(MAXIMIZED_HORIZ, 150);
		tblScroll = new JScrollPane(tblDiaDiemKT,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tblScroll.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 135));
		panelThongTin.add(tblScroll);
		panelThongTin.add(Box.createVerticalStrut(50));
		
		
		//Phuong tien
		panelAdd.add(Box.createVerticalStrut(30));
		lblTieuDe = new JLabel("PHƯƠNG TIỆN");
		pnTieuDe = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Arial",Font.BOLD,15));
		lblTieuDe.setForeground(Color.BLACK);
		panelAdd.add(pnTieuDe);
		
		JPanel pnMaPT = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblMaPT = new JLabel("Mã phương tiện");
		lblMaPT.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaPT.setForeground(new Color(0, 102, 204));
		pnMaPT.add(lblMaPT);
		panelAdd.add(pnMaPT);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtMaPT = new JTextField(20));
		txtMaPT.setEditable(false);
		
		JPanel pnTenPT = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblTenPT = new JLabel("Tên phương tiện");
		lblTenPT.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenPT.setForeground(new Color(0, 102, 204));
		pnTenPT.add(lblTenPT);
		panelAdd.add(pnTenPT);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtTenPT = new JTextField(20));
		
		pnButtonTop = new JPanel(new FlowLayout());
		pnButtonTop.add(btnThem2=new JButton("Thêm", new ImageIcon("img/plus1.png")));
		btnThem2.setForeground(Color.WHITE);
		btnThem2.setBackground(new Color(30, 144, 255));
		btnThem2.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		pnButtonTop.add(btnSua2=new JButton("Sửa", new ImageIcon("Img/edit-tour.png")));
		btnSua2.setForeground(Color.WHITE);
		btnSua2.setBackground(new Color(30, 144, 255));
		btnSua2.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		pnButtonTop.add(btnXoa2=new JButton("Xóa", new ImageIcon("Img/delete.png")));
		btnXoa2.setForeground(Color.WHITE);
		btnXoa2.setBackground(new Color(30, 144, 255));
		btnXoa2.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		imgReset = new ImageIcon("Img/reset-icon.png");
		pnButtonTop.add(btnReset2=new JButton(imgReset));
		btnReset2.setForeground(Color.WHITE);
		btnReset2.setBackground(new Color(30, 144, 255));
		btnReset2.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
		panelAdd.add(pnButtonTop);
		
		String cols3[] = {"Mã phương tiện", "Tên phương tiện"};
		modelPT = new DefaultTableModel(cols3, 0);
		tblPTien = new JTable(modelPT);
		tblPTien.setFont(new Font("Arial", Font.PLAIN, 14));
		tblPTien.getTableHeader().setBackground(new Color(0, 0, 204));
		tblPTien.getTableHeader().setForeground(Color.WHITE);
		tblPTien.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tblPTien.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblPTien.getColumnModel().getColumn(0).setPreferredWidth(300);
		tblPTien.getColumnModel().getColumn(1).setPreferredWidth(470);
		tblScroll = new JScrollPane(tblPTien,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tblScroll.setPreferredSize(new Dimension(MAXIMIZED_HORIZ,150));
		panelThongTin.add(tblScroll);
		panelThongTin.add(Box.createVerticalStrut(10));
		
		showDataOnTableDiemKH();
		showDataOnTableDiemKT();
		showDataOnTablePTien();
		maDiemKHGenerator = new CodeGenerator();
		maDiemDLGenerator = new CodeGenerator();
		maPTGenerator = new CodeGenerator();
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDiaDiem.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnThem.addActionListener(this);
		btnThem1.addActionListener(this);
		btnThem2.addActionListener(this);
		btnSua.addActionListener(this);
		btnSua1.addActionListener(this);
		btnSua2.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoa1.addActionListener(this);
		btnXoa2.addActionListener(this);
		btnReset.addActionListener(this);
		btnReset1.addActionListener(this);
		btnReset2.addActionListener(this);
		tblDiaDiemKH.addMouseListener(this);
		tblDiaDiemKT.addMouseListener(this);
		tblPTien.addMouseListener(this);
		btnThongKe.addActionListener(this);
	}
	
	public void showDataOnTableDiemKH() {
	    DefaultTableModel model = (DefaultTableModel) tblDiaDiemKH.getModel();
	    model.getDataVector().removeAllElements();
	    ArrayList<DiaDiem> dsDD = dd_bus.getAllDiemDi();
	    for (DiaDiem dd : dsDD) {
	        Object[] row = { dd.getMaDiaDiem(),dd.getTenDiaDiem()};
	        model.addRow(row);
	    }
	}
	
	public void showDataOnTableDiemKT() {
	    DefaultTableModel model = (DefaultTableModel) tblDiaDiemKT.getModel();
	    model.getDataVector().removeAllElements();
	    ArrayList<DiaDiem> dsDD = dd_bus.getAllDiemDuLich();
	    for (DiaDiem dd : dsDD) {
	        Object[] row = { dd.getMaDiaDiem(),dd.getTenDiaDiem()};
	        model.addRow(row);
	    }
	}
	
	public void showDataOnTablePTien() {
	    DefaultTableModel model = (DefaultTableModel) tblPTien.getModel();
	    model.getDataVector().removeAllElements();
	    ArrayList<PhuongTien> dsPT = pt_bus.getAllPhuongTien();
	    for (PhuongTien pt : dsPT) {
	        Object[] row = { pt.getMaPT(),pt.getTenPT()};
	        model.addRow(row);
	    }
	}
	
	public void XoaHetTableKH() {
		DefaultTableModel dm = (DefaultTableModel) tblDiaDiemKH.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void XoaHetTableKT() {
		DefaultTableModel dm = (DefaultTableModel) tblDiaDiemKT.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void XoaHetTablePT() {
		DefaultTableModel dm = (DefaultTableModel) tblPTien.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	private void suaThongTinDDKH() {                                          
        DiaDiem dd = new DiaDiem();
        dd.setMaDiaDiem(txtMaDiemKH.getText().trim());
        dd.setTenDiaDiem(txtTenDiemKH.getText().trim());
        if (dd_bus.updateDiaDiem(dd)) {
            JOptionPane.showMessageDialog(this, "Cập nhật tên địa điểm khởi hành thành công!");
            XoaHetTableKH();
            showDataOnTableDiemKH();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật tên địa điểm khởi hành thất bại!!!");
        }
    }
	private void suaThongTinDDDL() {                                          
        DiaDiem dd = new DiaDiem();
        dd.setMaDiaDiem(txtMaDiemDL.getText().trim());
        dd.setTenDiaDiem(txtTenDiemDL.getText().trim());
        if (dd_bus.updateDiaDiem(dd)) {
            JOptionPane.showMessageDialog(this, "Cập nhật tên địa điểm du lịch thành công!");
            XoaHetTableKT();
            showDataOnTableDiemKT();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật tên địa điểm du lịch thất bại!!!");
        }
    }
	
	private void suaThongTinPT() {                                          
       PhuongTien pt = new PhuongTien();
        pt.setMaPT(txtMaPT.getText().trim());
        pt.setTenPT(txtTenPT.getText().trim());
        if (pt_bus.updatePhuongTien(pt)) {
            JOptionPane.showMessageDialog(this, "Cập nhật tên phương tiện thành công!");
            XoaHetTablePT();
            showDataOnTablePTien();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật tên phương tiện thất bại!!!");
        }
    }
	
	public void xoaDDKH() {
		int row = tblDiaDiemKH.getSelectedRow();
		if (row != -1) {
			int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa địa điểm này?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				String maXoa = tblDiaDiemKH.getValueAt(row, 0).toString();
				if (dd_bus.deleteDiaDiem(maXoa)) {
					JOptionPane.showMessageDialog(this, "Xóa địa điểm khởi hành thành công");
					modelDDKH.removeRow(row);
				} else {
					JOptionPane.showMessageDialog(this, "Xóa địa điểm khởi hành thất bại !!!!");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn địa điểm cần xóa");
		}
	}
	
	public void xoaDDDL() {
		int row = tblDiaDiemKT.getSelectedRow();
		if (row != -1) {
			int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa địa điểm này?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				String maXoa = tblDiaDiemKT.getValueAt(row, 0).toString();
				if (dd_bus.deleteDiaDiem(maXoa)) {
					JOptionPane.showMessageDialog(this, "Xóa địa điểm du lịch thành công");
					modelDDKT.removeRow(row);
				} else {
					JOptionPane.showMessageDialog(this, "Xóa địa điểm du lịch thất bại !!!!");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn địa điểm cần xóa");
		}
	}
	
	public void xoaPT() {
		int row = tblPTien.getSelectedRow();
		if (row != -1) {
			int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa phương tiện này?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				String maXoa = tblPTien.getValueAt(row, 0).toString();
				if (pt_bus.deletePhuongTien(maXoa)) {
					JOptionPane.showMessageDialog(this, "Xóa phương tiện thành công");
					modelPT.removeRow(row);
				} else {
					JOptionPane.showMessageDialog(this, "Xóa phương tiện thất bại !!!");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn phương tiện cần xóa");
		}
	}
	
	public void resetDKH() {
		txtMaDiemKH.setText(null);
		txtTenDiemKH.setText(null);
	}
	public void resetDKT() {
		txtMaDiemDL.setText(null);
		txtTenDiemDL.setText(null);
	}
	public void resetPT() {
		txtMaPT.setText(null);
		txtTenPT.setText(null);
	}
	
	public boolean validDataDiemKH() {
		String maDiemKH = txtMaDiemKH.getText().trim();
		String tenDiemKH = txtTenDiemKH.getText().trim();
		
		if(tenDiemKH.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Tên điểm KH không được để trống !!!");
		    return false;
		}
		if (!tenDiemKH.matches("^[\\p{L} ]+$")) {
		    JOptionPane.showMessageDialog(this, "Tên điểm KH không hợp lệ. Vui lòng nhập lại.");
		    return false;
		}
		return true;
	}
	
	public DiaDiem convertTableToDDKH() {
		String maDiemKH = txtMaDiemKH.getText().trim();
		String tenDiemKH = txtTenDiemKH.getText().trim();
		
		String maDDKH ="";
		if(txtMaDiemKH.getText().trim()==null || txtMaDiemKH.getText().length()==0) {
			maDDKH = maDiemKHGenerator.generateMaDiaDiemKH();
		}else {
			maDDKH = txtMaDiemKH.getText().trim();
		}
		return new DiaDiem(maDDKH, tenDiemKH);
	}
	
	public void themDiaDiemKH() {
		if(validDataDiemKH()) {
			DiaDiem diaDiem = convertTableToDDKH();
			if(dd_bus.themDiaDiem(diaDiem)) {
				 JOptionPane.showMessageDialog(this, "Thêm địa điểm thành công");
			     XoaHetTableKH();
			     showDataOnTableDiemKH();
			}else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại! Trùng mã!");
			}
		}
	}
	
	public boolean validDataDiemDL() {
		String maDiemDL = txtMaDiemDL.getText().trim();
		String tenDiemDL = txtTenDiemDL.getText().trim();
		
		if(tenDiemDL.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Tên điểm DL không được để trống !!!");
		    return false;
		}
		if (!tenDiemDL.matches("^[\\p{L} ]+$")) {
		    JOptionPane.showMessageDialog(this, "Tên điểm DL không hợp lệ. Vui lòng nhập lại.");
		    return false;
		}
		return true;
	}
	
	public DiaDiem convertTableToDDDL() {
		String maDiemDL = txtMaDiemDL.getText().trim();
		String tenDiemDL = txtTenDiemDL.getText().trim();
		
		String maDDDL ="";
		if(txtMaDiemDL.getText().trim()==null || txtMaDiemDL.getText().length()==0) {
			maDDDL = maDiemDLGenerator.generateMaDiaDiemDL();
		}else {
			maDDDL = txtMaDiemDL.getText().trim();
		}
		return new DiaDiem(maDDDL, tenDiemDL);
	}
	
	public void themDiaDiemDL() {
		if(validDataDiemDL()) {
			DiaDiem diaDiem = convertTableToDDDL();
			if(dd_bus.themDiaDiem(diaDiem)) {
				 JOptionPane.showMessageDialog(this, "Thêm địa điểm thành công");
			     XoaHetTableKT();
			     showDataOnTableDiemKT();
			}else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại! Trùng mã!");
			}
		}
	}
	
	public boolean validDataPT() {
		String maPT = txtMaPT.getText().trim();
		String tenPT = txtTenPT.getText().trim();
		
		if(tenPT.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Tên PT không được để trống !!!");
		    return false;
		}
		if (!tenPT.matches("^[\\p{L} ]+$")) {
		    JOptionPane.showMessageDialog(this, "Tên PT không hợp lệ. Vui lòng nhập lại.");
		    return false;
		}
		return true;
	}
	public PhuongTien convertTableToPT() {
		String maPT = txtMaPT.getText().trim();
		String tenPT = txtTenPT.getText().trim();
		
		String maPTien ="";
		if(txtMaPT.getText().trim()==null || txtMaPT.getText().length()==0) {
			maPT = maPTGenerator.generateMaPTien();
		}else {
			maPTien = txtMaPT.getText().trim();
		}
		return new PhuongTien(maPT, tenPT);
	}
	
	public void themPTien() {
		if(validDataPT()) {
			PhuongTien phuongTien = convertTableToPT();
			if(pt_bus.themPhuongTien(phuongTien)) {
				 JOptionPane.showMessageDialog(this, "Thêm phương tiện thành công");
			     XoaHetTablePT();
			     showDataOnTablePTien();
			}else {
				JOptionPane.showMessageDialog(this, "Thêm phương tiện! Trùng mã!");
			}
		}
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
		}else if(o==btnThem) {
			themDiaDiemKH();
		}else if(o==btnThem1) {
			themDiaDiemDL();
		}else if(o==btnThem2) {
			themPTien();
		}else if(o==btnSua) {
			suaThongTinDDKH();
		}else if(o==btnSua1) {
			suaThongTinDDDL();
		}else if(o==btnSua2) {
			suaThongTinPT();
		}else if(o==btnXoa) {
			xoaDDKH();
		}else if(o==btnXoa1) {
			xoaDDDL();
		}else if(o==btnXoa2) {
			xoaPT();
		}else if(o==btnReset) {
			resetDKH();
		}else if(o==btnReset1) {
			resetDKT();
		}else if(o==btnReset2) {
			resetPT();
		}else if(o==btnThongKe) {
			setVisible(false);
			new ThongKe_GUI(nv).setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblDiaDiemKH.getSelectedRow();
	    if (row != -1) {
	        txtMaDiemKH.setText(modelDDKH.getValueAt(row, 0).toString());
	        txtTenDiemKH.setText(modelDDKH.getValueAt(row, 1).toString());
	    }
	    
	    int row1 = tblDiaDiemKT.getSelectedRow();
	    if (row1 != -1) {
	        txtMaDiemDL.setText(modelDDKT.getValueAt(row1, 0).toString());
	        txtTenDiemDL.setText(modelDDKT.getValueAt(row1, 1).toString());
	    }
	    
	    int row2 = tblPTien.getSelectedRow();
	    if (row2 != -1) {
	        txtMaPT.setText(modelPT.getValueAt(row2, 0).toString());
	        txtTenPT.setText(modelPT.getValueAt(row2, 1).toString());
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

}
