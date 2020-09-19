package leetCode;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {

        if(head == null){
            return null;
        }

        if(head.next == null || head.next.next == null){
            return head;
        }

        ListNode second = head.next;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode prev = null;
        int count = 1;

        while(curr != null){
            count++;
            curr.next = next.next;
            prev = curr;
            curr = next;
            next = next.next;

            if(curr.next == null){
                if(count % 2 == 0){
                    prev.next = second;
                }else{
                    curr.next = second;
                }
                curr = null;
            }
        }


        return head;
    }

    public static void main(String [] args){
        int [] arr = {1,2,3,4,5};
        ListNode list = ListNode.buildList(arr);
        oddEvenList(list);
    }
}
