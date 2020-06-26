package leetCode;

public class ListNode {
      public int val;
      public ListNode next;
      String msg;
      public ListNode(){
            msg = "empty ListNode";
      }
      ListNode(int x) { val = x; }

      public static ListNode buildList(int [] arr){
            if(arr.length == 0)
                  return new ListNode();
            ListNode head = new ListNode(arr[0]);
            ListNode current = head;
            //head.next = current;

            for (int i = 1; i < arr.length; i++) {
                  current.next = new ListNode(arr[i]);
                  current = current.next;
            }

            return head;
      }

      public void printList(){
            ListNode head = this;
            while (head != null) {
                  System.out.print(head.toString());
                  head = head.next;
                  if(head != null){
                        System.out.print(", ");
                  }
            }
      }

      public static int listSize(ListNode head){
            int res = 0;
            while (head != null){
                  res++;
                  head = head.next;
            }
            return res;
      }

      @Override
      public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
      }
}
