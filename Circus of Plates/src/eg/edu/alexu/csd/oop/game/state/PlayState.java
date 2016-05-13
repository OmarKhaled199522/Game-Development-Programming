package eg.edu.alexu.csd.oop.game.state;

import java.io.Serializable;

public class PlayState extends State implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayState(){
		this.status = true;
		this.objects = null;
		this.image = null;
	}
	
	public String toString(){
		return "Play State";
	}

}
