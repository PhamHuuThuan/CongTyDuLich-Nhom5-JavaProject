package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import BUS.HoaDon_Bus;
import Entity.NhanVien;
import Entity.TourDuLich;

public class ThongKe_GUI extends JFrame implements MouseListener,ActionListener{
	private JButton btnTrangChu, btnTour, btnDiaDiem, btnThongKe, btnNhanVien;
	private NhanVien nv;
	private HoaDon_Bus hd_bus;
	private JComboBox<Integer> comboBox;
	private DefaultCategoryDataset dataset;
	
	public ThongKe_GUI(NhanVien nv) {
		setTitle("Vietour - Phần mềm quản lí tour du lịch");
		setSize(1200, 850);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/travel.png"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.nv = nv;
		hd_bus = new HoaDon_Bus();
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
		btnDiaDiem.setBackground(new Color(60, 179, 113));
		btnDiaDiem.setForeground(new Color(255, 255, 255));
		btnDiaDiem.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgKH = new ImageIcon("img/trend.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnThongKe = new JButton("Thống Kê", imgKH));
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btnThongKe.setBackground(Color.WHITE);
		btnThongKe.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnThongKe.setBackground(new Color(255, 165, 0));
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setPreferredSize(btnThongKe.getPreferredSize());
		
		panelHead.add(Box.createHorizontalStrut(20));
		ImageIcon imgUser = new ImageIcon("img/user.png");
		panelHead.add(btnNhanVien = new JButton(": "+nv.getTenNV(), imgUser));
		btnNhanVien.setBackground(new Color(250,  128, 144));
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 12));

		
		JPanel chartPanel = new JPanel();
        comboBox = new JComboBox<>();
        comboBox.setPreferredSize(new Dimension(100, 30));
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int year = 2022; year <= currentYear; year++) {
        	comboBox.addItem(year);
        }
        chartPanel.add(comboBox);
        
		chartPanel.setBorder(BorderFactory.createTitledBorder("Thống kê doanh thu các tháng trong năm"));
		chartPanel.setBackground(Color.WHITE);
		chartPanel.setPreferredSize(new Dimension(800, 500));
		add(chartPanel, BorderLayout.CENTER);

		
		// Create dataset
		dataset = new DefaultCategoryDataset();

		// create chart
		JFreeChart chart = ChartFactory.createBarChart(
		    "Doanh thu các tháng trong năm",  
		    null,           
		    "Doanh thu (VNĐ)",  
		    dataset,       
		    PlotOrientation.VERTICAL, 
		    false,          
		    true,         
		    false           
		);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		ValueAxis rangeAxis = plot.getRangeAxis();
		DecimalFormat decimalFormat = new DecimalFormat("0,000");
		((NumberAxis) rangeAxis).setNumberFormatOverride(decimalFormat);
		ChartPanel chartp = new ChartPanel(chart);
		chartPanel.add(chartp);
	
        JPanel panelEast = new JPanel();
        panelEast.setPreferredSize(new Dimension(450, 400));
		panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.X_AXIS));
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border lineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
		CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(lineBorder, emptyBorder);
		panelEast.setBorder(compoundBorder);
		add(panelEast, BorderLayout.EAST);
		
		//thong tin tour
		JPanel panelThongTin = new JPanel();
		panelThongTin.setLayout(new BoxLayout(panelThongTin, BoxLayout.Y_AXIS));
		panelThongTin.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		panelEast.add(panelThongTin);
		
		JPanel panelTitle = new JPanel();
		JLabel lblTop1Tour = new JLabel("TOP 1 TOUR BÁN CHẠY");
		lblTop1Tour.setFont(new Font("Arial", Font.BOLD, 22));
		lblTop1Tour.setForeground(new Color(0, 0, 255));
		panelTitle.add(lblTop1Tour);
		panelThongTin.add(panelTitle);
		
		TourDuLich tour = new TourDuLich();
		
		JPanel pnMa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMaTour = new JLabel("Mã Tour: " + hd_bus.tourMax().getMaTour());
		lblMaTour.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaTour.setForeground(new Color(0, 0, 255));
		pnMa.add(lblMaTour);
		panelThongTin.add(pnMa);
		
		JPanel pnTen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTenTour = new JLabel("["+hd_bus.tourMax().getMaTour()+"] "+ hd_bus.tourMax().getTenTour());
		lblTenTour.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenTour.setForeground(new Color(0, 0, 255));
		pnTen.add(lblTenTour);
		panelThongTin.add(pnTen);
				
		ImageIcon headImg = new ImageIcon(hd_bus.tourMax().getDsAnh().get(0));
		Image headImage = headImg.getImage();
		Image scaledImage= headImage.getScaledInstance(350, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon= new ImageIcon(scaledImage);
		JLabel lblHinh = new JLabel(scaledIcon);
		lblHinh.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelThongTin.add(lblHinh);
		
		JPanel pnMoTa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextArea lblMoTa = new JTextArea(hd_bus.tourMax().getMoTa());
		lblMoTa.setFont(new Font("Arial", Font.BOLD, 14));
		lblMoTa.setForeground(new Color(0, 0, 255));
		lblMoTa.setLineWrap(true);
		lblMoTa.setWrapStyleWord(true);
		pnMoTa.add(lblMoTa);
		lblMoTa.setPreferredSize(new Dimension(400, 80));
		panelThongTin.add(pnMoTa);
		
		JPanel pnGia = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGia  = new JLabel("Giá: " + hd_bus.tourMax().getGia());
		lblGia.setFont(new Font("Arial", Font.BOLD, 14));
		lblGia.setForeground(new Color(0, 0, 255));
		pnGia.add(lblGia);
		panelThongTin.add(pnGia);
		
		
		// Đia điểm nổi tiếng
		JPanel panelSouth = new JPanel(new BorderLayout());
		panelSouth.add(Box.createVerticalStrut(20));
		
		JPanel contentPanel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("MỘT SỐ ĐỊA ĐIỂM NỔI TIẾNG");
		label.setFont(new Font("Arial", Font.BOLD, 16));
		label.setHorizontalAlignment(JLabel.CENTER);
		contentPanel.add(label, BorderLayout.NORTH);
		contentPanel.add(Box.createVerticalStrut(30));
				
		JPanel imagePanel = new JPanel(new GridLayout(1, 3, 10, 10));
		
		ImageIcon image1 = new ImageIcon("Img/T001/phuquoc1.jpg");
		JLabel label1 = new JLabel(image1);
		image1.setImage(image1.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH));
		imagePanel.add(label1);

		ImageIcon image2 = new ImageIcon("Img/T002/sapa1.jpg");
		JLabel label2 = new JLabel(image2);
		image2.setImage(image2.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH));
		imagePanel.add(label2);

		ImageIcon image3 = new ImageIcon("Img/T003/dalat1.jpg");
		JLabel label3 = new JLabel(image3);
		image3.setImage(image3.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH));
		imagePanel.add(label3);

		contentPanel.add(imagePanel, BorderLayout.CENTER);
		panelSouth.add(contentPanel, BorderLayout.SOUTH);
		add(panelSouth,BorderLayout.SOUTH);

		
		
		btnTrangChu.addActionListener(this);
		btnTour.addActionListener(this);
		btnDiaDiem.addActionListener(this);
		btnNhanVien.addActionListener(this);
		comboBox.addActionListener(this);
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
		}else if(o==comboBox) {
			int nam = (int) comboBox.getSelectedItem();
			tinhDoanhThu(nam);
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
	public void tinhDoanhThu(int nam) {
		for (int i = 1; i <= 12; i++) {
    	    String month = "T" + i;
    	    dataset.setValue(hd_bus.thanhTienByMonth(i, nam), "Doanh thu", month);
    	    System.out.println(hd_bus.thanhTienByMonth(i, nam));
    	}
	}
}
