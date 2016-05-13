package eg.edu.alexu.csd.oop.game.state;

import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.object.AdditionObject;

public class LoseState extends State implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoseState() throws IOException{
		this.status = false;
		this.createObjects();
		this.image = ImageIO.read(getClass().getResourceAsStream("/HL.png"));
		AdditionObject obj = new AdditionObject();
		obj.setX(180);
		obj.setY(100);
		obj.setImage(image);
		this.objects.add(obj);
	}
	
	private void createObjects(){
		AdditionObject obj;
		int x , y;
		for(int i = 0; i < 20; i++){
			x = (int) (Math.random() * 700);
			y = (int) (Math.random() * (300));
			obj = new AdditionObject();
			obj.setX(x);
			obj.setY(y);
			this.objects.add(obj);
		}
	}
	
	public String toString(){
		return "Lose State";
	}

}
