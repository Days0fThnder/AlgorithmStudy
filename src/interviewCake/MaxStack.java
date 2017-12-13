package interviewCake;

import java.util.Stack;

public class MaxStack {

    private int max;
    private Stack<Integer> stk;
    private Stack<Integer> maxStk = new Stack<>();

    public MaxStack(){
        this.stk = new Stack<>();
        maxStk.push(Integer.MIN_VALUE);
    }

    public void push(int num){
        if(num >= maxStk.peek()){
            if(maxStk.peek() == Integer.MIN_VALUE){
                maxStk.pop();
            }
            maxStk.push(num);
        }
        this.stk.push(num);
    }

    public Integer pop(){
        if(this.stk.peek() == maxStk.peek()){
            maxStk.pop();
        }
        return this.stk.pop();
    }

    public Integer getMax(){
        if(maxStk.empty()){
            System.out.println("The stack is empty");
            return null;
        }
        return maxStk.peek();
    }
}
