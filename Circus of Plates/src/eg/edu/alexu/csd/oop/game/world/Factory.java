package eg.edu.alexu.csd.oop.game.world;

import java.io.Serializable;

import eg.edu.alexu.csd.oop.game.object.MyObject;
import eg.edu.alexu.csd.oop.game.object.Plate;
import eg.edu.alexu.csd.oop.game.object.Rectangle;

public class Factory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyObject getShape(String shape){
		
		String[] splited = shape.split("\\s+");
		shape = splited[1];
		String img = splited[0];
		
		if (shape.equalsIgnoreCase("Rectangle")){
			return new Rectangle(img);
		}
		
		if (shape.equalsIgnoreCase("Plate"))
			return new Plate(img);
		return null;
	}

}
