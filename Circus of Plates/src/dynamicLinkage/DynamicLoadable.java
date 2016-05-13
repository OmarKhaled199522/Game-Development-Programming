package dynamicLinkage;


public abstract class DynamicLoadable {
	protected Environment environment;
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Environment.class);

	public void setEnvironment(String environment){
		Class<?> environ;
		try {
			environ = Class.forName(environment);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("class" + environment + "not found!");
		}
		if(Environment.class.isAssignableFrom(environ) ){
			try {
				this.environment = (Environment) environ.newInstance();
				logger.info("class loaded");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				logger.fatal(e);
				throw new RuntimeException("class can not instantiate!");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				logger.fatal(e);
				throw new RuntimeException("class can not instantiate!");
			}
		}else{
			logger.warn("class is not an environment");
		}
	}
	
	/*
	 * starts what the class must implement on the world
	 */
	public abstract void start();
}
