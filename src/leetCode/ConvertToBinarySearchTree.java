package leetCode;

public class ConvertToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {

        if(head.next == null){
            return new TreeNode(head.val);
        }

        TreeNode root = new TreeNode(head.val);

        ListNode prev = head;
        ListNode current = head.next;

        while(current != null){

            if(current.val > root.val){
                insert(root, current.val);
            }else{
                insert(root, current.val);
            }

            int leftHeight = getTreeHeight(root.left);
            int rightHeight = getTreeHeight(root.right);

            if(Math.abs(leftHeight-rightHeight) > 1){
                if(rightHeight > leftHeight){
                    balanceTree(root, root.right);
                }else{
                    balanceTree(root, root.left);
                }
            }

            prev = current;
            current = current.next;
        }

        return root;


    }

    private void balanceTree(TreeNode root, TreeNode child){
        TreeNode temp = root;

        if(temp.val > child.val){
            child.right = temp;
        }else{
            child.left = temp;
        }
        root = child;
    }


    private void insert(TreeNode node, int val){
        TreeNode current = null;
        while(node != null ){
            current = node;
            if(val < node.val){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        if(current == null){
            current = new TreeNode(val);
        }else if(val < current.val){
            current.left = new TreeNode(val);
        }else{
            current.right = new TreeNode(val);
        }
    }

    private int getTreeHeight(TreeNode node){

        if(node == null){
            return 0;
        }

        return Math.max(getTreeHeight(node.left), getTreeHeight(node.right)) + 1;
    }

    public static void main(String [] args){
        int [] arr = {-10,-3,0,5,9};
        ListNode sortedList = ListNode.buildList(arr);
        ConvertToBinarySearchTree convertToBinarySearchTree = new ConvertToBinarySearchTree();
        convertToBinarySearchTree.sortedListToBST(sortedList);

    }
}
