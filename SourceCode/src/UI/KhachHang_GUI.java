package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.KhachHang_Bus;
import Entity.KhachHang;

public class KhachHang_GUI extends JFrame implements MouseListener,ActionListener{
	private JButton btnTrangChu, btnTour, btnDonHang, btnKH, btnQuanLi, btnNhanVien,btnSua;
	private JTextField txtMaKH,txtTenKH,txtSdt,txtEmail,txtDiaChi;
	private JTable tblKH;
	private DefaultTableModel modelKH;
	private KhachHang_Bus kh_bus;
	private ArrayList<KhachHang> dsKhachHang;
	
	
	public KhachHang_GUI() {
		setTitle("Vietour - Phan mem quan li tour du lich");
		setSize(1200,750);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/travel.png"));
		setResizable(false);
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
		btnTrangChu.setBackground(new Color(255, 165, 0));
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
		panelHead.add(btnNhanVien = new JButton(": Nguyễn Văn A", imgUser));
		btnNhanVien.setBackground(new Color(250,  128, 144));
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 12));
		
		//Thêm/ sửa/ xóa Khách hàng
		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));
		panelAdd.add(Box.createVerticalStrut(20));
		panelAdd.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		add(panelAdd, BorderLayout.WEST);
		
		JPanel pnMaKH = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMaKH = new JLabel("Mã khách hàng: ");
		lblMaKH.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaKH.setForeground(new Color(0, 102, 204));
		pnMaKH.add(lblMaKH);
		panelAdd.add(pnMaKH);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtMaKH=new JTextField(20));
		panelAdd.add(Box.createVerticalStrut(5));
		txtMaKH.setEditable(false);
		
		JPanel pnSdt = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSdt = new JLabel("Số điện thoại: ");
		lblSdt.setFont(new Font("Arial", Font.BOLD, 14));
		lblSdt.setForeground(new Color(0, 102, 204));
		pnSdt.add(lblSdt);
		panelAdd.add(pnSdt);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtSdt=new JTextField(20));
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnTen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTenKH = new JLabel("Họ và tên: ");
		lblTenKH.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenKH.setForeground(new Color(0, 102, 204));
		pnTen.add(lblTenKH);
		panelAdd.add(pnTen);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtTenKH=new JTextField(20));
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setForeground(new Color(0, 102, 204));
		pnEmail.add(lblEmail);
		panelAdd.add(pnEmail);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtEmail=new JTextField(20));
		panelAdd.add(Box.createVerticalStrut(5));
		
		JPanel pnDiaChi = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiaChi.setForeground(new Color(0, 102, 204));
		pnDiaChi.add(lblDiaChi);
		panelAdd.add(pnDiaChi);
		panelAdd.add(Box.createVerticalStrut(5));
		panelAdd.add(txtDiaChi=new JTextField(20));
		panelAdd.add(Box.createVerticalStrut(5));

		JPanel pnButtonTop = new JPanel(new FlowLayout());
		pnButtonTop.add(Box.createVerticalStrut(50));
		pnButtonTop.add(btnSua=new JButton("Sửa"));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBorder(BorderFactory.createEmptyBorder(7, 20, 7, 20));
		panelAdd.add(pnButtonTop);
		panelAdd.add(Box.createVerticalStrut(200));		
		

		String cols[] = {"Mã KH", "Tên KH", "SĐT", "Email", "Địa Chỉ"};
		modelKH = new DefaultTableModel(cols, 0);
		tblKH = new JTable(modelKH);
		tblKH.setFont(new Font("Arial", Font.PLAIN, 14));
		tblKH.getTableHeader().setBackground(new Color(0, 0, 204));
		tblKH.getTableHeader().setForeground(Color.WHITE);
		tblKH.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tblKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblKH.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblKH.getColumnModel().getColumn(1).setPreferredWidth(240);
		tblKH.getColumnModel().getColumn(2).setPreferredWidth(155);
		tblKH.getColumnModel().getColumn(3).setPreferredWidth(240);
		tblKH.getColumnModel().getColumn(4).setPreferredWidth(220);
		tblKH.setSize(MAXIMIZED_HORIZ, 150);
		tblKH.setRowHeight(25);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		tblKH.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		JScrollPane tblScroll = new JScrollPane(tblKH,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS , JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(tblScroll,BorderLayout.CENTER);
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDonHang.addActionListener(this);
		btnQuanLi.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnSua.addActionListener(this);
		btnKH.addActionListener(this);
		tblKH.addMouseListener(this);
		
		kh_bus = new KhachHang_Bus();
		showDataOnTable();
		
	}
	
	public boolean validData() {
		String tenKH = txtTenKH.getText().trim();
		String sdt = txtSdt.getText().trim();
		String email = txtEmail.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
				
		return true;
	}
	
	public void showDataOnTable() {
	    DefaultTableModel model = (DefaultTableModel) tblKH.getModel();
	    ArrayList<KhachHang> dsKH = kh_bus.getAllKH();
	    for (KhachHang kh : dsKH) {
	        Object[] row = { kh.getMaKH(),kh.getSdt(), kh.getTenKH(), kh.getEmail(), kh.getDiaChi() };
	        model.addRow(row);
	    }
	}
	public void XoaHetTable() {
		DefaultTableModel dm = (DefaultTableModel) tblKH.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	private void suaThongTinKH() {                                          
        KhachHang kh = new KhachHang();
        kh.setMaKH(txtMaKH.getText());
        kh.setTenKH(txtTenKH.getText());
        kh.setSdt(txtSdt.getText());
        kh.setEmail(txtEmail.getText());
        kh.setDiaChi(txtDiaChi.getText());
        
        if (kh_bus.updateKhachHang(kh)) {
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng thành công!");
            XoaHetTable();
            showDataOnTable(); // Tải lại danh sách khách hàng sau khi cập nhật
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng thất bại!");
        }
    }
	
	public static void main(String[] args) {
		new KhachHang_GUI().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnTrangChu) {
			new Home_GUI().setVisible(true);
		}else if(o==btnDonHang) {
			
		}else if(o==btnQuanLi){
			setVisible(false);
			new QuanLiTour_GUI().setVisible(true);
		}else if(o==btnTour) {
			setVisible(false);
			new Tour_GUI().setVisible(true);
		}else if(o==btnNhanVien){
			
		}else if(o==btnKH){
			setVisible(false);
			new KhachHang_GUI().setVisible(true);
		}else if(o==btnSua) {
			suaThongTinKH();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblKH.getSelectedRow();
		txtMaKH.setText(modelKH.getValueAt(row, 0).toString());
		txtTenKH.setText(modelKH.getValueAt(row, 1).toString());
		txtSdt.setText(modelKH.getValueAt(row, 2).toString());
		txtEmail.setText(modelKH.getValueAt(row, 3).toString());
		txtDiaChi.setText(modelKH.getValueAt(row, 4).toString());
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
