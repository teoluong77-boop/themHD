package QuanLiKhachSan.themHoaDon;

import QuanLiKhachSan.HoaDon;

public abstract class ThemHDControl {
	protected ResultDialogGUI resultDialogGUI;
	protected ThemHDDAO themHDDAO;
	protected HoaDon hd;
	protected ResData resData;

	protected ThemHDControl(ResultDialogGUI _gui, ThemHDDAO _dao) {
		resultDialogGUI = _gui;
		themHDDAO = _dao;
	}

	public void control(ReqData reqData) {
		resData = new ResData();
		checkMaHD(reqData.maHD);
		execute(reqData);

		if (resData.listMessage.size() > 0) {
			resultDialogGUI.show(resData);
			return;
		}

		themHDDAO.insert(hd);
		resData.listMessage.add("Thêm hóa đơn thành công!");
		resultDialogGUI.show(resData);
	}

	protected abstract void execute(ReqData reqData);

	private void checkMaHD(int _ma) {
		if (!themHDDAO.checkMaHD(_ma)) {
			resData.listMessage.add("Mã hóa đơn bị trùng!");
		}
	}
}
