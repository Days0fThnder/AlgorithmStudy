package Sandbox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sandbox32 {
    class Tree<T> {
        Tree(T x) {
            value = x;
        }
        T value;
        Tree<T> left;
        Tree<T> right;
    }
    int kthPlace = 0;
    int kthValue = -1;

    int kthSmallestInBST(Tree<Integer> t, int k){

        
        findKthPlaceValue(t, k);

        return kthValue;
    }

    private void findKthPlaceValue(Tree<Integer> t, int k) {

        if(t != null){
            findKthPlaceValue(t.left, k);
            kthPlace++;
            if(kthPlace == k){
                kthValue = t.value;
            }else {
                findKthPlaceValue(t.right, k);
            }
        }
    }

    public static void main(String [] arg) {
        /*Sandbox32 sb32 = new Sandbox32();

        Sandbox32.Tree tree = sb32.new Tree<Integer>(1);
        Sandbox32.Tree t1L = tree.left = sb32.new Tree<Integer>(-1);
        Sandbox32.Tree t2L = t1L.left = sb32.new Tree<Integer>(-2);
        Sandbox32.Tree t2R = t1L.right = sb32.new Tree<Integer>(0);
        System.out.println(sb32.kthSmallestInBST(tree, 3));*/

        List<Integer> testList = new ArrayList<>();
        Queue<Integer> testQueue = new LinkedList<>();

        testList.add(null);
        testQueue.add(null);

        System.out.println(testQueue.size());
    }
}
