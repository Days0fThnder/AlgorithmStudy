package NodeLib;

import leetCode.ListNode;

public class LinkedListSolutions {


    public ListNode findMiddleNode(ListNode head){
        if(head == null)
            return new ListNode();

        if(head.next == null){
            return head;
        }

        ListNode fastNode = head.next.next;
        ListNode slowNode = head;

        while(fastNode != null){
            slowNode = slowNode.next;

            if(fastNode.next == null){
                return slowNode;
            }else{
                fastNode = fastNode.next.next;
            }
        }

        return slowNode;
    }

    public static void main(String [] args){
        ListNode listNode = new ListNode();
        int[] arr = {1,2,3,4,5};
        ListNode head = listNode.buildList(arr);
        LinkedListSolutions linkedListSolutions = new LinkedListSolutions();
        linkedListSolutions.findMiddleNode(head);
    }
}
