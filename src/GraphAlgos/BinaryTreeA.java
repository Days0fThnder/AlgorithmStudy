package GraphAlgos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j_rus on 1/16/2017.
 */
public class BinaryTreeA {

    class Node{
        private Node left;
        private Node right;
        private boolean shouldDelete;
        private String value;

        public Node(String value, Node left, Node right, boolean shouldDelete){
            this.value = value;
            this.left = left;
            this.right = right;
            this.shouldDelete = shouldDelete;
        }
    }

    List<Node> results = new ArrayList<>();

    public void pruneTree(Node node, Node parent){

        if(node != null){
            if(node.shouldDelete) {
                removeConnection(node, parent);
                if (node.left != null || node.right != null) {
                    pruneTree(node.left, node);
                    pruneTree(node.right, node);
                    node.left = null;
                    node.right = null;
                }
            }
            else if (!node.shouldDelete){
                pruneTree(node.left, node);
                pruneTree(node.right, node);
                results.add(node);
            }
        }
    }

    private void removeConnection(Node node, Node parent){

        if(parent != null) {
            if (parent.left == node){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
    }

    public static void main(String [] arg){
        BinaryTreeA BA = new BinaryTreeA();
        Node nodeE = BA.new Node("e", null, null, true);
        Node nodeG = BA.new Node("g", null, null, true);
        Node nodeF = BA.new Node("f", null, null, true);
        Node nodeD = BA.new Node("d", nodeG, nodeE, false);
        Node nodeB = BA.new Node("b", nodeD, nodeF, false);
        Node nodeC = BA.new Node("c", null, null, false);
        Node root = BA.new Node("a", nodeB, nodeC, true);
        BA.pruneTree(root, null);
        List<Node> presentNodes = BA.results;
        for (Node nd: presentNodes) {
            System.out.print(nd.value+",");
        }
        //Node nodeC

    }
}
