package hackerRank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by j_rus on 4/3/2017.
 */
public class levelOrderTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }



    void LevelOrder(Node root)
    {
        LinkedList<Node> nodes = new LinkedList<>();

        if( root != null){
            nodes.add(root);
        }

        while(nodes.peekFirst() != null) {
            Node current = nodes.poll();
            System.out.print(current.data +"");
            if(current.left != null){
                nodes.add(current.left);
            }
            if(current.right != null){
                nodes.add(current.right);
            }
        }

    }
}
