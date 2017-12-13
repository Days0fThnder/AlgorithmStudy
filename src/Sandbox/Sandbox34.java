package Sandbox;

import codeFights.Tree;
import google.Test;

public class Sandbox34 {

    boolean isSubTreeNodes(Tree<Integer> t1, Tree<Integer> t2){

        if (t1 == null && t2 == null){
            return true;
        }

        if (t1 == null || t2 == null){
            return false;
        }

        return (t1.value == t2.value &&
             isSubtree(t1.left,t2.left)&&
                    isSubtree(t1.right, t2.right));
    }

    boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {

        if (t2 == null)
            return true;

        if (t1 == null)
            return false;

        if (isSubTreeNodes(t1, t2))
            return true;

        return isSubtree(t1.left, t2)
                || isSubtree(t1.right, t2);
    }

    public static void main(String [] arg){
        Sandbox34 sb34 = new Sandbox34();
        Tree<Integer> t1 = new Tree<>(5);
        Tree<Integer> t1Left = t1.left = new Tree<>(10);
        Tree<Integer> t1Right = t1.right = new Tree<>(7);
        Tree<Integer> t1Left2 = t1Left.left = new Tree<>(4);
        Tree<Integer> t1Right2 = t1Left.right = new Tree<>(6);
        Tree<Integer> t1Left3 = t1Left2.left = new Tree<>(1);
        Tree<Integer> t1Right3 = t1Left2.right = new Tree<>(2);
        Tree<Integer> t1Right4 = t1Right2.right = new Tree<>(-1);

        Tree<Integer> t2 = new Tree<>(10);
        Tree<Integer> t2Left = t2.left = new Tree<>(4);
        Tree<Integer> t2Right = t2.right = new Tree<>(6);
        Tree<Integer> t2Left2 = t2Left.left = new Tree<>(1);
        Tree<Integer> t2left2 = t2Left.right = new Tree<>(2);
        Tree<Integer> t2Right2 = t2Right.right = new Tree<>(-1);

        System.out.println(sb34.isSubtree(t1, t2));

    }
}
