package GraphAlgos;

/**
 * Created by j_rus on 4/13/2016.
 */
public class BSTAlgos {

     BSTNode root;

    public static BSTNode Search(BSTNode root, int target){
            while(root != null){
                if(root.data == target){
                    return root;
                }
                if(target < root.data){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
        return null;
    }

    public static void inOrderTraversal(BSTNode node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.println(node);
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(BSTNode node){
        if(node != null){
            System.out.println(node);
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(BSTNode node){
        if(node != null){
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            System.out.println(node);
        }
    }

    public BSTNode recursiveSearch(BSTNode root, int target){

            if(root == null){
                return null;
            }
            if (root.data == target) {
                return root;
            }
            if (target < root.data){
                return recursiveSearch(root.left, target);
            }else {
                return recursiveSearch(root.right, target);
            }


    }

    public void insert(int data, String name) {
        BSTNode prev;
        BSTNode newNode = new BSTNode(data, name);
        if (root == null) {
            root = newNode;
        }
        else {

            BSTNode focusNode = root;


            while (true) {
                prev = focusNode;
                if (data < focusNode.data) {
                    focusNode = focusNode.left;
                    if(focusNode == null){
                        prev.left = newNode;
                        return;
                    }
                } else if(data > focusNode.data) {
                    focusNode = focusNode.right;
                    if(focusNode == null){
                        prev.right = newNode;
                        return;
                    }
                }else{
                    System.out.println("Can't print "+newNode.data+" twice: No duplicates allowed");
                    return;
                }
            }

        }
    }

    public BSTNode delete(BSTNode root, int target){
        BSTNode x=root, parent=null;

        if(x == null){
            throw new IllegalArgumentException();
        }
        while(x != null){
            if(x.data == target){
                break;
            }
            parent = x;
            x = target < x.data ? x.left : x.right;
        }
        if(x.right != null && x.left != null){ // 2 children
            BSTNode tempRoot = x.left;
            parent = x;
            while (tempRoot.right != null){
                parent = tempRoot;
                tempRoot = tempRoot.right;
            }
            x.data = tempRoot.data;
            x = tempRoot;
        }
         //leaf and 1 child
        if (parent == null){
            return x.left != null ? x.left : x.right;
        }
        BSTNode temp = x.left != null ? x.left : x.right;
        if ( x == parent.right){
            parent.right = temp;
        } else {
            parent.left = temp;
        }
        return x;
    }
}
