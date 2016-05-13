package eg.edu.alexu.csd.ds.maze.cs07;

import java.awt.*;
import java.io.IOException;

import javax.swing.ImageIcon;


public class player {

	private int tilex , tiley;
	private Image play;
	private map v;
	
	public player() throws IOException{
		
		ImageIcon img = new ImageIcon("C://New folder (4)//maze project deliver final//fighter4.png");
		play = img.getImage();
		search();
	}
	
	public void search() throws IOException{

		v = new map();
		for(int i = 0; i< v.row ; i++){
			for(int j = 0; j < v.col ; j++){
				if(v.arr[i][j] == 'S'){
					tilex = i; tiley = j;
					break;
				}
			}
		}
	}
	
	public Image get_player(){
		return play;
	}
	
	public int get_tilex(){
		return tilex;
	}
	
	public int get_tiley(){
		return tiley;
	}
	
	
	public void move(int dx, int dy){
		
		tilex += dx;
		tiley += dy;
		
	}
	
}
