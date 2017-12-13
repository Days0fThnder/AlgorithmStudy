package Sandbox;

import nodes.ListNode;

import java.util.List;

public class Sandbox33 {

    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

        ListNode<Integer> head = l;
        ListNode<Integer> previous;
        ListNode<Integer> current = head;

        while (current != null) {

            if (current.next!= null && current.next.value == k ) {
                previous = current;
                current = current.next;
                if (current.value == k && current.next.value != k) {
                    previous.next = current.next;
                }else if(current.next.value == k){
                    previous.next = getNextLegalNode(current.next, k);
                    current = previous.next;
                } else {
                    previous.next = null;
                }
            }else if (current.value == k && current.next != null) {
                previous = current;
                current = current.next;
                previous.next = null;
            }
            else {
                current = current.next;
            }

            if (head.value == k) {
                head = current;
            }
        }

        return head;
    }

    private ListNode<Integer> getNextLegalNode(ListNode<Integer> next, int k) {
        while (next != null && next.value == k){
            next = next.next;
        }

        return next;
    }

    public static void main(String [] arg){
        Sandbox33 sb33 = new Sandbox33();
        ListNode<Integer> listNode = new ListNode<>(1);
        listNode.addNode(new ListNode<>(2));
        listNode.addNode(new ListNode<>(3));
        listNode.addNode(new ListNode<>(3));
        listNode.addNode(new ListNode<>(4));
        //listNode.addNode(new ListNode<>(3));
        System.out.println("test");

        sb33.removeKFromList(listNode, 3);
    }


}
