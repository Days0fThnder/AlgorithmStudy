package leetCode;

public class AddTwoNumbersSol {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null){
            return new ListNode(0);
        }

        ListNode result = new ListNode(0);
        ListNode c1 = l1; ListNode c2 = l2;
        ListNode resCurr = result.next = new ListNode(0);
        int carr = 0;
        int res = 0;
        while(c1 != null || c2 != null){
            resCurr.next = new ListNode(0);
            int val1 = 0; int val2 = 0;

            if(c1 != null){
                val1 = c1.val;
                c1 = c1.next;
            }

            if(c2 != null){
                val2 = c2.val;
                c2 = c2.next;
            }

            res = add(val1, val2, carr);

            if(res > 9){
                carr = 1;
                resCurr.val = (res%10);
            }else{
                carr = 0;
                resCurr.val = res;
            }
            if(c1 != null || c2 != null){
                resCurr.next = new ListNode(0);
            }
            resCurr = resCurr.next;
        }



        if(res > 9){
            resCurr = new ListNode(res/10);
        }


        return result.next;

    }

    private int add(int a, int b, int c){
        return a+b+c;
    }

    public static void main(String [] args){
        AddTwoNumbersSol addTwoNumbersSol = new AddTwoNumbersSol();
        ListNode l1 = new ListNode(2);
        ListNode l2 = l1.next = new ListNode(4);
       // ListNode l3 = l2.next = new ListNode(3);

        ListNode l1A = new ListNode(5);
        ListNode l2A = l1A.next = new ListNode(6);
      //  ListNode l3A = l2A.next = new ListNode(4);

        addTwoNumbersSol.addTwoNumbers(l1, l1A);
    }
}
