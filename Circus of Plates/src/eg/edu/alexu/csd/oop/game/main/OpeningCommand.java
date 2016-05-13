package eg.edu.alexu.csd.oop.game.main;

import javax.swing.JFrame;

import dynamicLinkage.Environment;
import eg.edu.alexu.csd.oop.game.World;
import environments.CircusVersion1;

public class OpeningCommand {
	public void act(Environment environ , World world){
		CircusVersion1 cv = (CircusVersion1) environ;
		cv.setWorld(world);
		cv.setSet(true);
		SaveFrame gui = new SaveFrame(world);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(300	, 300);
		gui.setResizable(false);
		gui.setTitle("Save");
	}
}
