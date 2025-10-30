package QuanLiKhachSan.themHoaDon;

import java.time.LocalDate;
import QuanLiKhachSan.HDNgay;

public class ThemHDControlNgay extends ThemHDControl {
	public ThemHDControlNgay(ResultDialogGUI _gui, ThemHDDAO _dao) {
		super(_gui, _dao);
	}

	@Override
	protected void execute(ReqData reqData) {
		if (!HDNgay.checkSoNgay(reqData.soNgay))
			resData.listMessage.add("Số ngày thuê không hợp lệ (>0)!");
		if (!QuanLiKhachSan.HoaDon.checkDonGia(reqData.donGia))
			resData.listMessage.add("Đơn giá phải ≥ 50.000!");

		if (resData.listMessage.size() == 0)
			hd = new HDNgay(reqData.maHD, LocalDate.now(), reqData.tenKH, reqData.maPhong, reqData.donGia, reqData.soNgay);
	}
}
