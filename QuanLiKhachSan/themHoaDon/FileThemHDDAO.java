package QuanLiKhachSan.themHoaDon;

import java.io.*;
import java.util.HashMap;
import QuanLiKhachSan.HoaDon;

public class FileThemHDDAO implements ThemHDDAO {
    private String fileName;

    public FileThemHDDAO(String _fileName) {
        fileName = _fileName;
    }

    @Override
    public void insert(HoaDon _hd) {
        HashMap<Integer, HoaDon> memoryDB = getFromFile();
        if (memoryDB == null) {
            memoryDB = new HashMap<Integer, HoaDon>();
        }
        memoryDB.put(_hd.getMaHD(), _hd);
        writeToFile(memoryDB);
    }

    @Override
    public boolean checkMaHD(int _ma) {
        HashMap<Integer, HoaDon> memoryDB = getFromFile();
        if (memoryDB != null) {
            if (memoryDB.get(_ma) != null) {
                return false;
            }
        }
        return true;
    }

    private HashMap<Integer, HoaDon> getFromFile() {
        HashMap<Integer, HoaDon> memoryDB = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) return null;

            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream oIn = new ObjectInputStream(fileIn);
            memoryDB = (HashMap<Integer, HoaDon>) oIn.readObject();
            oIn.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return memoryDB;
    }

    private void writeToFile(HashMap<Integer, HoaDon> memoryDB) {
        try {
            FileOutputStream fOut = new FileOutputStream(fileName);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(memoryDB);
            oOut.close();
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
