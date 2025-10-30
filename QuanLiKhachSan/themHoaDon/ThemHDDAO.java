package QuanLiKhachSan.themHoaDon;

import QuanLiKhachSan.HoaDon;

public interface ThemHDDAO {
	void insert(HoaDon _hd);
	boolean checkMaHD(int _ma);
}
