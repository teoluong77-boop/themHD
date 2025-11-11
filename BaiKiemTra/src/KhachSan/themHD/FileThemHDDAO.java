package KhachSan.themHD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import KhachSan.HDGio;
import KhachSan.HDNgay;
import KhachSan.HoaDon;
public class FileThemHDDAO implements ThemHDDAO {
	private String fileName;
	public FileThemHDDAO(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void insert(HoaDon hd){
		HashMap<Integer, HoaDon> memoryDB = null;
		// try {
		memoryDB = getFromFile();

		if (memoryDB == null) {
			memoryDB = new HashMap<Integer, HoaDon>();
		}

		memoryDB.put(hd.getMaHD(), hd);
		writeToFile(memoryDB);

		
	}

	public void writeToFile(HashMap<Integer, HoaDon> memoryDB) {
		File file = new File(fileName);
		FileOutputStream fOut;
		ObjectOutputStream oOut = null;
		try {
			fOut = new FileOutputStream(file);
			oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(memoryDB);
			fOut.close();
			oOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkMaHD(int ma) {
		HashMap<Integer, HoaDon> memoryTemp = null;
		memoryTemp = getFromFile();
		if(memoryTemp != null) {
			if (memoryTemp.get(ma) != null) {
				return false;
			}
		}
		return true;
	}

	private HashMap<Integer, HoaDon> getFromFile() {
		HashMap<Integer, HoaDon> memoryDB = null;
		ObjectInputStream oIn = null;
		File file = new File(fileName);
		FileInputStream fileIn = null;

		try {
			fileIn = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			oIn = new ObjectInputStream(fileIn);
			memoryDB = (HashMap<Integer, HoaDon>) oIn.readObject();

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fileIn.close();
			oIn.close();
		}catch (Exception e) {
			// TODO: handle exception
		}

		return memoryDB;
	}
}
