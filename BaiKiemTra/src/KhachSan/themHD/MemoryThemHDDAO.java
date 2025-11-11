package KhachSan.themHD;
import KhachSan.HoaDon;
import KhachSan.MemoryHDDatabase;
public class MemoryThemHDDAO implements ThemHDDAO {
	
		public void insert(HoaDon cx) {

			MemoryHDDatabase.put(cx);

		}

		public boolean checkMaHD(int ma) {
			return MemoryHDDatabase.checkMaHD(ma);
		}
	}
