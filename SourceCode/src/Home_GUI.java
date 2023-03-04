import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class Home_GUI extends JFrame{
	JButton btnPfl, btnHome, btnSearch, btnGiamGia, btnBooked, btnPay, btnSearchNow;
	JTextField txtDiaDiem;
	JPanel panelWest, panelCenter;
	JLabel lblLogo;
	public Home_GUI() {
		setTitle("Travel Company");
		setSize(1200, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createGUI();
	}
	public void createGUI() {
		panelWest = new JPanel();
		panelWest.setLayout(new FlowLayout());
		ImageIcon iconLogo = new ImageIcon("img/logo.png");
		lblLogo = new JLabel();
		lblLogo.setIcon(iconLogo);
		panelWest.add(lblLogo);
		panelWest.setBackground(new Color(153, 204, 255));
		panelWest.setPreferredSize(lblLogo.getPreferredSize());
		addControl();
		add(panelWest, BorderLayout.WEST);
		
		
		panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(Color.WHITE);
		addContainer();
	}
	public void addControl() {
		JPanel panelControl = new JPanel(new GridLayout(12, 1));
		panelControl.setPreferredSize(new Dimension(215, 600));
		panelControl.setBackground(new Color(153, 204, 255));
		ImageIcon iconUser = new ImageIcon("img/user.png");
		panelControl.add(btnPfl = new JButton("PROFILE", iconUser));
		btnPfl.setHorizontalAlignment(SwingConstants.LEFT);
		btnPfl.setForeground(new Color(240, 255, 240));
		btnPfl.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnPfl.setBackground(new Color(153, 204, 255));
		btnPfl.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		
		ImageIcon iconHome = new ImageIcon("img/home.png");
		panelControl.add(btnHome = new JButton("HOME", iconHome));
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(new Color(240, 255, 240));
		btnHome.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnHome.setBackground(new Color(153, 204, 255));
		btnHome.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		
		ImageIcon iconSearch = new ImageIcon("img/search.png");
		panelControl.add(btnSearch = new JButton("SEARCH TOUR", iconSearch));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setForeground(new Color(240, 255, 240));
		btnSearch.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnSearch.setBackground(new Color(153, 204, 255));
		btnSearch.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		
		ImageIcon iconKM = new ImageIcon("img/coupon.png");
		panelControl.add(btnGiamGia = new JButton("DISCOUNT", iconKM));
		btnGiamGia.setHorizontalAlignment(SwingConstants.LEFT);
		btnGiamGia.setForeground(new Color(240, 255, 240));
		btnGiamGia.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnGiamGia.setBackground(new Color(153, 204, 255));
		btnGiamGia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		
		ImageIcon iconBooking = new ImageIcon("img/weekly.png");
		panelControl.add(btnBooked = new JButton("BOOKED", iconBooking));
		btnBooked.setHorizontalAlignment(SwingConstants.LEFT);
		btnBooked.setForeground(new Color(240, 255, 240));
		btnBooked.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnBooked.setBackground(new Color(153, 204, 255));
		btnBooked.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		
		ImageIcon iconPayment = new ImageIcon("img/credit-card.png");
		panelControl.add(btnPay = new JButton("PAYMENT", iconPayment));
		btnPay.setHorizontalAlignment(SwingConstants.LEFT);
		btnPay.setForeground(new Color(240, 255, 240));
		btnPay.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnPay.setBackground(new Color(153, 204, 255));
		btnPay.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		
		ImageIcon iconHelp = new ImageIcon("img/help.png");
		JLabel lblLH = new JLabel("HELP & CSKH");
		lblLH.setIcon(iconHelp);
		lblLH.setFont(new Font(".VnArial", Font.BOLD, 15));
		panelControl.add(lblLH);
		
		JLabel lblSDT = new JLabel("Phone: 0356009859");
		lblSDT.setFont(new Font(".VnArial", Font.BOLD, 15));
		lblSDT.setHorizontalAlignment(SwingConstants.CENTER);
		panelControl.add(lblSDT);
		
		JLabel lblMail = new JLabel("Mail: travel@gmail.com");
		lblMail.setFont(new Font(".VnArial", Font.BOLD, 15));
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		panelControl.add(lblMail);
		
		panelWest.add(panelControl);
	}
	public void addContainer() {
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.WHITE);
		JLabel lblTitle = new JLabel("ĐIỂM ĐẾN THÚ VỊ VUI CHƠI THỎA THÍCH");
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setFont(new Font("Georgia", Font.BOLD, 30));
		lblTitle.setPreferredSize(new Dimension(750, 80));
		panelTitle.add(lblTitle);
		panelCenter.add(panelTitle);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSearch = new JLabel("> Tim kiem chuyen di");
		lblSearch.setForeground(SystemColor.controlDkShadow);
		lblSearch.setFont(new Font("Georgia", Font.PLAIN, 20));
		panelSearch.add(lblSearch);
		panelCenter.add(panelSearch);
		
		Box b = Box.createHorizontalBox();
		JLabel lblDiaDiem = new JLabel("Chọn Địa Điểm:");
		lblDiaDiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.add(lblDiaDiem);
		b.add(Box.createHorizontalStrut(5));
		txtDiaDiem = new JTextField();
		txtDiaDiem.setColumns(10);
		txtDiaDiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.add(txtDiaDiem);
		b.add(Box.createHorizontalStrut(10));
		JLabel lblNgayDi = new JLabel("Ngày khởi hành:");
		lblNgayDi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.add(lblNgayDi);
		b.add(Box.createHorizontalStrut(5));
		JDateChooser dateChooser = new JDateChooser();
		b.add(dateChooser);
		b.add(Box.createHorizontalStrut(40));
		
		ImageIcon iconSearch = new ImageIcon("img/search.png");
		btnSearchNow = new JButton("Search", iconSearch);
		btnSearchNow.setBackground(Color.CYAN);
		btnSearchNow.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.add(btnSearchNow);
		b.add(Box.createHorizontalStrut(40));
		panelCenter.add(b);
		
		JPanel panelTourHot = new JPanel();
		panelTourHot.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTourHot = new JLabel("> Tour Hot");
		lblTourHot.setForeground(SystemColor.controlDkShadow);
		lblTourHot.setFont(new Font("Georgia", Font.PLAIN, 20));
		panelTourHot.add(lblTourHot);
		panelCenter.add(panelTourHot);
		
		JPanel panelContainer = new JPanel();
		panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.X_AXIS));
		for(int i=0; i<6; i++) {
			JPanel panel = new JPanel(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
			
		}
	}
	public static void main(String[] args) {
		new Home_GUI().setVisible(true);
	}
}
