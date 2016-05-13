package environments;

import javax.swing.JFrame;
import dynamicLinkage.Environment;
import eg.edu.alexu.csd.oop.game.World;

public class DemoVersion2 implements Environment{

	private JFrame screen = null;
	private World myWorld = new plugin.Ball(400, 400);

	@Override
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return screen;
	}

	@Override
	public boolean isSet() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return myWorld;
	}

	@Override
	public void displayFrame() {
		// TODO Auto-generated method stub
		return;
	}

}
