package NodeLib;

/**
 * Created by j_rus on 10/21/2016.
 */
public class LinkedListNode {

    public Object value;
    public LinkedListNode next;

    public LinkedListNode(Object value){
        this.value = value;
    }

    public void setNext(LinkedListNode node){
        this.next = node;
    }
}
