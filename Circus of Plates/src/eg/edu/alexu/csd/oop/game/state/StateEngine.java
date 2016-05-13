package eg.edu.alexu.csd.oop.game.state;

import java.io.Serializable;

public class StateEngine implements Serializable{
	
		/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private State presentState;
		private State[] allState = new State[3];
		private int maxScore = 1;
		
		public StateEngine(){
			try{
				presentState = null;
				allState[0] = new PlayState();
				allState[1] = new WinState();
				allState[2] = new LoseState();
			}catch(Exception e){
				System.out.println("my null");
			}
		}
				
		public State getState(){return presentState;}
		
		public void update(int score, int lives){
			if(lives == 0){
				presentState = allState[2];
			}
			else if(score == maxScore){
				presentState = allState[1];
			}
			else{
				presentState = allState[0];
			}
		}
		
		
}
