package eg.edu.alexu.csd.oop.game.world;

public class ScoreCalculator extends Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ScoreCalculator.class);
	private int score=0;
	
	
	public ScoreCalculator(Subject sub) {
		this.subject = sub;
		this.subject.attach(this);
	}

	public void update() {
		score++;
		CircusOfPlates.getInstance().setScore(score);
		logger.debug("score increse");
	}

}
