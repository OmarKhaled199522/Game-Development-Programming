package eg.edu.alexu.csd.oop.game.world;
import eg.edu.alexu.csd.oop.game.Strategy;

public class Easy implements Strategy {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Easy.class);

	@Override
	public void chooseLevel() {
		// TODO Auto-generated method stub
		 CircusOfPlates.getInstance().setCnt(1);
		 logger.info("the level is easy");

	}

}
