package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;


public class Plate extends MyObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type = "";
	private final int  width = 30 ;   
	private final int  height = 10; 
	private BufferedImage[] spriteImages = new BufferedImage[1];
	private String img;
	
	
	public Plate(String img){
		this.img = img;
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
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		try {
			
			if(!img.contains("/"))img = "/" + img + ".png";
			
			for(int i = 0; i < img.length(); i++){
				if(img.charAt(i) == '.') break;
				
			}
			type = img;
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(img));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return spriteImages;
	}
	

	public String getType(){
		return type;
	}

	@Override
	public boolean isVisible() {
		return true;
	}
}
