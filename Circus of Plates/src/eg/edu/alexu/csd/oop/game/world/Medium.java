package eg.edu.alexu.csd.oop.game.world;
import eg.edu.alexu.csd.oop.game.Strategy;

public class Medium implements Strategy {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Medium.class);

	@Override
	public void chooseLevel() {
		// TODO Auto-generated method stub
		CircusOfPlates.getInstance().setCnt(2);
		logger.info("the level is medium");
	}

}
