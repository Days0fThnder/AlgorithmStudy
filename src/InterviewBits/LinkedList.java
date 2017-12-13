package InterviewBits;

import NodeLib.ListNode;

public class LinkedList {


    public ListNode reorderList(ListNode a) {

        ListNode firstN = a;
        ListNode firstHalf = a;
        ListNode lastHalf = a;
        ListNode curr = a;
        ListNode prev = null;
        int size = 0;
        int half = 0;
        if(curr != null){
            size++;
        }

        while (curr.next != null){
            size++;
            curr = curr.next;
        }

        curr = a; half = (size/2)+1; int track = 1;

        while( track <= half){
            curr = curr.next;
            track++;
            if (track == half){
                firstHalf = curr;
                lastHalf = curr.next;
                firstHalf.next = null;
            }
        }
        ListNode travelN = lastHalf;
        while( travelN != null){
            ListNode next = travelN.next;
            ListNode current = travelN;
            current.next = prev;
            prev = current;
            if(next != null) {
                travelN = next;
            }else{
                lastHalf = travelN;
                travelN = null;
            }
        }

        while( firstN != null && lastHalf != null){
            ListNode tempLast = lastHalf.next;
            ListNode tempFirst = firstN.next;
            firstN.next = lastHalf;
            lastHalf.next = tempFirst;
            firstN = tempFirst;
            lastHalf = tempLast;
        }

        return a;
    }


    public ListNode<Integer> rotateRight(ListNode a, int b){

        if(b == 0){
            return a;
        }
        ListNode<Integer> nStart = null;
        ListNode<Integer> curr = a;
        ListNode<Integer> nEnd = null;
        int listSize = 1;
        while(curr.next != null){
            listSize++;
            curr = curr.next;
        }
        curr = a;
        int stepCount = 0;
        int test = (listSize-b)%listSize;
        while(curr != null){
            if(stepCount == test){
                nEnd = curr;
                if(nEnd.next != null){
                    nStart = nEnd.next;
                    nEnd.next = null;
                }else{
                    return a;
                }
                break;
            }
            curr = curr.next;
            if(curr == null){
                curr = a;
                stepCount = 0;
            }else{
                stepCount++;
            }
        }
        ListNode<Integer> nCurr = nStart;
        if(nCurr.next != null){
            while(nCurr.next != null){
                nCurr = nCurr.next;
                if(nCurr.next == null){
                    nCurr.next = a;
                    break;
                }
            }
        }else{
            nCurr.next = a;
        }

        return nStart;
    }
    public int lPalin(ListNode A) {

        int size = 0;
        ListNode curr = A;
        ListNode halfN = null;
        if(A != null){
            size++;
        }

        while(curr.next != null){
            size++;
            curr = curr.next;
        }

        int half = (size/2) + 1;
        int track = 1;
        curr = A;

        while(track <= half){
            if(track == half){
                halfN = curr;
            }else{
                curr = curr.next;
            }
            track++;
        }

        ListNode lastHalf = halfN.next;
        ListNode travel = lastHalf;
        ListNode prev = null;

        while(travel != null){
            ListNode next = travel.next;
            ListNode current = travel;

            current.next = prev;
            prev = current;
            travel = next;
        }

        lastHalf = prev;
        while(lastHalf != null){
            if(A.value != lastHalf.value){
                return 1;
            }
            A = A.next; lastHalf = lastHalf.next;
        }
        return 0;
    }

    public ListNode addTwoNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> c = new ListNode<>(0);
        ListNode<Integer> cTemp = new ListNode<>(0);
        ListNode<Integer> rootC;
        boolean isRoot = true;
        while(a != null || b != null){
            if(a != null && b != null){
                cTemp.value = a.value + b.value;
                if(cTemp.value > 9) {
                    handleTwoDigits(a, b, cTemp);
                }
            } else if(a != null){
                cTemp.value = a.value;
                if(cTemp.value > 9) {
                    handleTwoDigits(a, b, cTemp);
                }
            } else if(b != null){
                cTemp.value = b.value;
                if(cTemp.value > 9) {
                    handleTwoDigits(a, b, cTemp);
                }
            }
            if(a != null)
                a = a.next;
            if(b != null)
                b = b.next;

            if(isRoot){
                c = new ListNode<>(cTemp.value);
                isRoot = false;
            }else{
                addLast(cTemp, c);
            }

            if(a != null || b != null){
                cTemp.next = new ListNode<>(0);
                cTemp = cTemp.next;
            }
        }

        return c;
    }

    public void addLast(ListNode<Integer> d, ListNode<Integer> first) {
        ListNode<Integer> last = new ListNode<>(0);
        last.value = d.value;

        ListNode<Integer> node = first;
        if (first == null) {
            first = last;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = last;
        }
    }

    private void handleTwoDigits(ListNode<Integer> a, ListNode<Integer> b, ListNode<Integer> c){
        if(c.value > 9) {
            c.value = c.value % 10;
            if (a.next != null) {
                a.next.value += 1;
            } else if (b.next != null) {
                b.next.value += 1;
            } else {
                c.next = new ListNode<>(1);
            }
        }
    }

    public static void main(String args[]){
        ListNode<Integer> one = new ListNode<>(1);
        ListNode<Integer> two = new ListNode<>(2);
        ListNode<Integer> three = new ListNode<>(3);
        ListNode<Integer> four = new ListNode<>(4);
        ListNode<Integer> five = new ListNode<>(5);
        ListNode<Integer> six = new ListNode<>(6);
        //ListNode<Integer> seven = new ListNode<>(7);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next= six;
        //six.next = seven;*/

        ListNode<Integer> oneP = new ListNode<>(1);
        ListNode<Integer> twoP = new ListNode<>(2);
        ListNode<Integer> threeP = new ListNode<>(3);

        //oneP.next = twoP;
        //twoP.next = threeP;

        LinkedList ll = new LinkedList();
        //ll.addTwoNumbers(one, oneP);
        ll.rotateRight(one, 90);
    }
}
