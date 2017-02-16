package NodeLib;

/**
 * Created by j_rus on 10/21/2016.
 */
public class LinkedList {

    public void reverseLinkedList(LinkedListNode head){
        LinkedListNode current = head;
        LinkedListNode prev = null, next = null;

        while(current != null){
            next = current.next;
            if(current == head){
                current.next = null;
            }else {
                current.next = prev;
            }

            prev = current;
            current = next;
            next = next.next;
            if(next != null){
                current.next = prev;
                prev = current;
                current = next;
            }else{
                current.next = prev;
                current = null;
            }
        }
    }

    private void reverseLinkedList(LinkedListNode prev, LinkedListNode current, LinkedListNode next){
        prev = current;
        current = next;
        next = next.next;
        if(next != null){
            current.next = prev;
            current = next;
            prev = current;
        }else{
            current.next = prev;
            current = null;
        }
    }

    public LinkedListNode kthToLastNode(int k, LinkedListNode head){
        int index = 0;
        LinkedListNode current = head;
        if(k <= 0 || head == null){
            throw new IllegalArgumentException("Impossible to find less than first to last node: " + k);
        }else{
            index = 1;
        }

        if(head.next == null){
            return head;
        }

        while(current.next != null){
            current = current.next;
            index++;
        }
        if(k==1){
            return current;
        }else{
            current = head;
        }
        for(int i = 1; i<=index; i++){
            if(i == ((index - k) + 1)){
                return current;
            }else{
                current = current.next;
            }
        }
        return current;
    }
}
