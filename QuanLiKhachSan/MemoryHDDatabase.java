package QuanLiKhachSan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class MemoryHDDatabase {
    private static HashMap<Integer, HoaDon> db = new HashMap<Integer, HoaDon>();
    static {
        // dữ liệu mẫu 
        db.put(1, new HDGio(1, LocalDate.of(2025,10,1), "Lê Văn T", "P101", 50000, 5));
        db.put(2, new HDNgay(2, LocalDate.of(2025,10,2), "Nguyễn Thị A", "P202", 300000, 10));
    }

    public static void put(HoaDon _hd) { db.put(_hd.getMaHD(), _hd); }

    public static ArrayList<HoaDon> getAll() { return new ArrayList<HoaDon>(db.values()); }

    public static HoaDon getById(int _ma) { return db.get(_ma); }

    // true nếu không trùng (maHD chưa tồn tại)
    public static boolean checkMaHD(int _ma) { return db.get(_ma) == null; }
}
