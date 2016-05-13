package eg.edu.alexu.csd.ds.maze.cs07;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class bfs {

	private int dirc [] [] = {{1 , 0}, {-1 , 0}, {0, 1}, {0 , -1}};
	private int n , m;
	private int special_positions = 0;
	private boolean arr [][];
	private Point path [] [];
	private Point start = new Point();
	private Point end = new Point();
	
	public int getSpecial_positions() {
		return special_positions;
	}

	public void setSpecial_positions(int special_positions) {
		this.special_positions = special_positions;
	}

	void read () throws IOException{
		
		BufferedReader h = new BufferedReader(new FileReader("maze.txt"));
		String temp [] = h.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		arr = new boolean [n + 10][m + 10];
		path = new Point [n + 10][m + 10];
		
		for(int i = 0; i < n; i++){
			String store = h.readLine();
			for(int j = 0; j < m; j++){
				
				if(store.charAt(j) == '#') arr[i][j] = true;
				else if (store.charAt(j) == 'S'){ start = new Point(i , j); arr[i][j] = true;}
				else if (store.charAt(j) == 'E') end = new Point(i , j);
			}
		}
		
		h.close();
	}

	void print_path(Point start , Point end){
		
		if(start.equals(end)) System.out.println("( " + (start.x ) + ", " + (start.y ) + " )");
		else {
			print_path(start, path[end.x][end.y]);
			System.out.println("( " + (end.x ) + ", " + (end.y ) + " )");
		}
		
	}
	
	
	public void bfs_implementation () throws IOException{
		
		Queue_linkedlist q = new Queue_linkedlist();
		Scanner input = new Scanner(System.in);
		read();
		
		/*n = input.nextInt();
		m = input.nextInt();
		
		for(int i = 0 ;i < n; i++){
			String temp = input.next();
			for(int j = 0; j < m; j++){
				
				if(temp.charAt(j) == '#') arr[i][j] = true;
				else if (temp.charAt(j) == 'S'){ start = new Point(i , j); arr[i][j] = true;}
				else if (temp.charAt(j) == 'E') end = new Point(i , j);
				
			}
		}*/
		
		q.enqueue(start);
		int found = 0;
		while(!q.isEmpty() && found == 0){
			
			Point node = (Point) q.dequeue();
			
			for(int i = 0; i < 4; i++){
				
				int nx = node.x + dirc [i][0];
				int ny = node.y + dirc [i][1];
				
				if(nx < n && nx >= 0 && ny < m && ny >= 0){
					if(arr[nx][ny] == false && (nx != end.x || ny != end.y) ){
						//q.enqueue(path [size++] = new Point (nx , ny));
						q.enqueue(new Point (nx , ny));
						path[nx][ny] = new Point (node.x, node.y);
						arr[nx][ny] = true;
						
						if(special_positions == 1 && nx == ny) {found = 2; end.x = nx; end.y = ny ;break;}
					
					} else if (!arr[nx][ny] && (nx == end.x && ny == end.y)) {path[end.x][end.y] = new Point(node.x, node.y);found = 1; break;}
				}
			}
		}
		/*if(found == 1){
			System.out.println("Maze solution : ");
			System.out.println(start);
			for(int i = 0; i < size; i++)
				System.out.println(path[i]);
			System.out.println(end);
			
		} else System.out.println("No valid path!!!!"); */
		
		if(found == 1 || (special_positions == 1 && found == 2) ){
			
			System.out.println("Maze solution : ");
			print_path(start, end);
			
		} else {
			
			System.out.println("No valid path!!!!");
		}
		
		input.close();
	}
}
