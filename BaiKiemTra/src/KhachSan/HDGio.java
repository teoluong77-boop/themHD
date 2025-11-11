package KhachSan;
import java.time.LocalDate;
	/**
	 * Hóa đơn theo giờ.
	 * - Nếu số giờ > 30 => không dùng loại này (trả về 0)
	 * - Nếu 24 < số giờ < 30 => tính 24 * đơn giá
	 * - Ngược lại: số giờ * đơn giá
	 */
	public class HDGio extends HoaDon {
	    private static final long serialVersionUID = 1L;
	    private double soGio; 
	    public HDGio() {}	  
	    public HDGio(int _maHD, LocalDate _ngayHD, String _tenKH, String _maPhong, double _donGia, double _soGio) {
	        super(_maHD, _ngayHD, _tenKH, _maPhong, _donGia);
	        soGio = _soGio;
	    }
	    @Override
	    public double tinhTien() {
	        if (soGio > 30) return 0.0;                 
	        if (soGio > 24 && soGio < 30) return 24 * donGia;
	        return soGio * donGia;                      
	    }
	    public double getSoGio() { return soGio; } 
	    public void setSoGio(double _soGio) { soGio = _soGio; }	
	    public static boolean checkSoGio(double soGioThue) { return soGioThue > 0 && soGioThue <= 30; }
	}