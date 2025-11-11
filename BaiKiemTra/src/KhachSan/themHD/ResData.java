package KhachSan.themHD;

import java.util.ArrayList;
import java.util.Arrays; 

public class ResData {
	public ArrayList<String> listMessage;	
	public ResData() {
		listMessage = new ArrayList<String>();
	}
	public ResData(String[] errorMessages) {
		this.listMessage = new ArrayList<>(Arrays.asList(errorMessages));
	}

}