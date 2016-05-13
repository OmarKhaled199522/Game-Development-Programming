package eg.edu.alexu.csd.oop.game.world;

import eg.edu.alexu.csd.oop.game.Strategy;

public class StrategyCaller {
	private Strategy strategy ;
	public StrategyCaller(Strategy strategy) {
		this.strategy = strategy;
	}
	public void startWorld(){
		strategy.chooseLevel();
	}
	
}
