package NodeLib;

public class DoublyLinkedListNode {
	public DoublyLinkedListNode next;
	public DoublyLinkedListNode prev;
	public DoublyLinkedListNode last;
	public int data;
	public DoublyLinkedListNode(int d, DoublyLinkedListNode n, DoublyLinkedListNode p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	public DoublyLinkedListNode(int d) {
		data = d;
	}	
	
	public DoublyLinkedListNode() { }

	public void setNext(DoublyLinkedListNode n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(DoublyLinkedListNode p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}	
	
	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}
	
	public DoublyLinkedListNode clone() {
		DoublyLinkedListNode next2 = null;
		if (next != null) {
			next2 = next.clone();
		}
		DoublyLinkedListNode head2 = new DoublyLinkedListNode(data, next2, null);
		return head2;
	}
}
