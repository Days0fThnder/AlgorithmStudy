package NodeLib;

/**
 * Created by j_rus on 10/21/2016.
 */
public class TestNodeLib {


    public static void main(String [] arg){
        LinkedListNode llnodeA = new LinkedListNode("A");
        LinkedListNode llnodeB = new LinkedListNode("B");
        LinkedListNode llnodeC = new LinkedListNode("C");
        LinkedListNode llnodeD = new LinkedListNode("D");
        LinkedListNode llnodeE = new LinkedListNode("E");

        llnodeA.setNext(llnodeB);
        llnodeB.setNext(llnodeC);
        llnodeC.setNext(llnodeD);
        llnodeD.setNext(llnodeE);

        /*LinkedList list = new LinkedList();
        list.reverseLinkedList(llnodeA);
        LinkedListNode kthNode = list.kthToLastNode(0, llnodeA);
        System.out.println(kthNode.value);
        System.out.println("place holder");*/
        System.out.print(0^0);
    }
}
