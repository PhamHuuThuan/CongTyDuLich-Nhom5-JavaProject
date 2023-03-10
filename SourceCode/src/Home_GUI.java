import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

public class Home_GUI extends JFrame implements ActionListener{
	JButton btnPfl, btnHome, btnSearch, btnGiamGia, btnBooked, btnPay, btnSearchNow;
	JTextField txtDiemDen;
	JPanel panelWest, panelCenter;
	JLabel lblLogo;
	JPanel panelHot;
	JLabel lblTitleHot;
	JPanel panelContainer;
	public Home_GUI() {
		setTitle("Travel Company");
		setSize(1200, 630);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createGUI();
	}
	public void createGUI() {
		panelWest = new JPanel();
		panelWest.setLayout(new FlowLayout());
		ImageIcon iconLogo = new ImageIcon("img/logovietnamtravel.png");
		lblLogo = new JLabel("");
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
		btnPfl.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.LIGHT_GRAY));
		
		ImageIcon iconHome = new ImageIcon("img/home.png");
		panelControl.add(btnHome = new JButton("HOME", iconHome));
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(new Color(240, 255, 240));
		btnHome.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnHome.setBackground(new Color(102, 255, 153));
		btnHome.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(204, 51, 255)));
		
		ImageIcon iconSearch = new ImageIcon("img/search.png");
		panelControl.add(btnSearch = new JButton("SEARCH TOUR", iconSearch));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setForeground(new Color(240, 255, 240));
		btnSearch.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnSearch.setBackground(new Color(153, 204, 255));
		btnSearch.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		
		ImageIcon iconKM = new ImageIcon("img/coupon.png");
		panelControl.add(btnGiamGia = new JButton("DISCOUNT", iconKM));
		btnGiamGia.setHorizontalAlignment(SwingConstants.LEFT);
		btnGiamGia.setForeground(new Color(240, 255, 240));
		btnGiamGia.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnGiamGia.setBackground(new Color(153, 204, 255));
		btnGiamGia.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		
		ImageIcon iconBooking = new ImageIcon("img/weekly.png");
		panelControl.add(btnBooked = new JButton("BOOKED", iconBooking));
		btnBooked.setHorizontalAlignment(SwingConstants.LEFT);
		btnBooked.setForeground(new Color(240, 255, 240));
		btnBooked.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnBooked.setBackground(new Color(153, 204, 255));
		btnBooked.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		
		ImageIcon iconPayment = new ImageIcon("img/credit-card.png");
		panelControl.add(btnPay = new JButton("PAYMENT", iconPayment));
		btnPay.setHorizontalAlignment(SwingConstants.LEFT);
		btnPay.setForeground(new Color(240, 255, 240));
		btnPay.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnPay.setBackground(new Color(153, 204, 255));
		btnPay.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.LIGHT_GRAY));
		
		ImageIcon iconHelp = new ImageIcon("img/help.png");
		JLabel lblLH = new JLabel("HELP & CSKH");
		lblLH.setIcon(iconHelp);
		lblLH.setForeground(new Color(240, 255, 240));
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
		JLabel lblTitle = new JLabel("C??NG NG?????I TH????NG ??I ?????N MU??N N??I <3");
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTitle.setForeground(new Color(255, 20, 147));
		panelTitle.setBackground(new Color(173, 255, 47));
		panelTitle.add(lblTitle);
		panelCenter.add(panelTitle);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSearch = new JLabel("> T??m ki???m tour");
		lblSearch.setForeground(SystemColor.controlDkShadow);
		lblSearch.setFont(new Font("Arial", Font.PLAIN, 20));
		panelSearch.add(lblSearch);
		panelCenter.add(panelSearch);
		
		Box b = Box.createHorizontalBox();
		JLabel lblDiemDen = new JLabel("??i???m ?????n:");
		lblDiemDen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.add(lblDiemDen);
		b.add(Box.createHorizontalStrut(5));
		txtDiemDen = new JTextField();
		txtDiemDen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.add(txtDiemDen);
		b.add(Box.createHorizontalStrut(10));
		JLabel lblNgayDi = new JLabel("Ng??y:");
		lblNgayDi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.add(lblNgayDi);
		b.add(Box.createHorizontalStrut(5));
		JDateChooser dateChooser = new JDateChooser();
		b.add(dateChooser);
		b.add(Box.createHorizontalStrut(40));
		
		ImageIcon iconSearch = new ImageIcon("img/search.png");
		btnSearchNow = new JButton("T??m ki???m", iconSearch);
		btnSearchNow.setBackground(new Color(244, 164, 96));
		btnSearchNow.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSearchNow.setForeground(Color.WHITE);
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
		
		panelContainer = new JPanel();
		panelContainer.setLayout(new GridLayout(3, 4, 25, 15));
		panelContainer.setBackground(Color.WHITE);
		JScrollPane pnscroll = new JScrollPane(panelContainer, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		for(int i=0; i<12;i++) {
			panelHot = createTourPanel("Tour " + i);
			panelHot.setLayout(new BoxLayout(panelHot, BoxLayout.Y_AXIS));
			panelHot.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
			ImageIcon iconIMG = new ImageIcon("img/phuquoc.jpg");
			JLabel lblImage = new JLabel(iconIMG);
			lblTitleHot = new JLabel("Ph?? Qu???c 3ng??y - 2????m          Gi??: 2.000.000??");
			lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
			JLabel lblPrice = new JLabel("Time: 30/04/2023                       Xu???t ph??t: TP HCM");
			lblPrice.setFont(new Font("Arial", Font.PLAIN, 12));
			panelHot.add(lblImage);
			panelHot.add(lblTitleHot);
			panelHot.add(lblPrice);
			panelContainer.add(panelHot);
		}
		
		panelCenter.add(Box.createVerticalStrut(10));
		panelCenter.add(pnscroll);
	}
	private JPanel createTourPanel(String tourID) {
        JPanel panel = new JPanel();
        panel.addMouseListener(new TourMouseListener(tourID, panel));
        return panel;
    } 
    private class TourMouseListener extends MouseAdapter{
        private String tourID;
        private JPanel panel;
        public TourMouseListener(String tourID, JPanel panel) {
            this.tourID = tourID;
            this.panel = panel;
        }
        public void mouseClicked(MouseEvent e) {
           txtDiemDen.setText(tourID);
        }
        //di chuyen chuot qua hien border
        public void mouseEntered(MouseEvent e) {
        	panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.GREEN));
        }
        //thoat chuot tat border
        public void mouseExited(MouseEvent e) {
        	panel.setBorder(null);
        }
    }
	public static void main(String[] args) {
		new Home_GUI().setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btnSearch) {
	
		}if(obj==btnSearchNow) {
			
		}
		
	}
}
