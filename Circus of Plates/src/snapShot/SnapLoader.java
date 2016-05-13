package snapShot;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SnapLoader {
	public static Object load(String path){
		FileInputStream fis;
		BufferedInputStream bis;
		ObjectInputStream ois;
		Object obj = null;
		try {
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();
			fis.close();
			bis.close();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
