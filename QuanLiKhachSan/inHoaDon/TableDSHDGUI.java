package QuanLiKhachSan.inHoaDon;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import QuanLiKhachSan.HDGio;
import QuanLiKhachSan.HoaDon;
import QuanLiKhachSan.MemoryHDDatabase;

public class TableDSHDGUI extends JFrame {
    public TableDSHDGUI() {
        setTitle("Danh sách Hóa đơn");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] cols = {"Mã", "Loại", "Tên KH", "Phòng", "Đơn giá", "Thành tiền"};
        ArrayList<HoaDon> ds = MemoryHDDatabase.getAll();
        Object[][] data = new Object[ds.size()][cols.length];

        for (int i = 0; i < ds.size(); i++) {
            HoaDon hd = ds.get(i);
            data[i][0] = hd.getMaHD();
            data[i][1] = (hd instanceof HDGio) ? "Theo giờ" : "Theo ngày";
            data[i][2] = hd.getTenKH();
            data[i][3] = hd.getMaPhong();
            data[i][4] = hd.getDonGia();
            data[i][5] = hd.tinhTien();
        }

        JTable table = new JTable(new DefaultTableModel(data, cols));
        add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);
    }
}

