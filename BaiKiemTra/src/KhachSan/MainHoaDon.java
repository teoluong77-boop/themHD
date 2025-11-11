package KhachSan;
	import java.time.LocalDate;
	public class MainHoaDon {
	    public static void main(String[] args) {
	        // test nhanh 
	        HDGio g = new HDGio(11, LocalDate.now(), "Test Gio", "P300", 60000, 26);
	        HDNgay n = new HDNgay(12, LocalDate.now(), "Test Ngay", "P301", 200000, 8);
	        MemoryHDDatabase.put(g);
	        MemoryHDDatabase.put(n);
	        for (HoaDon h : MemoryHDDatabase.getAll()) {
	            System.out.println("Mã: " + h.getMaHD() + " - Khách: " + h.getTenKH() + " - Thành tiền: " + h.tinhTien());
	        }
	    }
	}
