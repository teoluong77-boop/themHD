package KhachSan;
	import java.io.Serializable;
	import java.time.LocalDate;
	public abstract class HoaDon implements Serializable {
	    private static final long serialVersionUID = 1L;
	    protected int maHD;
	    protected LocalDate ngayHD;
	    protected String tenKH;
	    protected String maPhong;
	    protected double donGia;
	    protected HoaDon() {}
	    protected HoaDon(int _maHD, LocalDate _ngayHD, String _tenKH, String _maPhong, double _donGia) {
	        maHD = _maHD;
	        ngayHD = _ngayHD;
	        tenKH = _tenKH;
	        maPhong = _maPhong;
	        donGia = _donGia;
	    }
	    public abstract double tinhTien();
	    public int getMaHD() { return maHD; }
	    public LocalDate getNgayHD() { return ngayHD; } 	
	    public String getTenKH() { return tenKH; }
	    public String getMaPhong() { return maPhong; }
	    public double getDonGia() { return donGia; }
	    public void setNgayHD(LocalDate _ngayHD) { ngayHD = _ngayHD; }
	    public void setTenKH(String _tenKH) { tenKH = _tenKH; }
	    public void setMaPhong(String _maPhong) { maPhong = _maPhong; }
	    public void setDonGia(double _donGia) { donGia = _donGia; }
	    // Validate đơn giá (ví dụ nghiệp vụ)
	    public static boolean checkDonGia(double _donGia) {
	        return _donGia >= 50000;
	    }
	}
