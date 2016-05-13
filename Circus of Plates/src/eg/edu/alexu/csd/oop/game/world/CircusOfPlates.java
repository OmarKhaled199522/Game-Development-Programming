package eg.edu.alexu.csd.oop.game.world;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import queue.LinkedListQueue;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.object.Background;
import eg.edu.alexu.csd.oop.game.object.Clown;
import eg.edu.alexu.csd.oop.game.object.ClownStack;
import eg.edu.alexu.csd.oop.game.object.Line;
import eg.edu.alexu.csd.oop.game.object.MyObject;
import eg.edu.alexu.csd.oop.game.state.State;
import eg.edu.alexu.csd.oop.game.state.StateEngine;

public class CircusOfPlates implements World , Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static CircusOfPlates instance = null;

	private int score = 0;
	private List<GameObject> constant = new LinkedList<GameObject>();
	private List<GameObject> moving = new LinkedList<GameObject>();
	private List<GameObject> control = new LinkedList<GameObject>();
	private int width = 700, height = 600;
	private LinkedListQueue lift = new LinkedListQueue();
	private LinkedListQueue right = new LinkedListQueue();
	private List<MyObject> fall = new LinkedList<MyObject>();
	private StateEngine obj = new StateEngine();
	private State state;
	private boolean stateChangedFlag = false;
	private String stateName = "";
	private int speed;
	private int numberoClown;
	private final int maxCircle = 20;
	private int circle = 0;
	private int lives;
	private boolean roll = true;
	private Subject sub = new Subject();
	@SuppressWarnings("unused")
	private ScoreCalculator scoreObject ;
	
	private RandomShapes random = new RandomShapes();
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CircusOfPlates.class);
	private CircusOfPlates() { 
		scoreObject = new ScoreCalculator(sub);
		logger.info("circus is created");
		Line line = new Line();
		line.setX(0);
		line.setY(30);
		constant.add(new Background());
		constant.add(line);
		line = new Line();
		line.setX(width - line.getWidth());
		line.setY(30);
		constant.add(line);	
		/*
		logger.debug("");
		logger.info("");
		logger.warn("");
		logger.fatal("");
		*/
		for (int i = 4; i >= 0; i--) {
			MyObject object = random.getRandomShape();
			object.setX(i * object.getWidth());
			object.setY(25);
			lift.enqueue(object);
			moving.add(object);
		}
		for (int i = 5; i > 0; i--) {
			MyObject object = random.getRandomShape();
			object.setX(width - i * object.getWidth());
			object.setY(25);
			right.enqueue(object);
			moving.add(object);
		}

	}

	public static CircusOfPlates getInstance() {
		if (instance == null) {
			instance = new CircusOfPlates();
		}
		return instance;
	}

	public static void destroy() {
		instance = null;
	}

	@Override
	public List<GameObject> getConstantObjects() {
		return constant;
	}

	@Override
	public List<GameObject> getMovableObjects() {
		return moving;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		return control;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean refresh() {
		obj.update(score, lives);
		state = obj.getState();
		String str = state.toString();
		if(! stateName.equals(str)){
			stateName = state.toString();
			stateChangedFlag = true;
		}
		
		boolean status = state.getStatus();
		if(stateChangedFlag){
			LinkedList<GameObject> list = state.getObjects();
			if(list != null){
				moving.clear();
				moving.addAll(list);
			}
			stateChangedFlag = false;
		}

		if(status){
			update();
			for (int k = 0; k < fall.size(); k++) { // loop for plates
				MyObject object = (MyObject) fall.get(k);
				object.setY(object.getY() + speed); // plate is fall with speed
				if (object.getY() > height) {
					fall.remove(object);
					moving.remove(object);
					lives--;
					logger.info("lives  is decrised");
					continue;
				} // out of frame
				for (int j = 0; j < numberoClown; j++) { // loop for clowns one
															// clown Currently
					GameObject clown = (Clown) control.get(j);
					int x = clown.getX();
					ClownStack stack = null;
					if (object.getX() + object.getWidth() / 2 < (x + clown
							.getWidth())
							&& object.getX() + object.getWidth() / 2 > (x
									+ clown.getWidth() - 30)) { // rang which clown
																// can catch plates
																// Stack 1
						if ((object.getY() < ((Clown) clown).getRight().getY()
								- ((Clown) clown).getRight().getHeight() + speed)
								&& object.getY() > ((Clown) clown).getRight().getY()
										- ((Clown) clown).getRight().getHeight() - speed) {
							object.setY(((Clown) clown).getRight().getY()
									- ((Clown) clown).getRight().getHeight());
							moving.remove(object);
							fall.remove(object);
							stack = ((Clown) clown).getRight();
							logger.debug("clown catch plate in right Stack");
						}
					} else if (object.getX() + object.getWidth() / 2 > x
							&& object.getX() + object.getWidth() / 2 < x + 30) { // rang
																					// which
																					// clown
																					// can
																					// catch
																					// plates
																					// Stack
																					// 2
						if ((object.getY() < ((Clown) clown).getLift().getY()
								- ((Clown) clown).getLift().getHeight() + speed)
								&& object.getY() > ((Clown) clown).getLift().getY()
										- ((Clown) clown).getLift().getHeight() - speed) {
							
							object.setY(((Clown) clown).getLift().getY()
									- ((Clown) clown).getLift().getHeight());
							moving.remove(object);
							fall.remove(object);
							stack = ((Clown) clown).getLift();
							logger.debug("clown catch plate in lift Stack");
						}
					}
					if (stack != null) { // if stack == null that mean clown
											// coundn't catch plate
											// else stack == stack which Caught
											// plate
						if (stack.size() >= 2) { // 3 for goal
							logger.debug(stack.peek().getType() + object.getType());
							if ((stack.peek().getType().equals(object.getType()))) { // type
																				// is
																				// String
								
																				// like
																				// "green plate"
								MyObject o = stack.pop(); // plate == first plate in
															// stack
								if (stack.peek().getType().equals(object.getType())) { // plate
																					// ==
																					// second
																					// plate
																					// in
									
								
								sub.notifyAllObservers();
								control.remove(o); // remove first plate from
								// control
		                     	control.remove(stack.pop()); // remove second
											// plate from
											// control// stack
		                     	logger.debug("remove object from control");
								
								} else {
									stack.add(o); // if type != second plate in
													// stack
									stack.add(object);
									control.add(object);
								}
							} else {
								stack.add(object);
								control.add(object);
							}
						} else {
							stack.add(object); // if type != first plate in stack
							control.add(object);
						}
					}
				}
			}
		}
		else{
			Iterator<GameObject> it = moving.iterator();
			GameObject tempObject = it.next();
			while(it.hasNext()){
				tempObject = it.next();
				tempObject.setY(tempObject.getY() + 1);
			}
		}
		return status;
	}

	@Override
	public String getStatus() {
		return "Please Use Arrows To Move   |   Score=" + score + " |   lives="
				+ lives; // update status
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return 10;
	}

	public void setCnt(int level) {
		if (level == 1) {
			speed = 5;
			numberoClown = 1;
			lives = 20;
		}
		if (level == 2) {
			speed = 10;
			numberoClown = 2;
			lives = 10;
		}
		if (level == 3) {
			speed = 30;
			numberoClown = 2;
			lives = 5;
		}
		logger.debug("level is choosed");
		int d = width / numberoClown;
		for (int i = 0; i < numberoClown; i++) {
			Clown clown = new Clown(i * d - 50, (i + 1) * d - 50, 450); // add
																		// clown
			clown.setX((i + 1) * d - d / 2);
			clown.setY(450);
			control.add(clown);
		}
	}

	private void update() {
		circle++;
		if (circle == maxCircle) {

			circle = 0;

			MyObject object = random.getRandomShape();

			if (roll) {
				// lift bar
				Iterator<MyObject> iterator = lift.iterator();
				while (iterator.hasNext()) {
					MyObject o = iterator.next();
					o.setX(o.getX() + 30);
				}

				MyObject fallObject = lift.dequeue();
				fall.add(fallObject);

				object.setX(0);
				object.setY(25);
				lift.enqueue(object);
				moving.add(object);
				roll = false;
			} else {
				// right bar
				Iterator<MyObject> iterator = right.iterator();
				while (iterator.hasNext()) {
					MyObject o = iterator.next();
					o.setX(o.getX() - 30);
				}
				MyObject fallObject = right.dequeue();
				fallObject.setX(fallObject.getX());
				fall.add(fallObject);
				object.setX(width - 30);
				object.setY(25);
				right.enqueue(object);
				moving.add(object);
				roll = true;
			}

		}

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	

}
