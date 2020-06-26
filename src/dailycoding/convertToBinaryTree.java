package dailycoding;

import interviewCake.BinaryTreeNode;
import leetCode.TreeNode;

public class convertToBinaryTree {

    public TreeNode convertToFull(TreeNode root){

        if(root == null){
            return new TreeNode();
        }

        if(hasOneChild(root) || isLeaf(root)){
            return root;
        }

        trimTree(root.left, root);
        trimTree(root.right, root);

        return root;
    }

    private void trimTree(TreeNode node, TreeNode parent) {
        if(node != null && hasOneChild(node) && !isLeaf(node)){
            if(node.left != null){
                parent.left = node.left;
                trimTree(node.left, parent);
            }else if(node.right != null){
                parent.right = node.right;
                trimTree(node.right, parent);
            }
        }else{
            trimTree(node.left, node);
            trimTree(node.right, node);
        }
    }


    private boolean hasOneChild(TreeNode node) {
        return ((node.left != null && node.right == null)
                || (node.left == null && node.right != null));
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    public static void main(String [] args){
        TreeNode treeNode = new TreeNode(0);

        TreeNode level1Left = treeNode.left = new TreeNode(1);
        TreeNode level1Right = treeNode.right = new TreeNode(2);

        TreeNode level2Left = level1Left.left = new TreeNode(3);
        TreeNode level3Right = level2Left.right = new TreeNode(5);

        TreeNode level2Right = level1Right.right = new TreeNode(4);

        TreeNode level3Left = level1Right.left = new TreeNode(6);



    }


}
