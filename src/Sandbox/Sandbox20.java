package Sandbox;

/**
 * Created by j_rus on 6/19/2017.
 */
public class Sandbox20 {
    // Definition for binary tree:
      class Tree<T> {
         Tree(T x) {
        value = x;
       }
       T value;
       Tree<T> left;
       Tree<T> right;
     }

    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {

          if(t == null){
              return true;
          }

          if(s == traverseTree(t, 0, s)){
              return true;
          }

          return false;
    }

    private int traverseTree(Tree<Integer> t, Integer sum, int s) {

          if(t != null) {
              sum = t.value;
              if (t.right == null || t.left == null) {
                 return sum;
              }

              if(t.left != null){
                  sum = traverseTree(t.left, sum, s);
                  if(sum == s){
                      return sum;
                  }
              }

              if(t.right != null){
                  sum = traverseTree(t.right, sum, s);
                  if(sum == s){
                      return sum;
                  }
              }
          }
          return sum;
    }

    static boolean isTreeSymmetric(Tree<Integer> t){
          if(t != null){
              return  isTreeSymmetric(t.left, t.right );
          }else if(t == null){
              return true;
          }

          return false;
    }

    static boolean isTreeSymmetric(Tree<Integer> left, Tree<Integer> right ){

        if(left != null && right != null){
            if(left.value.equals(right.value)){
                if(isTreeSymmetric(left.left, right.right)){
                    return isTreeSymmetric(left.right, right.left);
                }
            }
        }else if(left == null && right == null){
            return true;
        }

        return false;
    }

    public static void main(String [] arg){
      Sandbox20 sb20 = new Sandbox20();

      /*Sandbox20.Tree tree = sb20.new Tree<Integer>(1);
        Sandbox20.Tree t1L = tree.left = sb20.new Tree<Integer>(2);
      Sandbox20.Tree t1R = tree.right = sb20.new Tree<Integer>(2);


      Sandbox20.Tree t2L = t1L.left = sb20.new Tree<Integer>(3);
      Sandbox20.Tree t2R = t1L.right = sb20.new Tree<Integer>(4);

      Sandbox20.Tree t3L= t1R.left = sb20.new Tree<Integer>(4);
      Sandbox20.Tree t3R = t1R.right = sb20.new Tree<Integer>(3);*/
      Sandbox20.Tree tree = sb20.new Tree<Integer>(1);
      /*Sandbox20.Tree t1L = tree.left = sb20.new Tree<Integer>(2);
      Sandbox20.Tree t1R = tree.right = sb20.new Tree<Integer>(2);

      Sandbox20.Tree t2R = t1L.right = sb20.new Tree<Integer>(3);
      Sandbox20.Tree t3R = t1R .right = sb20.new Tree<Integer>(3);*/


        System.out.print(isTreeSymmetric(tree));

      /*Sandbox20.Tree t3R = t2Ra.left = sb20.new Tree<Integer>(-2);
      Sandbox20.Tree t3Ra = t2Ra.right = sb20.new Tree<Integer>(-3);*/

      //System.out.print(sb20.hasPathWithGivenSum(tree, 8));
    }


}
