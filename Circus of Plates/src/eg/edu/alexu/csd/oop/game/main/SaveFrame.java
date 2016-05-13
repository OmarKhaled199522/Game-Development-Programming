package eg.edu.alexu.csd.oop.game.main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import eg.edu.alexu.csd.oop.game.World;
import snapShot.SnapSaver;

public class SaveFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private World  world = null;
	
	public SaveFrame(World world){
		this.world = world;
		setLayout(null);
		JButton save =new JButton("Save");
		save.setBounds(10, 10, 200, 40);
		Event event = new Event();
		save.addActionListener(event);
		
		add(save);
	}
	
	private class Event implements ActionListener{
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
		    SnapSaver.save(world, path);
		}
	}
}
