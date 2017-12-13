package leetCode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode copyHead = head;

        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            len++;
        }

        copyHead.next = head;

        for (int i = len - k % len; i > 1; i--)
            head = head.next;

        copyHead = head.next;
        head.next = null;

        return copyHead;
    }

    public static void main(String [] arg){
        ListNode l1 = new ListNode(1);
        ListNode l2 = l1.next = new ListNode(2);
        RotateList rl = new RotateList();
        rl.rotateRight(l1, 2);
    }
}
