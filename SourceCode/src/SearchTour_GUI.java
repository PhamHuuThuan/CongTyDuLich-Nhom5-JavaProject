import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class SearchTour_GUI extends JFrame implements ActionListener{
	JButton btnPfl, btnHome, btnSearch, btnGiamGia, btnBooked, btnPay, btnSearchNow;
	JTextField txtDiemDen, txtMaTour;
	JPanel panelWest, panelCenter;
	JLabel lblLogo;
	JPanel panelTour;
	JPanel panelContainer;
	public SearchTour_GUI() {
		setTitle("Travel Company");
		setSize(1300, 800);
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
		btnHome.setBackground(new Color(153, 204, 255));
		btnHome.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		
		ImageIcon iconSearch = new ImageIcon("img/search.png");
		panelControl.add(btnSearch = new JButton("SEARCH TOUR", iconSearch));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setForeground(new Color(240, 255, 240));
		btnSearch.setFont(new Font(".VnArial", Font.BOLD, 20));
		btnSearch.setBackground(new Color(102, 255, 153));
		btnSearch.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(204, 51, 255)));
		
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
		JLabel lblMaTour = new JLabel("M?? Tour:");
		lblMaTour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.add(lblMaTour);
		b.add(Box.createHorizontalStrut(5));
		txtMaTour = new JTextField();
		txtMaTour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.add(txtMaTour);
		b.add(Box.createHorizontalStrut(10));
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
		
		JPanel panelKQ = new JPanel();
		panelKQ.setLayout(new BoxLayout(panelKQ, BoxLayout.X_AXIS));
		panelKQ.setBorder(BorderFactory.createTitledBorder("K???t qu??? t??m ki???m"));
		panelCenter.add(panelKQ);
		
		JPanel panelDS = new JPanel();
		panelDS.setPreferredSize(new Dimension(350, Integer.MAX_VALUE));
		panelDS.setBackground(Color.WHITE);
		panelKQ.add(panelDS);
		
		JPanel panelDetail = new JPanel();
		panelDetail.setLayout(new BoxLayout(panelDetail, BoxLayout.Y_AXIS));
		panelDetail.setBackground(new Color(255, 239, 213));
		JScrollPane scrollKQ = new JScrollPane(panelDetail, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelKQ.add(scrollKQ);
		
		Box b1 = Box.createHorizontalBox();
		JLabel lblTitleSearch = new JLabel("Tour ABCDED");
		JLabel lblTime = new JLabel("Time: 3 ng??y 2 ????m");
		b1.add(lblTitleSearch);
		b1.add(Box.createHorizontalStrut(100));
		b1.add(lblTime);
		
		Box b2 = Box.createHorizontalBox();
		JLabel lblTimeStart = new JLabel("Ng??y kh???i h??nh: 18:00 30/04/2023");
		JLabel lblPlaceStart = new JLabel("?????a ??i???m kh???i h??nh: Ph?????ng 10, Qu???n G?? V???p, TP HCM");
		b2.add(lblTimeStart);
		b2.add(Box.createHorizontalStrut(30));
		b2.add(lblPlaceStart);
		
		JLabel lblMoTa = new JLabel("M?? t???:");
		JTextArea textAreaMoTa = new JTextArea("Chuy???n du l???ch n???a ng??y t??? Hu??? s??? ????a b???n ??i tham quan 2 ng??i l??ng c??? v?? h??a m??nh v??o n???n v??n h??a ?????a ph????ng.\r\n"
				+ "\r\n"
				+ "H?????ng d???n vi??n chuy??n nghi???p s??? ????n b???n t???i kh??ch s???n. T??? ????y, xe s??? ????a b???n ?????n l??ng S??nh hay c??n ???????c g???i l?? l??ng L???i ??n ????? kh??m ph?? ngh??? l??m tranh d??n gian v?? k??? thu???t c???a nh???ng ng?????i th??? th??? c??ng n??i ????y. Sau ????, b???n s??? ???????c t??m hi???u v??? ngh??? thu???t gi???y v?? xem m???t s??? s???n ph???m c?? thi???t k??? ?????c bi???t t???i V?????n Tr??c Ch???, n??i l??m vi???c c???a nhi???u ngh??? nh??n.\r\n"
				+ "\r\n"
				+ "??i???m d???ng ch??n ti???p theo l?? l??ng h????ng Th???y Xu??n. T???i ????y, h?????ng d???n vi??n s??? gi???i th??ch quy tr??nh s???n xu???t h????ng v?? c??c nguy??n li???u th?? ???????c s??? d???ng. Ngo??i ra, b???n s??? ???????c chi??m ng?????ng v?? s??? nh???ng n??n h????ng l??i tre ????? m??u s???c ??ang ???????c ph??i n???ng d???c c??c con ph???. Chuy???n ??i kh??p l???i t???i kh??ch s???n c???a b???n trong th??nh ph???.");
		textAreaMoTa.setLineWrap(true);
		textAreaMoTa.setWrapStyleWord(true);
		textAreaMoTa.setEditable(false);
		textAreaMoTa.setBackground(new Color(255, 218, 185));
		textAreaMoTa.setPreferredSize(new Dimension(500, 200));
		
		JLabel lblImg = new JLabel("H??nh ???nh");
		
		Box b3 = Box.createHorizontalBox();
		ImageIcon iconImg1 = new ImageIcon("img/hinh1.jpg");
		JLabel lblImg1 = new JLabel(iconImg1);
		lblImg1.setPreferredSize(new Dimension(200, 150));
		ImageIcon iconImg2 = new ImageIcon("img/hinh1.jpg");
		JLabel lblImg2 = new JLabel(iconImg2);
		lblImg2.setPreferredSize(new Dimension(200, 150));
		ImageIcon iconImg3 = new ImageIcon("img/hinh1.jpg");
		JLabel lblImg3 = new JLabel(iconImg3);
		lblImg3.setPreferredSize(new Dimension(200, 150));
		b3.add(lblImg1);
		b3.add(lblImg2);
		b3.add(lblImg3);
		
		Box b4 = Box.createHorizontalBox();
		ImageIcon iconImg4 = new ImageIcon("img/hinh1.jpg");
		JLabel lblImg4 = new JLabel(iconImg4);
		lblImg4.setPreferredSize(new Dimension(200, 150));
		ImageIcon iconImg5 = new ImageIcon("img/hinh1.jpg");
		JLabel lblImg5 = new JLabel(iconImg5);
		lblImg5.setPreferredSize(new Dimension(200, 150));
		b4.add(lblImg4);
		b4.add(lblImg5);
		
		JLabel lblSoLuong = new JLabel("S??? l?????ng: 10/20 ng?????i");
		
		JLabel lblDatVe = new JLabel("?????t v?? ngay:");
		
		Box b5 = Box.createHorizontalBox();
		JLabel lblSL = new JLabel("S??? l?????ng ng?????i: ");
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		spinner.setPreferredSize(new Dimension(50, 20));
		JLabel lblXe = new JLabel("Ch???n ph????ng ti???n");
		JRadioButton btnBus, btnMaybay;
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(btnBus = new JRadioButton("Xe kh??ch"));
		btnBus.setBackground(new Color(255, 239, 213));
		btnGroup.add(btnMaybay = new JRadioButton("M??y bay"));
		btnMaybay.setBackground(new Color(255, 239, 213));
		b5.add(Box.createHorizontalStrut(10));
		b5.add(lblSL);
		b5.add(Box.createHorizontalStrut(20));
		b5.add(spinner);
		b5.add(Box.createHorizontalStrut(150));
		b5.add(lblXe);
		b5.add(Box.createHorizontalStrut(20));
		b5.add(btnBus);
		b5.add(btnMaybay);
		b5.add(Box.createHorizontalStrut(50));
		
		Box b6 = Box.createHorizontalBox();
		JButton btnDatVe, btnThem, btnSua, btnXoa, btnLuu;
		b6.add(btnDatVe = new JButton("?????t v??"));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(btnDatVe = new JButton("Th??m"));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(btnDatVe = new JButton("S???a"));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(btnDatVe = new JButton("X??a"));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(btnDatVe = new JButton("L??u"));
		
		panelDetail.add(b1);
		panelDetail.add(b2);
		panelDetail.add(lblMoTa);
		panelDetail.add(textAreaMoTa);
		panelDetail.add(lblImg);
		panelDetail.add(b3);
		panelDetail.add(b4);
		panelDetail.add(lblSoLuong);
		panelDetail.add(lblDatVe);
		panelDetail.add(b5);
		panelDetail.add(b6);
		
	}
	public static void main(String[] args) {
		new SearchTour_GUI().setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
