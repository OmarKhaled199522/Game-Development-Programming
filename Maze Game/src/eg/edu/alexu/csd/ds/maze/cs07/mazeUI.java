package eg.edu.alexu.csd.ds.maze.cs07;



import java.io.IOException;
import java.util.*;

public class mazeUI {

	public static void main(String[] args) throws IOException {
		
		methods o = new methods();
		bfs n = new bfs();
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose from the following :\n...............................\n"
				+ "1 - dfs\n2 - bfs\n3 - generate random maze\n4 - Do you want special gates to output in case of valid access to\n"
				+ "5- for a player gui");
		int action ;
		action = scan.nextInt();
		if (action == 1){
		o.readFromFile();
		o.dfs();
		}
		else if (action == 2){
			n.bfs_implementation();
		}
		else if (action == 3){
			o.generateRandom();
			o.dfs();
		}
		else if (action == 4){
			
			 n.setSpecial_positions(1);
			n.bfs_implementation();	
			
		} else if (action == 5){
			maze_gui b = new maze_gui();
		}
		
		scan.close();
	}

}
