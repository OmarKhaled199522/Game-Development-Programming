package queue;

import java.io.Serializable;

import eg.edu.alexu.csd.oop.game.object.MyObject;

public class SingleLinkedList implements MyLinkedList , Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int size = 0;
	private Node head = null;
	private Node tail = null;

	
	@Override
	public void add(int index, MyObject element) {
		// TODO Auto-generated method stub
		if(index > size || index <0){System.out.println("Error"); return;}
		
		Node i = head;              //works as a reference counter 
		Node myNewNode = new Node();//the node to be added
		myNewNode.setValue(element); 
		
		if (index == 0){
			myNewNode.setNext(head);
			head = myNewNode; // tail won't change
			i = head;
		}
		else{
			for (int count = 0;count<index-1;count++){
				i= i.getNext();
			}
			myNewNode.setNext(i.getNext());
			i.setNext(myNewNode);
			
		}
		size++;
		
		while (i.getNext() != null)
			i=i.getNext(); 
		tail = i;
		
	}
	
	

	@Override
	public void add(MyObject element) {
		// TODO Auto-generated method stub
		Node newNode = new Node();
		newNode.setValue ( element);
		newNode.setNext ( null);
		if (tail != null)
		    tail.setNext ( newNode);
		else{
			head = newNode;
		}
		tail = newNode;

		size++;
		
	}

	@Override
	public MyObject get(int index) {
		// TODO Auto-generated method stub
		if (size <= 0) return null;
		if(index >= size || index < 0) {System.out.println("it's invalid index or the list is empty"); return null;}
		Node i = head;
		for (int count = 0; count <index;count++)
			i = i.getNext();
	//	System.out.println("the value = " + i.getValue());
		if (i == null) return null;
		return (MyObject) (i.getValue());
	}

	@Override
	public void set(int index,MyObject  element) {
		// TODO Auto-generated method stub
		if (head == null || index >= size || index < 0) return;
		Node i  = head;
		for (int j = 0 ;j<index;j++)
			i = i.getNext();
		i.setValue ( element);	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		head = null;tail=null;size=0;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null)return true;
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		if (head == null || index >= size || index <0) return;
		Node i =head;
		
		if (index == 0){
			head = i.getNext();
		}
		else{
			for (int j = 0 ;j < index-1;j++)
				i = i.getNext();
			Node z =i.getNext();
			i.setNext(z.getNext());
		}
		size--;
		
		
		while (i.getNext() != null)
			i= i .getNext();
		tail = i;	
	}

	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	
	
	@Override
	public MyLinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		 MyLinkedList t = new SingleLinkedList();
		if (fromIndex >=size || toIndex >= size || fromIndex < 0 || toIndex < 0 || toIndex < fromIndex){
			return t;
		}
		
		Node i = head;
		for (int j =0 ;j<fromIndex;j++ ){
			i=i.getNext();
		}
			
		for (int j =fromIndex ;j<=toIndex;j++ ){
			t.add(i.getValue());
			i = i.getNext(); 
		}
		//t.print();
		System.out.println();
		
		return t;
			
	}

	@Override
	public boolean contains(MyObject o) {
		// TODO Auto-generated method stub
		Node i = head;	
		while (i != null){
			if (i.getValue() == o) return true;
			i = i.getNext(); 		}
		return false;
	}



	public Node getHead() {
		return head;
	}

}
