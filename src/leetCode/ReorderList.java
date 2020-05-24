package leetCode;

public class ReorderList {

    public void reorderList(ListNode head) {

        if(head == null){
            return;
        }

        ListNode secondHalf = beakListInHalf(head);
        ListNode fistHalf = head;
        ListNode revHalf = reverseList(secondHalf);

        ListNode firstHalfNext;
        ListNode secondHalfNext;
        while(fistHalf != null && revHalf != null){
            firstHalfNext = fistHalf.next;
            secondHalfNext = revHalf.next;

            fistHalf.next = revHalf;
            fistHalf = firstHalfNext;

            revHalf.next = fistHalf;
            revHalf = secondHalfNext;
        }

    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null)
                next = next.next;
        }

        return prev;
    }

    private ListNode beakListInHalf(ListNode head){
        if(head == null)
            return new ListNode();
        if(head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null){
            if(slow.next != null){
                slow = slow.next;
            }
            if(fast.next != null) {
                fast = fast.next.next;
            }else{
                fast = null;
            }

        }

        ListNode secondHalfHead = slow.next;
        slow.next = null;

        return secondHalfHead;
    }

    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        ListNode head = ListNode.buildList(arr);
        ReorderList list = new ReorderList();
        list.reorderList(head);
        head.printList();
    }
}
