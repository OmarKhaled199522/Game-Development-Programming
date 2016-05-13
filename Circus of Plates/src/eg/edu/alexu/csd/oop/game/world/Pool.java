package eg.edu.alexu.csd.oop.game.world;

import eg.edu.alexu.csd.oop.game.object.FlyWeight;
import java.util.HashMap;

public class Pool {

	private HashMap<String , FlyWeight> shapeByString = new HashMap <String, FlyWeight>(); 
	private FlyWeight fly;
	
	
	public void setMap(String key){
		
		fly = new FlyWeight(key , 30, 40);
		shapeByString.put(key , fly);
	}
	
	public Object getMap(String key){
		fly = shapeByString.get(key);
		if(fly == null){
			fly = new FlyWeight(key , 30, 40);
		}
		return shapeByString.get(key);
	}
	
}