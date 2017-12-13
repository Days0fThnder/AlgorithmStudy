package interviewCake;

import GraphAlgos.BinaryTree;

public class Sandbox {
    BinaryTreeNode largest;
    BinaryTreeNode sLargest;
    BinaryTreeNode secondLargest(BinaryTreeNode root){
        if(root == null ){
            return null;
        }

        if(largest == null){
            largest = root;
        }

        if(root.right != null){
            if(largest.value > root.right.value){
                sLargest = root.right;

            }else{
                largest = root.right;
                sLargest = root;

            }

            return secondLargest(root.right);
        }else if(root.left != null){
            largest = root;
            sLargest = root.left;
            return secondLargest(root.left);
        }

        return sLargest;

    }

    public static void main(String [] arg){
        BinaryTreeNode treeNode = new BinaryTreeNode(8);
        BinaryTreeNode level_1_left = treeNode.insertLeft(3);
        BinaryTreeNode level_1_right = treeNode.insertRight(10);
        BinaryTreeNode l_level_2_left = level_1_left.insertLeft(1);
        BinaryTreeNode l_level_2_right = level_1_left.insertRight(6);
        //BinaryTreeNode R_level_2_right = level_1_right.insertRight(14);
        BinaryTreeNode l_level_3_left = l_level_2_right.insertLeft(4);
        BinaryTreeNode l_level_3_right = l_level_2_right.insertRight(7);
        //BinaryTreeNode R_level_3_left = R_level_2_right.insertLeft(13);

        Sandbox sb = new Sandbox();

        BinaryTreeNode sl = sb.secondLargest(treeNode);
        System.out.println(sl.value);


    }
}
