package eg.edu.alexu.csd.oop.game.state;

import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.object.AdditionObject;

public class WinState extends State{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WinState() throws IOException{
		this.status = false;
		this.image = ImageIO.read(getClass().getResourceAsStream("/uw.png"));
		AdditionObject obj = new AdditionObject();
		obj.setX(230);
		obj.setY(100);
		obj.setImage(image);
		objects.add(obj);
		this.createObjects();

	}
	
	private void createObjects() throws IOException{
		AdditionObject obj;
		int x , y;
		for(int i = 0; i < 20; i++){
			x = (int) (Math.random() * 700);
			y = (int) (Math.random() * (300));
			obj = new AdditionObject();
			obj.setX(x);
			obj.setY(y);
			if(i % 3 == 0){
				image = ImageIO.read(getClass().getResourceAsStream("/3.png")); 
				obj.setImage(image);
			}
			if(i % 3 == 1){
				image = ImageIO.read(getClass().getResourceAsStream("/3.png")); 
				obj.setImage(image);
			}
			if(i % 3 == 2){
				image = ImageIO.read(getClass().getResourceAsStream("/4.png")); 
				obj.setImage(image);
			}
			objects.add(obj);
		}
	}
	
	public String toString(){
		return "Win State";
	}

}
