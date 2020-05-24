package dailycoding;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class yelpHp {

    private Integer dis = null;
    private List<Integer> res = new ArrayList<>();
    public List<Integer> bottomView(TreeNode root){
        if(root != null){
            bottomView(root.left, dis, 0);
            bottomView(root.right, dis, 0);
        }

        return res;
    }

    private void bottomView(TreeNode node, Integer dis, int curr) {
        if(node != null){
            bottomView(node.left, dis, curr-1);
            bottomView(node.right, dis, curr+1);
            if(dis == null || dis + 1 == curr){
                res.add(node.val);
                dis = curr;
            }
        }
    }

    public static void main(String [] args){
        yelpHp yelpHp = new yelpHp();
        TreeNode node = new TreeNode(5);
        TreeNode left = node.left = new TreeNode(7);
        TreeNode right = node.right = new TreeNode(3);
        left.left = new TreeNode(4);
        yelpHp.bottomView(node);
    }


}
