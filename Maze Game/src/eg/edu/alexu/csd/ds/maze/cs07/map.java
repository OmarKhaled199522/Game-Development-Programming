package eg.edu.alexu.csd.ds.maze.cs07;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;


public class map {

	public int col , row;
	public char arr [][];
	public  Image grass , wall, finish;
	
	public map() throws IOException{
		
		ImageIcon img = new ImageIcon("C://New folder (4)//maze project deliver final//grass.png");
		grass = img.getImage();
		ImageIcon img2 = new ImageIcon("C://New folder (4)//maze project deliver final//wall.png");
		wall = img2.getImage();
		img2 = new ImageIcon("C://New folder (4)//maze project deliver final//bug.png");
		finish = img2.getImage();
		
		
		read_file();
	}
	
	public Image getGrass(){
		return grass;
	}
	
	public Image getWall(){
		return wall;
	}
	public Image getFinish(){
		return finish;
	}
	
	public void read_file() throws IOException{
		
		BufferedReader h = new BufferedReader(new FileReader("maze.txt"));
		String temp [] = h.readLine().split(" ");
		row = Integer.parseInt(temp[0]);
		col = Integer.parseInt(temp[1]);
		arr = new char [row][col];
		
		
		for(int i = 0; i < row ; i++){
			String store = h.readLine();
			for(int j = 0; j < col  ; j++){
				arr[i][j] = store.charAt(j);
			}
		
		}
		
		h.close();
	}
	
}
