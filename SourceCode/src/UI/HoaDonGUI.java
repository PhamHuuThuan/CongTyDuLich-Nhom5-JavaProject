	package UI;

	import java.awt.BorderLayout;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.*;

	public class HoaDonGUI {
		    public static void HoaDonGUI() {
		        JFrame frame = new JFrame("Hóa đơn thanh toán");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(400, 400);
		        frame.setLayout(new BorderLayout());

		        // Lấy kích thước màn hình
		        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        int screenWidth = screenSize.width;
		        int screenHeight = screenSize.height;

		        // Đặt vị trí của JFrame để nằm giữa màn hình
		        int frameWidth = frame.getWidth();
		        int frameHeight = frame.getHeight();
		        int x = (screenWidth - frameWidth) / 2;
		        int y = (screenHeight - frameHeight) / 2;
		        frame.setLocation(x, y);

		        // Thêm tiêu đề "HÓA ĐƠN THANH TOÁN"
		        JLabel lblTitle = new JLabel("HÓA ĐƠN THANH TOÁN");
		        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		        frame.add(lblTitle, BorderLayout.NORTH);

		        JPanel panel = new JPanel(new GridBagLayout());
		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.insets = new Insets(5, 5, 5, 5);


	        // Số hóa đơn
	        JLabel lblSoHD = new JLabel("Số hóa đơn:");
	        JTextField txtSoHD = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblSoHD, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtSoHD, gbc);

	        // Tên nhân viên
	        JLabel lblTenNV = new JLabel("Tên nhân viên:");
	        JTextField txtTenNV = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblTenNV, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtTenNV, gbc);

	        // Ngày lập hóa đơn
	        JLabel lblNgayLapHD = new JLabel("Ngày lập hóa đơn:");
	        JTextField txtNgayLapHD = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblNgayLapHD, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtNgayLapHD, gbc);

	        // Tên khách hàng
	        JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
	        JTextField txtTenKhachHang = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblTenKhachHang, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtTenKhachHang, gbc);

	        // Địa điểm
	        JLabel lblDiaDiem = new JLabel("Địa điểm:");
	        JTextField txtDiaDiem = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 4;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblDiaDiem, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 4;
	        gbc.fill =GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtDiaDiem, gbc);
	        // Phương tiện di chuyển
	        JLabel lblPhuongTien = new JLabel("Phương tiện di chuyển:");
	        JTextField txtPhuongTien = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 5;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblPhuongTien, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 5;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtPhuongTien, gbc);

	        // Ngày đi
	        JLabel lblNgayDi = new JLabel("Ngày đi:");
	        JTextField txtNgayDi = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 6;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblNgayDi, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 6;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtNgayDi, gbc);

	        // Ngày kết thúc
	        JLabel lblNgayKetThuc = new JLabel("Ngày kết thúc:");
	        JTextField txtNgayKetThuc = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 7;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblNgayKetThuc, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 7;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtNgayKetThuc, gbc);

	        // Số lượng thành viên
	        JLabel lblSoLuongTV = new JLabel("Số lượng thành viên:");
	        JTextField txtSoLuongTV = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 8;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblSoLuongTV, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 8;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtSoLuongTV, gbc);

	        // Thành tiền
	        JLabel lblThanhTien = new JLabel("Thành tiền:");
	        JTextField txtThanhTien = new JTextField();
	        gbc.gridx = 0;
	        gbc.gridy = 9;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(lblThanhTien, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 9;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.weightx = 1.0;
	        panel.add(txtThanhTien, gbc);

	        // Nút chỉnh sửa
	        JButton btnChinhSua = new JButton("Chỉnh sửa");
	        gbc.gridx = 0;
	        gbc.gridy = 10;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(btnChinhSua, gbc);

	        // Nút thanh toán
	        JButton btnThanhToan = new JButton("Thanh toán");
	        gbc.gridx = 1;
	        gbc.gridy = 10;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.weightx = 0;
	        panel.add(btnThanhToan, gbc);

	        frame.add(panel, BorderLayout.CENTER);

	        frame.setVisible(true);
	    }
	    public static void main(String[] args) {
	    	HoaDonGUI();
	    }
		
	}