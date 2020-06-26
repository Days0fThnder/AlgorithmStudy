package leetCode;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public  TreeNode(){

    }

    public TreeNode(int x) {
        val = x;
    }

    public static void  buildTree(Integer [] arr){
        TreeNode treeNode;
        for (int i = 0; i < arr.length ; i++) {
           if(i == 0 && arr[0] != null){
               treeNode = new TreeNode(arr[0]);
           }else{

           }


        }
    }
}
