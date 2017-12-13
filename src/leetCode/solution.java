package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class solution {

    List<TreeNode> results = new ArrayList<>();
    List<TreeNode> leafs = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        if(root != null) {
            TreeNode copyRight = root.right;
            TreeNode left = root.left;

            findDuplicateSubtrees(left, copyRight);
        }
        Set<Integer> leafSet = new HashSet<>();
        for (TreeNode tn: leafs) {
            if(leafSet.contains(tn.val)){
                results.add(tn);
            }
            leafSet.add(tn.val);
        }
        return results;


    }

    public boolean findDuplicateSubtrees(TreeNode left, TreeNode copyRight) {

        if(left != null || copyRight != null){
            checkForLeaf(left, copyRight);
        }

        if (left != null && copyRight != null) {
            if (left.val == copyRight.val) {
                if (findDuplicateSubtrees(left.left, copyRight.left) &&
                        findDuplicateSubtrees(left.right, copyRight.right)) {
                    results.add(left);
                    return true;
                }else{
                    if(copyRight.right != null){
                        findDuplicateSubtrees(null, copyRight.right);
                    }

                }
            } else {
                findDuplicateSubtrees(left, copyRight.left);
                findDuplicateSubtrees(left.right, copyRight);
            }

        }else if( left == null && copyRight != null){
            findDuplicateSubtrees(null, copyRight.left);
            findDuplicateSubtrees(null, copyRight.right);

        }else if ( left != null && copyRight == null){
            findDuplicateSubtrees(left.left, null);
            findDuplicateSubtrees(left.right, null);
        }
        else if (left == null && copyRight == null) {
            return true;
        }

        return false;

    }

    private void checkForLeaf(TreeNode left, TreeNode right){
        if (left != null && left.left == null && left.right == null){
            leafs.add(left);
        }

        if (right != null && right.left == null && right.right == null){
            leafs.add(right);
        }
    }

    public static void main(String [] arg){
        solution sol = new solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.right.right = new TreeNode(0);
        sol.findDuplicateSubtrees(root);
    }
}
