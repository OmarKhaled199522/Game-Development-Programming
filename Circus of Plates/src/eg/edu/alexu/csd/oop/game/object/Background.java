package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Background implements GameObject {

	private final int width = 700;
	private final int height = 600;
	private int x = 0;
	private int y  = 0;
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
		this.y =y;
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
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("/back.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return spriteImages;
	}
	
}
