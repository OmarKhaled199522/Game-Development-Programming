package eg.edu.alexu.csd.ds.maze.cs07;
public class Queue_linkedlist implements MyQueue{

	private Node head = null;
	private Node tail = null;
	private int queue_size = 0;
	
	
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	
	@Override
	public void enqueue(Object item) {
		
		Node n = new Node();
		n.setValue(item);;
		Node i = new Node();
		if(head == null){
			head = n;
			n.setPrev(head);
			n.setNext(tail);
			tail = n;
			queue_size++;
		
		} else {
			
			i = head;
			head = n;
			//n.prev = head;
			n.setNext(i);
			i.setPrev(n);
			queue_size++;
			
		}
		
	}

	@Override
	public Object dequeue() {
		
		Node i = tail;
		Node j;
		
		if(head == null){
			throw new NullPointerException();
		} else if (head == tail){
			i = head;
			head = null;
			tail = null;
			queue_size--;
			return i.getValue();
		
		} else {
			j = tail;
			i = tail.getPrev();
			i.setNext(null);
			tail.setPrev(null);
			tail = i;
			queue_size--;
			return j.getValue();
		}
	}

	@Override
	public boolean isEmpty() {
		if(head == null) return true;
		return false;
	}

	@Override
	public int size() {
		return queue_size;
	}

	
	
}
