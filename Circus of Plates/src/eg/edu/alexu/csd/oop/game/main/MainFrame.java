package eg.edu.alexu.csd.oop.game.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dynamicLinkage.GameDynamicLoadable;

public class MainFrame extends JFrame {
		private static final long serialVersionUID = 1L;
		private JTextField text;
		private GameDynamicLoadable loader= new GameDynamicLoadable();
		public MainFrame(){
			setLayout(null);
			text  = new JTextField("");
			text.setBounds(10, 10, 200, 20);
			JButton button = new JButton("enter");
			button.setBounds(10,60,200,40);
			add(text);
			add(button);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String s = text.getText();
					loader.setEnvironment(s);
					loader.start();
				}
				
			});
		}
		
		public static void main (String[] args){
			MainFrame gui = new MainFrame();
			gui.setVisible(true);
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gui.setSize(300	, 200);
			gui.setResizable(false);
			gui.setTitle("Game");
		}
}
