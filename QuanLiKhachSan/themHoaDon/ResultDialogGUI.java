package QuanLiKhachSan.themHoaDon;

import javax.swing.JOptionPane;

public class ResultDialogGUI {
	public void show(ResData resData) {
		String msg = "";
		for (String s : resData.listMessage) msg += s + "\n";
		JOptionPane.showMessageDialog(null, msg);
	}
}
