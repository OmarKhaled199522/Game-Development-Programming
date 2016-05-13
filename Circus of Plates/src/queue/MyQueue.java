package queue;

import eg.edu.alexu.csd.oop.game.object.MyObject;

public interface MyQueue {

	/**
	 * Inserts an item at the queue front.
	 */
	public void enqueue(MyObject item);

	/**
	 * Removes the object at the queue rear and returns it.
	 */
	public MyObject dequeue();

	/**
	 * Tests if this queue is empty.
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in the queue
	 */
	public int size();

}
