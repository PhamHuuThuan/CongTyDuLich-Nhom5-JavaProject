package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class DatTour_GUI extends JFrame implements ActionListener {
    // Nội dung của class DatTour_GUI


    private JFrame frame;
    private JPanel panel;
    private JLabel lblName, lblEmail, lblPhone, lblAge, lblAddress, lblDeparture, lblDestination, lblQuantity;
    private JTextField txtName, txtEmail, txtPhone, txtAge, txtAddress, txtDeparture, txtDestination;
    private JSpinner spnQuantity;
    private JCheckBox chkOptionalTour, chkInsurance;
    private JButton btnBook;
    private JTextArea txtAreaResult;

    public DatTour_GUI() {
        frame = new JFrame("Đặt tour");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        JPanel pnlNorth = new JPanel();
        JLabel lblTieuDe;
        pnlNorth.add(lblTieuDe = new JLabel("Đặt Tour"));
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        lblTieuDe.setForeground(Color.BLUE);

 
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Đọc hình ảnh từ file
                ImageIcon imageIcon = new ImageIcon("D:\\tải xuống.jpg");
                // Vẽ hình ảnh lên panel
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        // Tên
        lblName = new JLabel("Họ và tên:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblName, gbc);

        txtName = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtName, gbc);

        // Email
        lblEmail = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblEmail, gbc);

        txtEmail = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtEmail, gbc);

        // Số điện thoại
        lblPhone = new JLabel("Số điện thoại:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblPhone, gbc);

        txtPhone = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(txtPhone, gbc);

        // Tuổi
        lblAge = new JLabel("Tuổi:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblAge, gbc);
        txtAge = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(txtAge, gbc);
        // Địa chỉ
        lblAddress = new JLabel("Địa chỉ:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblAddress, gbc);

        txtAddress = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(txtAddress, gbc);

        // Điểm khởi hành
        lblDeparture = new JLabel("Điểm khởi hành:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lblDeparture, gbc);

        txtDeparture = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(txtDeparture, gbc);

        // Điểm đến
        lblDestination = new JLabel("Điểm đến:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(lblDestination, gbc);

        txtDestination = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(txtDestination, gbc);

        // Số lượng vé
        lblQuantity = new JLabel("Số lượng vé:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(lblQuantity, gbc);

        spnQuantity = new JSpinner();
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(spnQuantity, gbc);

        // Optional tour
        chkOptionalTour = new JCheckBox("Optional tour");
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(chkOptionalTour, gbc);

        // Insurance
        chkInsurance = new JCheckBox("Bảo hiểm");
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(chkInsurance, gbc);

        // Nút đặt tour
        btnBook = new JButton("Đặt tour");
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        panel.add(btnBook, gbc);
        btnBook.addActionListener(this);

        // Kết quả đặt tour
        txtAreaResult = new JTextArea(10, 30);
        txtAreaResult.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaResult);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        mainPanel.add(panel);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBook) {
            String name = txtName.getText().trim();
            String email = txtEmail.getText().trim();
            String phone = txtPhone.getText().trim();
            String age = txtAge.getText().trim();
            String address = txtAddress.getText().trim();
            String departure = txtDeparture.getText().trim();
            String destination = txtDestination.getText().trim();
            int quantity = (int) spnQuantity.getValue();
            boolean optionalTour = chkOptionalTour.isSelected();
            boolean insurance = chkInsurance.isSelected();

            // Kiểm tra dữ liệu nhập vào
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || age.isEmpty() || address.isEmpty()
                    || departure.isEmpty() || destination.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!isValidEmail(email)) {
            	JOptionPane.showMessageDialog(this, "Email không hợp lệ", "Lỗi",
            			JOptionPane.ERROR_MESSAGE);
            			} else if (!isValidPhoneNumber(phone)) {
            			JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ", "Lỗi",
            			JOptionPane.ERROR_MESSAGE);
            			} else {
            			// Xử lý đặt tour
            			String result = "Đã đặt tour thành công!\n";
            			result += "Họ tên: " + name + "\n";
            			result += "Email: " + email + "\n";
            			result += "Số điện thoại: " + phone + "\n";
            			result += "Tuổi: " + age + "\n";
            			result += "Địa chỉ: " + address + "\n";
            			result += "Điểm khởi hành: " + departure + "\n";
            			result += "Điểm đến: " + destination + "\n";
            			result += "Số lượng vé: " + quantity + "\n";
            			result += "Optional tour: " + (optionalTour ? "Có" : "Không") + "\n";
            			result += "Bảo hiểm: " + (insurance ? "Có" : "Không") + "\n";
            			txtAreaResult.setText(result);
            			}
            			}
            			}
 // Phương thức kiểm tra tính hợp lệ của địa chỉ email
    private boolean isValidEmail(String email) {
        // Kiểm tra bằng regular expression
        String regex = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{2,})$";
        return email.matches(regex);
    }

    // Phương thức kiểm tra tính hợp lệ của số điện thoại
    private boolean isValidPhoneNumber(String phone) {
        // Kiểm tra bằng regular expression
        String regex = "^\\d{10}$";
        return phone.matches(regex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DatTour_GUI();
            }
        });
    }


}