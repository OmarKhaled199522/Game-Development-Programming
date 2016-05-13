package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class Rectangle extends MyObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type = "";
	private final int  width = 30 ;   
	private final int  height = 10 ;
	private BufferedImage[] spriteImages = new BufferedImage[1];
	private String img;
	
	
	public Rectangle(String img) {
		this.img = img;
	}
	
	@Override
	public String getType() {
		return type;
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
		// TODO Auto-generated method stub
		
		
		try {
			if(!img.contains("/"))img = "/" + img + ".png";
			
			for(int i = 0; i < img.length(); i++){
				if(img.charAt(i) == '.') break;
			}
			
			type = img;
			//System.out.println(type);
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(img));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return spriteImages;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
