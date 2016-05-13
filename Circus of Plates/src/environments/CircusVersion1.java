package environments;

import javax.swing.JFrame;

import dynamicLinkage.Environment;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.main.GUI;

public class  CircusVersion1 implements Environment {

	private JFrame screen = new GUI(this);
	private World myWorld;
	boolean set = false;

	@Override
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return screen;
	}

	@Override
	public boolean isSet() {
		// TODO Auto-generated method stub
		return set;
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return myWorld;
	}
	
	public void setSet(boolean set){
		this.set = set;
	}
	
	public void setWorld(World myWorld){
		this.myWorld = myWorld;
	}

	@Override
	public void displayFrame() {
		// TODO Auto-generated method stub
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setSize(300, 300);
		screen.setResizable(false);
		screen.setTitle("Game");
	}
}
