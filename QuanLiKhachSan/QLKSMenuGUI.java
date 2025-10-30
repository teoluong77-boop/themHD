package QuanLiKhachSan;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 * Menu chính giống bài của thầy: Chức năng -> Thêm Hóa Đơn / In DS / Thoát
 */
public class QLKSMenuGUI extends JFrame {
    public QLKSMenuGUI() {
        setTitle("Quản lý hóa đơn");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu chucNang = new JMenu("Chức năng");

        JMenuItem themItem = new JMenuItem("Thêm Hóa Đơn");
        JMenuItem inItem = new JMenuItem("In danh sách HĐ");
        JMenuItem thoatItem = new JMenuItem("Thoát");

        themItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    new QuanLiKhachSan.themHoaDon.FormThemHDGUI();
                } catch (NoClassDefFoundError ex) {
                
                    JOptionPane.showMessageDialog(null, "FormThemHDGUI chưa có (chưa paste file themHoaDon).");
                }
            }
        });

        inItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    new QuanLiKhachSan.inHoaDon.TableDSHDGUI();
                } catch (NoClassDefFoundError ex) {
                    JOptionPane.showMessageDialog(null, "TableDSHDGUI chưa có (chưa paste file InHoaDon).");
                }
            }
        });

        thoatItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { System.exit(0); }
        });

        chucNang.add(themItem);
        chucNang.add(inItem);
        chucNang.addSeparator();
        chucNang.add(thoatItem);

        menuBar.add(chucNang);
        menuBar.add(new JMenu("Tùy chọn"));
        menuBar.add(new JMenu("Hỗ trợ"));

        setJMenuBar(menuBar);

        JLabel footer = new JLabel("Nhóm 2", SwingConstants.CENTER);
        add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }
}
