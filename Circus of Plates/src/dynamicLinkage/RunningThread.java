package dynamicLinkage;

import eg.edu.alexu.csd.oop.game.GameEngine;

public class RunningThread implements Runnable{
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Environment.class);
	private Environment environment;
	
	public RunningThread(Environment environment) {
		// TODO Auto-generated constructor stub
		this.environment = environment;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!environment.isSet()){
			try {
				logger.debug("environment not set");
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				logger.fatal(e);
				throw new RuntimeException();
			}
		}
		GameEngine.start(environment.getClass().getName() + "game" , environment.getWorld());
		logger.info("environment loaded");
	}
}
