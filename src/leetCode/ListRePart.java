package leetCode;

public class ListRePart {

    public ListNode partition(ListNode head, int x) {

        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        ListNode current = head;

        ListNode before = beforeHead;

        ListNode after = afterHead;



        while(current != null){
            if(current.val < x){
                before.next = new ListNode(current.val);
                before = before.next;
            }else{
                after.next = new ListNode(current.val);
                after = after.next;
            }

            current = current.next;

        }

        before.next = afterHead.next;

        return beforeHead.next;
    }

    public static void main(String args []){
        ListRePart listRePart = new ListRePart();
        int [] arr = {5,1,8,0,3};
        ListNode listNode = new ListNode().buildList(arr);
        //listNode
        listRePart.partition(listNode, 3);
    }
}
