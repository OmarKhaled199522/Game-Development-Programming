package queue;

import eg.edu.alexu.csd.oop.game.object.MyObject;

public interface MyLinkedList {
	/**
	 * Inserts a specified element at the specified position in the list.
	 */
	 public void add(int index, MyObject element);
	
	 /** Inserts the specified element at the end of the list. */
	 public void add(MyObject element);
	
	 /** Returns the element at the specified position in this list. */
	 public MyObject get(int index);

	 /**
	 * Replaces the element at the specified position in this list with
	 * the specified element.
	 */
	 public void set(int index, MyObject element);
	
	 /** Removes all of the elements from this list. */
	 public void clear();
	
	 /** Returns true if this list contains no elements. */
	 public boolean isEmpty();
	
	 /** Removes the element at the specified position in this list. */
	 public void remove(int index);
	/** Returns the number of elements in this list. */
	 public int size();
	
	 /**
	 * Returns a view of the portion of this list between the specified
	 * fromIndex and toIndex, inclusively.
	 */
	 public MyLinkedList sublist(int fromIndex, int toIndex);
	
	 /**
	40 * Returns true if this list contains an element with the same value
	41 * as the specified element.
	42 */
	 public boolean contains(MyObject o);
	
}

