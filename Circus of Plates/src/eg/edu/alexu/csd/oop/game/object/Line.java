package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Line implements GameObject , Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private  int  width = 150;   
	private  int  height = 20; 
	private BufferedImage[] spriteImages = new BufferedImage[1];


	
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
	public BufferedImage[] getSpriteImages() {
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("/line.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return spriteImages;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		this.y =y;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
}
