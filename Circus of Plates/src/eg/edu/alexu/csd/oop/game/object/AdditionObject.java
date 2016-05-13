package eg.edu.alexu.csd.oop.game.object;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import eg.edu.alexu.csd.oop.game.GameObject;

public class AdditionObject implements GameObject , Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int  width = 50 ;   
	private final int  height =50 ;
	private int x;
	private int y;
	private BufferedImage[] spriteImages = new BufferedImage[1];


	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return spriteImages;
	}
	
	public void setImage(BufferedImage i){
		spriteImages[0] = i;
	}

}
