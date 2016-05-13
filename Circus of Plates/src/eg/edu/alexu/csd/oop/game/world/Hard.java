package eg.edu.alexu.csd.oop.game.world;
import eg.edu.alexu.csd.oop.game.Strategy;

public class Hard implements Strategy {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Hard.class);

	@Override
	public void chooseLevel() {
		// TODO Auto-generated method stub
		CircusOfPlates.getInstance().setCnt(3);
		logger.info("the level is hard");
	}

}
