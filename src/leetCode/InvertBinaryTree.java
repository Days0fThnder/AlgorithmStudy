package leetCode;

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {

        if(root == null){
            return null;
        }

        flipNodes(root);

        return root;

    }

    private static void flipNodes(TreeNode node){
        if(node != null){
            if(node.left != null && node.right != null){
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }

            if(node.left != null && node.right == null){
                node.right = node.left;
                node.left = null;
            }

            if(node.right != null && node.left == null){
                node.left = node.right;
                node.right = null;
            }
            flipNodes(node.left);
            flipNodes(node.right);
        }
    }

    public static void main(String [] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        invertTree(root);
    }
}
