package eg.edu.alexu.csd.oop.game.world;

import java.io.Serializable;
import java.util.ArrayList;

public class Subject  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private int state;

	public void attach(Observer observer) {
		observers.add(observer);
	}
	public int getState() {
		return state;
		}
		public void setState(int state) {
		this.state = state;
		notifyAllObservers();
		}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
