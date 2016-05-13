package queue;

import java.io.Serializable;
import java.util.Iterator;

import eg.edu.alexu.csd.oop.game.object.MyObject;
import eg.edu.alexu.csd.oop.game.world.CircusOfPlates;
import queue.MyQueue;

public class LinkedListQueue implements MyQueue ,Iterable<MyObject> , Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public class MyIterator implements Iterator<MyObject>{
		private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MyIterator.class);
		int index = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (index == size)
				return false;
			logger.debug("there is a next in the game");
			return true;
		}

		@Override
		public MyObject next() {
			// TODO Auto-generated method stub
			//System.out.println(head.getValue());
			if (size <= 0) return null;
			if(index >= size || index < 0) { logger.debug("index is error");return null;}
			Node i = list.getHead();
			for (int count = 0; count <index;count++)
				i = i.getNext();
			if (i == null) return null;
			index++;
			logger.info("there is a next found");
			return (MyObject) (i.getValue());

		}

		
	}
	 int size = 0;
	private SingleLinkedList list = new SingleLinkedList();
	@Override
	public void enqueue(MyObject item) {
		// TODO Auto-generated method stub
		list.add(item);
		size++;

	}

	@Override
	public MyObject dequeue() {
		// TODO Auto-generated method stub
		MyObject removed = list.get(0);
		if (removed == null) throw new ArrayIndexOutOfBoundsException();
		else{
			list.remove(0);
			size--;
		
		return removed;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}


	@Override
	public Iterator<MyObject> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}

}
