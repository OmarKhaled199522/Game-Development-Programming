package eg.edu.alexu.csd.oop.game.world;

import java.io.Serializable;

public abstract class Observer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Subject subject;
	public abstract void update();

}
