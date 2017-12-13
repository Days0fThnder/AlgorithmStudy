package interviewCake;

import GraphAlgos.BinaryTree;

public class SecondLargest {

    public BinaryTreeNode secondLarNode(BinaryTreeNode root){
        BinaryTreeNode second = null;
        return secondLarNode(root, second);
    }

    private BinaryTreeNode secondLarNode(BinaryTreeNode node, BinaryTreeNode second){

        if(node != null && node.right != null){
            second = node;
            secondLarNode(node.right, second);
        }else if(node != null && node.left != null){
            second = node.left;
            secondLarNode(node.left, second);
        }

        return second;

    }

    public static void main(String [] arg){
        BinaryTreeNode root = new BinaryTreeNode(2);
        root.insertRight(3);
        root.insertLeft(1);

        SecondLargest sl = new SecondLargest();
        System.out.println(sl.secondLarNode(root).value);
    }
}
