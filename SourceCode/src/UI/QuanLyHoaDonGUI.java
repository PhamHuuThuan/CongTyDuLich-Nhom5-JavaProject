package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuanLyHoaDonGUI extends JFrame {
    private JList<String> orderList;
    private DefaultListModel<String> orderListModel;
    private JButton viewButton;
    private JButton deleteButton;
    private JButton resetButton;

    public QuanLyHoaDonGUI() {
        setTitle("Quản Lý Đơn Hàng");
        setLayout(null);

        // Tạo danh sách đơn hàng
        setTitle("Quản Lý Đơn Hàng");
        orderListModel = new DefaultListModel<>();
        orderListModel.addElement("Mỹ Tho - Cần Thơ");
        orderListModel.addElement("Đà Lạt");
        orderListModel.addElement("Nha Trang");
        orderListModel.addElement("Vũng Tàu");

        orderList = new JList<>(orderListModel);
        orderList.setBounds(20, 20, 200, 150); // Mở rộng kích thước giao diện danh sách đơn hàng
        add(orderList);

        // Tạo nút Xem chi tiết đơn hàng
        viewButton = new JButton("Xem chi tiết đơn hàng");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOrder = orderList.getSelectedValue();
                if (selectedOrder != null) {
                    // Hiển thị thông tin chi tiết của đơn hàng
                    String orderInfo = "Đơn hàng: " + selectedOrder + "\n";
                    if (selectedOrder.equals("Mỹ Tho - Cần Thơ")) {
                        orderInfo += "Địa điểm kết thúc: Mỹ Tho - Cần Thơ\n";
                        orderInfo += "Số ngày: 2 ngày 1 đêm\n";
                        orderInfo += "Địa điểm bắt đầu: TP.HCM\n";
                        orderInfo += "Giá vé: 2.049.490 đ\n";
                    } else if (selectedOrder.equals("Đà Lạt")) {
                        orderInfo += "Địa điểm kết thúc: Đà Lạt\n";
                        orderInfo += "Số ngày: 4 ngày 3 đêm\n";
                        orderInfo += "Địa điểm bắt đầu: TP.HCM\n";
                        orderInfo += "Giá vé: 5.049.490 đ\n";
                    } else if (selectedOrder.equals("Nha Trang")) {
                        orderInfo += "Địa điểm kết thúc: Nha Trang\n";
                        orderInfo += "Số ngày: 3 ngày 3 đêm\n";
                        orderInfo += "Địa điểm bắt đầu: TP.HCM\n";
                        orderInfo += "Giá vé: 5.049.490 đ\n";
                    } else if (selectedOrder.equals("Vũng Tàu")) {
                        orderInfo += "Địa điểm kết thúc: Vũng Tàu\n";
                        orderInfo += "Số ngày: 1 ngày 1 đêm\n";
                        orderInfo += "Địa điểm bắt đầu: TP.HCM\\n";
                        orderInfo += "Giá vé: 1.049.490 đ\n";
                    }

                    JOptionPane.showMessageDialog(QuanLyHoaDonGUI.this, orderInfo, "Thông tin chi tiết đơn hàng", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(QuanLyHoaDonGUI.this, "Vui lòng chọn đơn hàng để xem chi tiết", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        viewButton.setBounds(240, 20, 200, 30); // Mở rộng kích thước giao diện nút Xem chi tiết đơn hàng
        add(viewButton);

        // Tạo nút Xóa đơn hàng
        deleteButton = new JButton("Xóa đơn hàng");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = orderList.getSelectedIndex();
                if (selectedIndex != -1) {
                    orderListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(QuanLyHoaDonGUI.this, "Vui lòng chọn đơn hàng để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        deleteButton.setBounds(240, 70, 200, 30); // Mở rộng kích thước giao diện nút Xóa đơn hàng
        add(deleteButton);
     // Tạo label cho danh sách đơn hàng
        JLabel orderListLabel = new JLabel("Danh sách đơn hàng");
        orderListLabel.setBounds(20, 0, 200, 20);
        add(orderListLabel);
        // Tạo nút Đặt lại danh sách đơn hàng
        resetButton = new JButton("Đặt lại danh sách đơn hàng");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderListModel.clear();
                orderListModel.addElement("Mỹ Tho - Cần Thơ");
                orderListModel.addElement("Đà Lạt");
                orderListModel.addElement("Nha Trang");
                orderListModel.addElement("Vũng Tàu");
            }
        });
        resetButton.setBounds(240, 120, 200, 30); // Mở rộng kích thước giao diện nút Đặt lại danh sách đơn hàng
        add(resetButton);

        // Cấu hình giao diện chung
        setSize(500, 250); // Cài đặt kích thước cửa sổ giao diện chính
        setLocationRelativeTo(null); // Căn giữa cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        QuanLyHoaDonGUI quanLyHoaDonGUI = new QuanLyHoaDonGUI();
    }
}
                       




