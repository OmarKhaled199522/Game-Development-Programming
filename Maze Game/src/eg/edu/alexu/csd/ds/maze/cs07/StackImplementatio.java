package eg.edu.alexu.csd.ds.maze.cs07;

public class StackImplementatio implements MyStack{
	
	private int size = 0;
	private MyLinkedList myList = new SingleLinkedList();

	@Override
	public void add(int index, Object element) {
		
		myList.add(index, element);
		size= myList.size();
		
	}

	@Override
	public Object pop() {
		
		Object last = myList.get(0);
		myList.remove(0);
		size= myList.size();
		return last;
	}

	@Override
	public Object peek() {
		
		 if (size == 0) return null;
		Object p = myList.get(0);
		
		return p ;
	}

	@Override
	public void push(Object element) {
		
		myList.add(0,element);
		size = myList.size();
		
	}

	@Override
	public boolean isEmpty() {
		
		if (myList.isEmpty())
			return true;
		return false;
	}

	@Override
	public int size() {
		
		return size;
	}

}
