import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdminHome_GUI extends JFrame{
	JButton btnPfl, btnHome, btnSearch, btnGiamGia, btnBooked, btnPay, btnMagament, btnRevenue;
	JPanel panelWest;
	JLabel lblLogo;
	public AdminHome_GUI() {
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
		
		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(Color.WHITE);
	}
	public void addControl() {
		JPanel panelControl = new JPanel(new GridLayout(12, 1));
		panelControl.setPreferredSize(new Dimension(215, 600));
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
		
		ImageIcon iconMgm = new ImageIcon("img/execute.png");
		panelControl.add(btnMagament = new JButton("ADD TOURS", iconMgm));
		btnMagament.setHorizontalAlignment(SwingConstants.LEFT);
		btnMagament.setForeground(new Color(240, 255, 240));
		btnMagament.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnMagament.setBackground(new Color(153, 204, 255));
		btnMagament.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		
		ImageIcon iconRevenue = new ImageIcon("img/revenue.png");
		panelControl.add(btnRevenue = new JButton("DOANH THU", iconRevenue));
		btnRevenue.setHorizontalAlignment(SwingConstants.LEFT);
		btnRevenue.setForeground(new Color(240, 255, 240));
		btnRevenue.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnRevenue.setBackground(new Color(153, 204, 255));
		btnRevenue.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		
		ImageIcon iconHelp = new ImageIcon("img/help.png");
		JLabel lblLH = new JLabel("SYSTEM ADMINISTRANTOR");
		lblLH.setIcon(iconHelp);
		lblLH.setFont(new Font(".VnArial", Font.BOLD, 10));
		panelControl.add(lblLH);
		
		JLabel lblSDT = new JLabel("Contact: 0356009859");
		lblSDT.setFont(new Font(".VnArial", Font.BOLD, 15));
		lblSDT.setHorizontalAlignment(SwingConstants.CENTER);
		panelControl.add(lblSDT);
		
		panelWest.add(panelControl);
	}
	public static void main(String[] args) {
		new AdminHome_GUI().setVisible(true);
	}
}
