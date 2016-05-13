package eg.edu.alexu.csd.oop.game.state;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.LinkedList;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class State implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean status;
	protected LinkedList<GameObject> objects  = new LinkedList<GameObject>();
	protected BufferedImage image;
	
	public boolean getStatus(){return status;}
	
	public LinkedList<GameObject> getObjects(){return objects;}
	
	public abstract String toString();

}