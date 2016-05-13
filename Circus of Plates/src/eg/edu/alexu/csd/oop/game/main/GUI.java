package eg.edu.alexu.csd.oop.game.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import dynamicLinkage.Environment;
import eg.edu.alexu.csd.oop.game.Strategy;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.world.Easy;
import eg.edu.alexu.csd.oop.game.world.Hard;
import eg.edu.alexu.csd.oop.game.world.Medium;
import eg.edu.alexu.csd.oop.game.world.StrategyCaller;
import snapShot.SnapLoader;

public class GUI extends JFrame{
private static final long serialVersionUID = 1L;
	
	private World world = eg.edu.alexu.csd.oop.game.world.CircusOfPlates.getInstance();
	private Environment environ; 

	public GUI(Environment environment){
		environ = environment;
		setLayout(null);
		JButton easy = new JButton("Easy");
		easy.setBounds(50, 10, 200, 40);
		easy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Strategy s = new Easy();
				StrategyCaller caller  = new StrategyCaller(s);
				caller.startWorld();
				OpeningCommand command = new OpeningCommand();
			    command.act(environ, world);
				setVisible(false);
			}
		});
		JButton medium = new JButton("Medium");
		medium.setBounds(50, 60, 200, 40);
		medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Strategy s = new Medium();
				StrategyCaller caller  = new StrategyCaller(s);
				caller.startWorld();
				OpeningCommand command = new OpeningCommand();
			    command.act(environ, world);
				setVisible(false);
			}
		});
		JButton hard = new JButton("Hard");
		hard.setBounds(50, 110, 200, 40);
		hard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Strategy s = new Hard();
				StrategyCaller caller  = new StrategyCaller(s);
				caller.startWorld();
				OpeningCommand command = new OpeningCommand();
			    command.act(environ, world);
				setVisible(false);
			}
		});
		
		JButton load = new JButton("Load");
		load.setBounds(50, 160, 200, 40);
		load.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
			    chooser.setDialogTitle(a.getActionCommand());
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(true);//can be problem
			    chooser.setApproveButtonText(a.getActionCommand());
			    String path = null;
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			    	 path = chooser.getSelectedFile().toString();
			    }
			    Object obj = SnapLoader.load(path);
			    world = (World) obj;
			    OpeningCommand command = new OpeningCommand();
			    command.act(environ, world);
				setVisible(false);
			}
		}); 
			
		this.add(load);
		this.add(easy);
		this.add(medium);
		this.add(hard);
	}
	



}
