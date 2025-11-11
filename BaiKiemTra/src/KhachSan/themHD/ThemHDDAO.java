package KhachSan.themHD;
import KhachSan.HoaDon;
public interface ThemHDDAO {
	
	void insert (HoaDon hd);
	
	boolean checkMaHD(int ma);
}
