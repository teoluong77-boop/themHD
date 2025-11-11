package KhachSan;
import java.time.LocalDate;
	/**
	 * Hóa đơn theo ngày.
	 * Quy tắc:
	 * - Nếu soNgay <= 7: soNgay * donGia
	 * - Nếu soNgay > 7: 7*donGia + (soNgay-7) * donGia * 0.8 (giảm 20% cho phần >7)
	 */
	public class HDNgay extends HoaDon {
	    private static final long serialVersionUID = 1L;
	    private double soNgay; 
	    public HDNgay() {}	   
	    public HDNgay(int _maHD, LocalDate _ngayHD, String _tenKH, String _maPhong, double _donGia, double _soNgay) {
	        super(_maHD, _ngayHD, _tenKH, _maPhong, _donGia);
	        soNgay = _soNgay;
	    }
	    @Override
	    public double tinhTien() {
	        if (soNgay <= 7) return soNgay * donGia;	   
	        double giamGia = soNgay - 7; 
	        return 7 * donGia + giamGia * donGia * 0.8;
	    }
	    public double getSoNgay() { return soNgay; }
	    public void setSoNgay(double _soNgay) { soNgay = _soNgay; } 
	    public static boolean checkSoNgay(double _soNgay) { return _soNgay > 0; }
	}