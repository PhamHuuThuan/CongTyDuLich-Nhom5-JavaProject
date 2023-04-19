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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DiaDiem_GUI extends JFrame implements MouseListener,ActionListener{
	private JButton btnTrangChu, btnTour, btnDiaDiem, btnThongKe, btnNhanVien;
	private JLabel lblMaDKH,lblTenDKH,lblMaDDL,lblDiemDL,lblTenPT,lblMaPT;
	private JTextField txtMaDiemKH,txtTenDiemKH,txtMaDiemDL,txtDiemDL,txtMaPT,txtTenPT;
	private JTable tblDiaDiem;
	private DefaultTableModel modelDD;
	private JButton btnThem, btnSua, btnReset, btnXoa;
	
	public DiaDiem_GUI() {
		setTitle("Vietour - Phần mềm quản lí tour du lịch");
		setSize(1100, 750);
		setLocationRelativeTo(null);
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
		panelHead.add(btnNhanVien = new JButton(": Nguyễn Văn A", imgUser));
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
		pnButtonTop.add(btnThem=new JButton("Thêm"));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		pnButtonTop.add(btnSua=new JButton("Sửa"));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		pnButtonTop.add(btnXoa=new JButton("Xóa"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		ImageIcon imgReset = new ImageIcon("img/reset.png");
		pnButtonTop.add(btnReset=new JButton(imgReset));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 144, 255));
		btnReset.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		panelAdd.add(pnButtonTop);
		

//		//form ds tour và chi tiết dia diem
		JPanel panelThongTin = new JPanel();
		panelThongTin.add(Box.createHorizontalStrut(20));
		panelThongTin.setLayout(new BoxLayout(panelThongTin, BoxLayout.Y_AXIS));
		panelThongTin.setBorder(BorderFactory.createEmptyBorder(0, 40, 0,0));
		add(panelThongTin, BorderLayout.CENTER);
		
		JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelThongTin.add(panelTop);
		
		String cols[] = {"Mã địa điểm", "Tên địa điểm "};
		modelDD = new DefaultTableModel(cols, 0);
		tblDiaDiem = new JTable(modelDD);
		tblDiaDiem.setFont(new Font("Arial", Font.PLAIN, 14));
		tblDiaDiem.getTableHeader().setBackground(new Color(0, 0, 204));
		tblDiaDiem.getTableHeader().setForeground(Color.WHITE);
		tblDiaDiem.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tblDiaDiem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDiaDiem.getColumnModel().getColumn(0).setPreferredWidth(300);
		tblDiaDiem.getColumnModel().getColumn(1).setPreferredWidth(600);
		tblDiaDiem.setSize(MAXIMIZED_HORIZ, 150);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		tblDiaDiem.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		JScrollPane tblScroll = new JScrollPane(tblDiaDiem,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tblScroll.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 100));
		panelThongTin.add(tblScroll);
		panelThongTin.add(Box.createVerticalStrut(130));
		
		//Diem du lich
		panelAdd.add(Box.createVerticalStrut(30));
		lblTieuDe = new JLabel("ĐIỂM DU LỊCH");
		pnTieuDe = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Arial",Font.BOLD,15));
		lblTieuDe.setForeground(Color.BLACK);
		panelAdd.add(pnTieuDe);
		
		JPanel pnMaDL = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMaDDL = new JLabel("Mã điểm du lịch");
		lblMaDDL.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaDDL.setForeground(new Color(0, 102, 204));
		pnMaDL.add(lblMaDDL);
		panelAdd.add(pnMaDL);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtMaDiemDL = new JTextField(20));
		txtMaDiemDL.setEditable(false);
		
		JPanel pnDDen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDiemDen = new JLabel("Điểm đến");
		lblDiemDen.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiemDen.setForeground(new Color(0, 102, 204));
		pnDDen.add(lblDiemDen);
		panelAdd.add(pnDDen);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtDiemDL = new JTextField(20));
		
		pnButtonTop = new JPanel(new FlowLayout());
		pnButtonTop.add(btnThem=new JButton("Thêm"));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		pnButtonTop.add(btnSua=new JButton("Sửa"));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		pnButtonTop.add(btnXoa=new JButton("Xóa"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		imgReset = new ImageIcon("img/reset.png");
		pnButtonTop.add(btnReset=new JButton(imgReset));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 144, 255));
		btnReset.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		panelAdd.add(pnButtonTop);
		
//		//form ds tour và chi tiết dia diem
		String cols2[] = {"Mã điểm du lịch", "Điểm đến"};
		modelDD = new DefaultTableModel(cols2, 0);
		tblDiaDiem = new JTable(modelDD);
		tblDiaDiem.setFont(new Font("Arial", Font.PLAIN, 14));
		tblDiaDiem.getTableHeader().setBackground(new Color(0, 0, 204));
		tblDiaDiem.getTableHeader().setForeground(Color.WHITE);
		tblDiaDiem.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tblDiaDiem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDiaDiem.getColumnModel().getColumn(0).setPreferredWidth(300);
		tblDiaDiem.getColumnModel().getColumn(1).setPreferredWidth(600);
		tblDiaDiem.setSize(MAXIMIZED_HORIZ, 150);
		rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		tblDiaDiem.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		tblScroll = new JScrollPane(tblDiaDiem,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tblScroll.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 100));
		panelThongTin.add(tblScroll);
		panelThongTin.add(Box.createVerticalStrut(100));
		
		
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
		pnButtonTop.add(btnThem=new JButton("Thêm"));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		pnButtonTop.add(btnSua=new JButton("Sửa"));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		pnButtonTop.add(btnXoa=new JButton("Xóa"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		imgReset = new ImageIcon("img/reset.png");
		pnButtonTop.add(btnReset=new JButton(imgReset));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(30, 144, 255));
		btnReset.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		panelAdd.add(pnButtonTop);
		
		String cols3[] = {"Mã phương tiện", "Tên phương tiện"};
		modelDD = new DefaultTableModel(cols3, 0);
		tblDiaDiem = new JTable(modelDD);
		tblDiaDiem.setFont(new Font("Arial", Font.PLAIN, 14));
		tblDiaDiem.getTableHeader().setBackground(new Color(0, 0, 204));
		tblDiaDiem.getTableHeader().setForeground(Color.WHITE);
		tblDiaDiem.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tblDiaDiem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDiaDiem.getColumnModel().getColumn(0).setPreferredWidth(300);
		tblDiaDiem.getColumnModel().getColumn(1).setPreferredWidth(600);
		tblDiaDiem.setSize(MAXIMIZED_HORIZ, 150);
		rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		tblDiaDiem.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		tblScroll = new JScrollPane(tblDiaDiem,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tblScroll.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 100));
		panelThongTin.add(tblScroll);
		panelThongTin.add(Box.createVerticalStrut(35));
		
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDiaDiem.addActionListener(this);
		btnNhanVien.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new DiaDiem_GUI().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnTrangChu) {
			setVisible(false);
			new Home_GUI().setVisible(true);
		}else if(o==btnDiaDiem) {
			setVisible(false);
			new DiaDiem_GUI().setVisible(true);
		}else if(o==btnNhanVien){
			
		}else if(o==btnTour) {
			setVisible(false);
			new QuanLiTour_GUI().setVisible(true);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
