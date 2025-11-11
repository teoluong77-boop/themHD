package KhachSan.themHD;
import KhachSan.HDNgay;
import java.time.LocalDate;
public class ThemHDControlNgay extends ThemHDControl {
		public ThemHDControlNgay(ThemHDResultDialogGUI _gui, ThemHDDAO _dao) {
			super(_gui, _dao);
		}
		@Override
		protected void execute(ReqData reqData) {
			if (!HDNgay.checkSoNgay(reqData.soNgayThue))
				resData.listMessage.add("Số ngày thuê không hợp lệ (>0)!");
			if (!KhachSan.HoaDon.checkDonGia(reqData.donGia))
				resData.listMessage.add("Đơn giá phải ≥ 50.000!");

			if (resData.listMessage.size() == 0)
				hd = new HDNgay(reqData.maHD, LocalDate.now(), reqData.tenKH, reqData.maPhong, reqData.donGia, reqData.soNgayThue);
		}
	}

