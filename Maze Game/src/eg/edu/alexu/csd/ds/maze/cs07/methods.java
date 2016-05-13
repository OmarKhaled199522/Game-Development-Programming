package eg.edu.alexu.csd.ds.maze.cs07;

import java.awt.Point;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class methods {
	MyStack s = new StackImplementatio();
	char arr[][];
	boolean v[][];
	Point start = new Point();
	Point end = new Point();
	Point points[];
	Point sGate;
	Point s2Gate;
	Point s3Gate;
	Point s4Gate;
	Point s5Gate;


	Point eGate;
	boolean flag = false;
	int n, m;
	Scanner scan = new Scanner(System.in);

	public void readFromFile() throws IOException {
		String line;
		char lineArr[];
		BufferedReader r = new BufferedReader(new FileReader("maze.txt"));
		String a[] = r.readLine().split("\\s+");
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		arr = new char[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			line = r.readLine();
			lineArr = line.toCharArray();
			for (int j = 0; j < m; j++) {
				arr[i][j] = lineArr[j];
				v[i][j] = false;
				if (arr[i][j] == 'S') {
					start.x = i;
					start.y = j;
				} else if (arr[i][j] == 'E') {
					end.x = i;
					end.y = j;
				} else if (arr[i][j] == '#')
					v[i][j] = true;

			}

		}
		
		r.close();
	}

	Point neighbour(int x, int y) {
		if (arr[x][y]=='i' && flag == true && v[eGate.x][eGate.y] == false  ){
			flag = true;
			return new Point (eGate.x,eGate.y);
		}
		if ((y + 1) < m && v[x][y + 1] == false)
			return new Point(x, y + 1);
		if ((x + 1) < n && v[x + 1][y] == false)
			return new Point(x + 1, y);
		if ((y - 1) >= 0 && v[x][y - 1] == false)
			return new Point(x, y - 1);

		if ((x - 1) >= 0 && v[x - 1][y] == false)
			return new Point(x - 1, y);

		return null;
	}

	public void dfs() {
		int i = start.x, j = start.y;
		s.push(new Point(i, j));
		v[i][j] = true;
		// System.out.println("( " + i + " , " + j + " ) ");
		try {

			while (!s.isEmpty()) {

				Point p = neighbour(i, j);
				if (p == null) {
					p = (Point) s.pop();
					p = (Point) s.peek();
					i = p.x;
					j = p.y;
				} else {
					s.push(p);
					i = p.x;
					j = p.y;
					// System.out.println("( " + i + " , " + j + " ) ");
					v[p.x][p.y] = true;

				}
				if (i == end.x && j == end.y) {
					int count = 0;
					points = new Point[s.size()];
					while (!s.isEmpty()) {
						p = (Point) s.pop();
						points[count++] = p;
						// System.out.println("( " + p.x + " , " + p.y + " ) ");

					}

					break;
				}
			}
			for (int k = points.length - 1; k >= 0; k--)
				System.out.println("( " + points[k].x + " , " + points[k].y
						+ " ) ");

		} catch (Exception e) {
			System.out.println("Can't find a path !");
		}
	}
	public void generateRandom() throws IOException {
		flag = true;
		Random r = new Random();
		m = r.nextInt(6) + 6;
		n = r.nextInt(6) + 6;
		arr = new char[n][m];
		v = new boolean[n][m];
		sGate = new Point(r.nextInt(n-2)+1,r.nextInt(m-2)+1); 
		s2Gate = new Point(r.nextInt(n-2)+1,r.nextInt(m-2)+1); 
		s3Gate = new Point(r.nextInt(n-2)+1,r.nextInt(m-2)+1);
		s4Gate = new Point(r.nextInt(n-2)+1,r.nextInt(m-2)+1);
		s5Gate = new Point(r.nextInt(n-2)+1,r.nextInt(m-2)+1);
		while (true){
		eGate = new Point(r.nextInt(n-2)+1,r.nextInt(m-2)+1); 
		if (arr[eGate.x][eGate.y] !='i'){
			
			System.out.println(eGate.x );
			System.out.println(eGate.y );
			break;
		}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = '.';
				v[i][j] = false;
				if( (i ==sGate.x && j == sGate.y) || (i ==s2Gate.x && j == s2Gate.y) ||(i ==s3Gate.x && j == s3Gate.y)||(i ==s4Gate.x && j == s4Gate.y)||(i ==s5Gate.x && j == s5Gate.y) )
					arr[i][j] = 'i';
				if (i == eGate.x && j == eGate.y){
					arr[i][j] = 'o';
					
				}
			}
		}
		int no;
		for (int i = 1; i < n - 1; i++) {
			no = r.nextInt(m);
			if (i != eGate.x && no != eGate.y){
			arr[i][no] = '#';
			v[i][no] = true;
			}

		}
		start.x = 0;
		start.y = r.nextInt(m);

		end.x = n - 1;
		end.y = r.nextInt(m);
		arr[start.x][start.y] = 'S';
		arr[end.x][end.y] = 'E';

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		/*
		 * BufferedWriter w = new BufferedWriter(new FileWriter("case.txt",
		 * true)); w.write("fgh"); w.write(" "); w.write(m); w.newLine(); for
		 * (int i = 0 ; i < n ;i++){ for (int j = 0 ; j < m ; j++)
		 * w.write(arr[i][j]); w.newLine(); }
		 */
	}

}
