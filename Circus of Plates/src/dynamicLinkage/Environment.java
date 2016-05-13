package dynamicLinkage;

import javax.swing.JFrame;

import eg.edu.alexu.csd.oop.game.World;

public interface Environment {
	
	/*
	 * returns JFrame you want to display in the beginning if exists
	 * 		   null other wise
	 */
	public JFrame getFrame();
	
	/*
	 * returns true if the world of environment is set
	 * 		   false if not
	 */
	public boolean isSet();
	
	/*
	 * returns the world of environment if set
	 * 		   null if not	
	 */
	public World getWorld();
	
	/*
	 * displays the frame
	 */
	public void displayFrame();
	
}
