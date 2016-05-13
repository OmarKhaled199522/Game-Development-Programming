package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;


public class Clown implements GameObject , Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int  width = 120 ;   
	private final int  height =120 ;
	private int max , min , finalY;
	private int x;
	private int y;
	private BufferedImage[] spriteImages = new BufferedImage[1];
	private ClownStack lift = new ClownStack();
	private ClownStack right = new ClownStack();
	
	
	public Clown(int min , int max , int finalY){
		this.max = max ;
		this.min = min;
		this.finalY = finalY;
		lift.setY(y+height);
		lift.setClown(this);
		right.setX(x+width -15);
		right.setY(y+height);
		right.setClown(this);
	}
	
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("/clown.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return spriteImages;
	}

	@Override
	public boolean isVisible() {
		return true;
	}
	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
	}
	@Override
	public void setX(int x) {
		if(x < max && x > min){
			this.x = x;
			lift.setX(this.x);
			right.setX(this.x+width-30);

		}
	}
	@Override
	public void setY(int y){
		this.y = finalY;		
	}


	public ClownStack getLift() {
		return lift;
	}


	public void setLift(ClownStack lift) {
		this.lift = lift;
	}


	public ClownStack getRight() {
		return right;
	}


	public void setRight(ClownStack right) {
		this.right = right;
	}

}
