package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class MyObject implements GameObject , Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int x;
	protected int y;
	private ClownStack stack = null;
	
	private FlyWeight obj;

	protected String type;


	public void setType(String type) {
		this.type = type;
	}


	public FlyWeight getObj() {
		return obj;
	}


	public void setObj(FlyWeight obj) {
		this.obj = obj;
	}
	

	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		if(stack == null)
			this.x = x;
		else {
			this.x = stack.getX();
		}
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		if(stack == null)
			this.y =y;
	}

	@Override
	public abstract int getWidth();

	@Override
	public abstract int getHeight();

	@Override
	public abstract boolean isVisible();

	@Override
	public abstract BufferedImage[] getSpriteImages();
	


	
	public abstract String getType();
	
	
	public void setStack(ClownStack stack) {
		this.stack = stack;
	}
}
