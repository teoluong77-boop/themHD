package KhachSan.themHD;
import java.time.LocalDate;
import KhachSan.HDGio;
public class ThemHDControlGio extends ThemHDControl {
	
	public ThemHDControlGio(ThemHDResultDialogGUI _gui, ThemHDDAO _dao) {
		super(_gui, _dao);
	}
	@Override
	protected void execute(ReqData reqData) {
		if (!HDGio.checkSoGio(reqData.soGioThue)) 
			resData.listMessage.add("Số giờ thuê không hợp lệ (1–30)!");
		if (!KhachSan.HoaDon.checkDonGia(reqData.donGia))
			resData.listMessage.add("Đơn giá phải ≥ 50.000!");
		if (resData.listMessage.size() == 0)
			hd = new HDGio(reqData.maHD, LocalDate.now(), reqData.tenKH, reqData.maPhong, reqData.donGia, reqData.soGioThue);
	}
}