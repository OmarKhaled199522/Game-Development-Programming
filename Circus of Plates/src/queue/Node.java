package queue;

import java.io.Serializable;

import eg.edu.alexu.csd.oop.game.object.MyObject;


public class Node implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyObject value;
	private Node next;
	private Node prev;
	
	public MyObject getValue() {
		return value;
	}
	public void setValue(MyObject value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
	