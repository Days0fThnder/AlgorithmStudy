package Sandbox;

import NodeLib.LinkedListNode;

/**
 * Created by j_rus on 6/27/2017.
 */
public class Sandbox23 {

    class LinkedListNode {

        public String value;
        public LinkedListNode next;

        public LinkedListNode(String value) {
            this.value = value;
        }
    }

    static LinkedListNode kthToLastNode(int k, LinkedListNode head){
        if (head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        LinkedListNode current = head;
        int len = 1;

        while(current.next != null){
            len++;
            current = current.next;
        }
        int target = (len-k)+1;
        current = head;
        len = 1;
        while(current.next != null){
            if(len == target){
                return current;
            }
            len++;
            current = current.next;
        }
        return current;
    }

    public static void main(String [] arg){
        Sandbox23 sb23 = new Sandbox23();
        Sandbox23.LinkedListNode a = sb23.new LinkedListNode("Angel Food");
        Sandbox23.LinkedListNode b = sb23.new LinkedListNode("Bundt");
        Sandbox23.LinkedListNode c = sb23.new LinkedListNode("Cheese");
        Sandbox23.LinkedListNode d = sb23.new LinkedListNode("Devil's Food");
        Sandbox23.LinkedListNode e = sb23.new LinkedListNode("Eccles");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        kthToLastNode(5, a);
    }
}
