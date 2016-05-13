package dynamicLinkage;

import javax.swing.JFrame;


public class GameDynamicLoadable extends DynamicLoadable{
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Environment.class);

	@Override
	public void start() {
		// TODO Auto-generated method stub
		JFrame envFrame = environment.getFrame();
		RunningThread rt = new RunningThread(environment);
		Thread th;
		if(envFrame != null){
			//display frame after creating new thread for it
			environment.displayFrame();
		}
		th = new Thread(rt);
		th.start();
		// end the frame thread if possible
		logger.debug("loading start ended");
	}
	
}
