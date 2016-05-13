package snapShot;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import eg.edu.alexu.csd.oop.game.World;

public class SnapSaver {
	public static void save(World myWorld , String path){
		File fil = new File(path);
		if(!fil.exists()){
			try {
				fil.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileOutputStream fos;
		BufferedOutputStream bos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream(path);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(myWorld);
			fos.close();
			bos.close();
			oos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
