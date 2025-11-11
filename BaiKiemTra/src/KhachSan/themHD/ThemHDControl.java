package KhachSan.themHD;
import KhachSan.HoaDon;
public abstract class ThemHDControl {
		protected ThemHDResultDialogGUI resultDialogGUI = null;
		protected ThemHDDAO themHDDAO = null;
		protected HoaDon hd = null;
		protected ResData resData = null;
		

		
		protected ThemHDControl(ThemHDResultDialogGUI resultDialogGUI, ThemHDDAO themHDDAO) {
			this.resultDialogGUI = resultDialogGUI;
			this.themHDDAO = themHDDAO;
		}
		
		
		public void control(ReqData reqData) {
			resData = new ResData();
			isMaCXDuplicate(reqData.maHD);
			execute(reqData);
			
			if(resData.listMessage.size() > 0) {
				resultDialogGUI.show(resData);
				return;
			}
			
			insertCX();
			
		}
		
		
		protected abstract void execute(ReqData rqData);

		private void insertCX() {
			themHDDAO.insert(hd);
			resData.listMessage.add("Đã thêm HD thành công!");
			resultDialogGUI.show(resData);
		}
		
		private void isMaCXDuplicate(int maHD) {
			boolean result = themHDDAO.checkMaHD(maHD);
			if(!result) {
				resData.listMessage.add("Mã " + maHD + "bị trùng !");
			}
		}
		
	}

