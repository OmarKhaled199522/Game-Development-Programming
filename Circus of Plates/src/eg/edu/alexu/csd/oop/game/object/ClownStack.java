package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Stack;

import eg.edu.alexu.csd.oop.game.GameObject;

public class ClownStack implements GameObject , Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Stack<MyObject> stack = new Stack<MyObject>();
	private Clown clown;
	private int width = 30;
	private int height = 5;
	private int x;
	
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
		return clown.getY();
	}

	@Override
	public void setY(int y) {
	}
	
	
	public void setWidth(int width) {
		this.width = width;
	}

	
	public void setHeight(int height) {
		this.height = height;
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
	public boolean isVisible() {
		return false;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return null;
	}

	public Clown getClown() {
		return clown;
	}

	public void setClown(Clown clown) {
		this.clown = clown;
	}

	public void add(MyObject o) {
		System.out.print(o.getClass().getName());
		height += o.getHeight(); 
		o.setStack(this);
		stack.add(o);
	}

	public MyObject pop() {
		MyObject o = stack.pop();
		height -= o.getHeight();
		return o;
	}
	
	public int size() {
		return stack.size();
	}
	
	public MyObject peek() {
		return stack.peek();
	}

}
