package plugin;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;



public class ClassFinder {
	
    private  final  String CLASS = ".class";
    private  final  String JAR = ".jar";
    public   List<Class<?>> myClasses = null;

	
    public ClassFinder(){
		myClasses = new LinkedList<Class<?>>();
		myClasses.addAll(findJar());
	}



	
	public  List<Class<?>> getClassesImplementingInterface(Class<?> myInterface) throws ClassNotFoundException{
		List<Class<?>> listClasses = new ArrayList<Class<?>>();
		for(Class<?> c : myClasses){
			Class<?>[] interfaces = c.getInterfaces();
			for(Class<?> myClass : interfaces){
				if(myClass == myInterface ){
					listClasses.add(c);
				}
			}
		}
		return listClasses;	
	}

    
	
	
/*******************************************search**************************************************/
	
	///*********************************search in jar**************************************////

	
	private  Set<Class<?>> findJar() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        String[] paths = System.getProperty("java.class.path").split(System.getProperty("path.separator"));
        for(String path : paths){
        	if(path.endsWith(JAR)){
        		try{
            		classes.addAll(getJarClasses(path));
            	}catch(Exception e){}
        	}
        }
        return classes;
    }
	
	
	
	private   Set<Class<?>> getJarClasses(String path){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		JarFile jarFile;
		try {
			jarFile = new JarFile(path);
			Enumeration<?> e = jarFile.entries();
			while (e.hasMoreElements()) {
				JarEntry je = (JarEntry) e.nextElement();
			    if(je.isDirectory() || !je.getName().endsWith(CLASS)){
			    	continue;
			    }
			    String className = je.getName().substring(0,je.getName().length()- CLASS.length());
			    className = className.replace("/", ".");
			    Class<?> clazz= Class.forName(className);  
			    classes.add(clazz);
			}
		}catch (Throwable  e1) {
		}
		return classes;
	}

}
