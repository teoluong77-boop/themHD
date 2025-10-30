package QuanLiKhachSan.themHoaDon;

import QuanLiKhachSan.HoaDon;
import QuanLiKhachSan.MemoryHDDatabase;

public class MemoryThemHDDAO implements ThemHDDAO {
	public void insert(HoaDon _hd) {
		MemoryHDDatabase.put(_hd);
	}

	public boolean checkMaHD(int _ma) {
		return MemoryHDDatabase.checkMaHD(_ma);
	}
}
