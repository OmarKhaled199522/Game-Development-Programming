package eg.edu.alexu.csd.oop.game.world;


import eg.edu.alexu.csd.oop.game.object.FlyWeight;
import eg.edu.alexu.csd.oop.game.object.MyObject;

public class RandomShapes {
	
	private FlyWeight obj;
	private Pool pool = new Pool();
	
	
	public FlyWeight getFly(){
		return obj;
	}
	
	public MyObject getRandomShape(){
		
		int index = (int) (Math.random() * ( 2 - 0 )); 
		int index2 = 0;
		String [] myList = {"plate", "rectangle"};
		String colors [] = {"blue","green", "red"}; // 3
		String colors2 [] = {"orange", "pinkk", "purple", "yellow"}; // 4
	 	

	 	
		if(index == 0){
		
			index2 = (int) (Math.random() * (3 - 0 )); 
			obj = (FlyWeight) pool.getMap(colors[index2]);
			pool.setMap(colors[index2]);
			
		
		} else if (index == 1){
			
			index2 = (int) (Math.random() * (4 - 0 )); 
			obj = (FlyWeight) pool.getMap(colors2[index2]);
			pool.setMap(colors2[index2]);
		}
		
		Factory factory = new Factory();
		
		return factory.getShape(myList[index]);
	}
}