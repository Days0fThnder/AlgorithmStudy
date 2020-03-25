package leetCode;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
     /** initialize your data structure here. */
     public MinStack() {
        stack = new Stack();
        minStack = new Stack();
     }

     public void push(int x) {
        stack.push(x);

        if(minStack.isEmpty()){
            minStack.push(x);
        }else if (minStack.peek() >= x){
            minStack.push(x);
        }
     }

     public void pop() {
        if(stack.peek().equals(minStack.peek())){
             stack.pop();
             minStack.pop();
        }else{
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String [] args){
         MinStack minStack = new MinStack();

         minStack.push(512);
         minStack.push(-1024);
         minStack.push(-1024);
         minStack.push(512);
         minStack.pop();
         System.out.println(minStack.getMin());
         minStack.pop();
         System.out.println(minStack.getMin());
         minStack.pop();
         System.out.println(minStack.getMin());

    }

}
