package eg.edu.alexu.csd.ds.maze.cs07;
import java.io.IOException;
import javax.swing.JFrame;

public class maze_gui {

	
	public maze_gui() throws IOException{
		
		JFrame first = new JFrame();
	
		first.add(new board());
		first.setSize(850 , 550);
		first.setVisible(true);
		first.setTitle("My first GUI");
		first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}


