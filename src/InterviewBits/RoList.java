package InterviewBits;

import leetCode.ListNode;

public class RoList {

    public ListNode RotateList(ListNode head, int k){
        if(head == null){
            return new ListNode();
        }

        if(head.next == null){
            return head;
        }

        int size = ListNode.listSize(head);
        ListNode rotateHead = getNewHead(head,size,k);
        ListNode curr = rotateHead;

        while(curr != null && curr.next != null){
            curr = curr.next;
        }

        curr.next = head;
        return rotateHead;
    }

    private ListNode getNewHead(ListNode head, int s, int k) {
        ListNode res = head;
        while (head != null){
            if(s == (k+1)){
                res = head.next;
                head.next = null;
                break;
            }
            head = head.next; s--;
        }
        return res;
    }

    public static void main(String [] args){
        RoList roList = new RoList();
        int [] arr = {1,2,3,4,5};
        ListNode head = ListNode.buildList(arr);
        roList.RotateList(head, 2);
    }
}
