package eg.edu.alexu.csd.oop.game.object;

import java.io.Serializable;

public class FlyWeight implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String img;
	private int height , width;
	
	public FlyWeight (String img, int width , int height){
		this.img = img;
		this.width = width;
		this.height = height;
	}

	public String getImage() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getLenght() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	
}
