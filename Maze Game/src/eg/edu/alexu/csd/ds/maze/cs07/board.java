package eg.edu.alexu.csd.ds.maze.cs07;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class board extends JPanel implements ActionListener{

	private Timer timer;
	private map m;
	private player p;
	private String res = "";
	private String res2 = "Could you help our miser programmer and kill the bug!!!";
	private boolean win;
	private Font font = new Font ("Serif", Font.BOLD, 30);
	private Font font2 = new Font ("Serif", Font.ITALIC, 40);
	private Image image12;
	
	
	public board () throws IOException{
	
		ImageIcon img = new ImageIcon("C://New folder (4)//maze project deliver final//kill.jpg");
		image12 = img.getImage();
		
		m = new map();
		p = new player();
		addKeyListener(new A1());
		setFocusable(true);
		timer = new Timer();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(m.arr[p.get_tilex()][p.get_tiley()] == 'E') {res = "Thanks I can now sleep !!!!!"; System.out.println("1");}
		repaint();
	}
	
	public void paint (Graphics g){
		super.paint(g);
		//g.setColor(Color.red);
		//g.fillRect(45, 60, 32, 32);
		
		if(!win){
		for(int i = 0; i < m.row ; i++){
			for(int j = 0; j < m.col ; j++){
				
				if(m.arr[i][j] == '.' || m.arr[i][j] == 'S'){
					g.drawImage(m.getGrass(), j * 80, i * 50 , null);
				}
				else if(m.arr[i][j] == '#'){
					g.drawImage(m.getWall(), j * 80, i * 50 , null);
				}
				else if(m.arr[i][j] == 'E'){
					g.drawImage(m.getFinish(), j * 80, i * 50 , null);
				}/*
				else if (m.arr[i][j] == '.'){
					g.drawImage(m.getGrass(), i * 32, j * 32 , null);
				}*/
				
				
			}
		}
		g.setColor(Color.darkGray);
		g.setFont(font2);
		g.drawString(res2, 150, 300);
		repaint();
		
		}
	
		if(win){
			g.setColor(Color.blue);
			g.setFont(font);
			g.drawString(res, 300, 100);
			repaint();
			g.drawImage(image12, 300, 250, null);
			repaint();
		}
		
		if(! win ){ 
			g.drawImage(p.get_player(), p.get_tiley() * 80, p.get_tilex() * 50, null);
			repaint();
		}	
	}
	public class A1 implements KeyListener{
		
		public void keyPressed(KeyEvent e){
			int key_code = e.getKeyCode();
			
			if(key_code == KeyEvent.VK_UP){
				if(m.arr[p.get_tilex() - 1][p.get_tiley()] != '#')
				p.move(-1, 0);
				
				
			}
			else if(key_code == KeyEvent.VK_DOWN){
				if(m.arr[p.get_tilex() + 1][p.get_tiley()] != '#')
				p.move(1, 0);
			}
			else if(key_code == KeyEvent.VK_LEFT){
				if(m.arr[p.get_tilex()][p.get_tiley() - 1] != '#')
				p.move(0, -1);
			}
			else if(key_code == KeyEvent.VK_RIGHT){
				if(m.arr[p.get_tilex()][p.get_tiley() + 1] != '#')
				p.move(0, 1);
			}
			
			if(m.arr[p.get_tilex()][p.get_tiley()] == 'E'){res = "Thanks I can now sleep !!!!!"; win = true;}
			
			
		}
		
		public void KeyReleased(KeyEvent e){
			
		}
		public void KeyTyped(KeyEvent e){
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}		
	}	
}

