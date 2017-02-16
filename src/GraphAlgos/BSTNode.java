package GraphAlgos;

/**
 * Created by j_rus on 4/13/2016.
 */
public class BSTNode {
    int data;
    String name;
    BSTNode left, right;

    public BSTNode(int data, String name){
        this.data = data;
        this.name = name;
        left = null;
        right = null;
    }

    public String toString(){
        return "The data for this node is "+data +"";
    }
}
