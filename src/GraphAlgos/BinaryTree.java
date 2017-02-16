package GraphAlgos;

import java.util.ArrayList;
import java.util.List;

class NodeRef{
    Node node;
}

enum Color{
    RED,
    BLACK
}

class Node{
    Node left;
    Node right;
    Node next;
    int data;
    int lis;
    int height;
    int size;
    Color color;

    public static Node newNode(int data){
        Node n = new Node();
        n.left = null;
        n.right = null;
        n.data = data;
        n.lis = -1;
        n.height = 1;
        n.size = 1;
        n.color = Color.RED;
        return n;
    }
}

public class BinaryTree {
    List<Node> leaves = new ArrayList<>();
    public Node addNode(int data, Node root){
        Node tempHead = root;
        Node newNode = Node.newNode(data);
        if(root == null){
            root = newNode;
            return root;
        }
        Node parent = null; Node current = root;
        while(current != null){
            parent = current;
            if(current.data < data){
                current = current.right;
            }else{
                current = current.left;
            }
        }
        if(parent.data < data){
            parent.right = newNode;
        }else{
            parent.left = newNode;
        }
        return tempHead;
    }

    class IntegerRef{
        int height;
    }

    public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight  = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isLeaf(Node node){
        if(node.left == null && node.right == null){
            return true;
        }else{
            return false;
        }
    }

    public List<Node> getLeaves(Node root){
        if(root == null){
            return null;
        }else if(isLeaf(root)){
            leaves.add(root);
        }else{
            getLeaves(root.left);
            getLeaves(root.right);
        }
        return leaves;
    }

    public int secondLargestElem(Node node, int second, int first){
        if(node.right != null){
            if(first > node.data){
                return secondLargestElem(node.right, node.right.data, first);
            }else{
                return secondLargestElem(node.right, node.data, node.right.data);
            }
        }else if (node.left != null && node.right == null){
            if(node.data >= node.left.data && first > node.data){
                return second;
            }else {
                return secondLargestElem(node.left, node.left.data, node.data);
            }
        }

        return second;
    }



    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        List<Node> treeLeaves = new ArrayList<>();
        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(3, head);
        head = bt.addNode(8, head);
        head = bt.addNode(1, head);
        head = bt.addNode(4, head);
        head = bt.addNode(7, head);
        head = bt.addNode(12, head);
        head = bt.addNode(9, head);
        head = bt.addNode(11, head);
        treeLeaves = bt.getLeaves(head);
        System.out.println(bt.height(head));
        System.out.println(bt.secondLargestElem(head, head.data, head.data));

    }
}