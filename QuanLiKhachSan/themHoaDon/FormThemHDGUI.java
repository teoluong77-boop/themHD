package QuanLiKhachSan.themHoaDon;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;

import QuanLiKhachSan.HDGio;
import QuanLiKhachSan.HDNgay;
import QuanLiKhachSan.HoaDon;
import QuanLiKhachSan.MemoryHDDatabase;

public class FormThemHDGUI extends JFrame {
    private JTextField txtMa, txtTenKH, txtMaPhong, txtDonGia, txtSoGio, txtSoNgay;
    private JComboBox<String> cboLoai;
    private JButton btnLuu;

    public FormThemHDGUI() {
        setTitle("Thêm Hóa Đơn");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 5, 5));

        add(new JLabel("Mã hóa đơn:"));
        txtMa = new JTextField();
        add(txtMa);

        add(new JLabel("Tên khách hàng:"));
        txtTenKH = new JTextField();
        add(txtTenKH);

        add(new JLabel("Mã phòng:"));
        txtMaPhong = new JTextField();
        add(txtMaPhong);

        add(new JLabel("Đơn giá:"));
        txtDonGia = new JTextField();
        add(txtDonGia);

        add(new JLabel("Loại hóa đơn:"));
        cboLoai = new JComboBox<>(new String[]{"Theo giờ", "Theo ngày"});
        add(cboLoai);

        add(new JLabel("Số giờ (nếu thuê giờ):"));
        txtSoGio = new JTextField();
        add(txtSoGio);

        add(new JLabel("Số ngày (nếu thuê ngày):"));
        txtSoNgay = new JTextField();
        add(txtSoNgay);

        btnLuu = new JButton("Lưu hóa đơn");
        add(new JLabel(""));
        add(btnLuu);

        btnLuu.addActionListener(new LuuHDListener());
        setVisible(true);
    }

    private class LuuHDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int ma = Integer.parseInt(txtMa.getText());
                String ten = txtTenKH.getText();
                String phong = txtMaPhong.getText();
                double gia = Double.parseDouble(txtDonGia.getText());
                String loai = cboLoai.getSelectedItem().toString();

                if (!MemoryHDDatabase.checkMaHD(ma)) {
                    JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại!");
                    return;
                }

                HoaDon hd = null;
                if (loai.equals("Theo giờ")) {
                    int gio = Integer.parseInt(txtSoGio.getText());
                    hd = new HDGio(ma, LocalDate.now(), ten, phong, gia, gio);
                } else {
                    int ngay = Integer.parseInt(txtSoNgay.getText());
                    hd = new HDNgay(ma, LocalDate.now(), ten, phong, gia, ngay);
                }

                MemoryHDDatabase.put(hd);
                JOptionPane.showMessageDialog(null, "Đã thêm hóa đơn thành công!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu!");
            }
        }
    }
}
