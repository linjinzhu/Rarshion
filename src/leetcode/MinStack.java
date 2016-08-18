package leetcode;

import java.util.Stack;

/**
 * Created by rarshion on 16/8/13.
 */
public class MinStack {

    Stack<Integer> content;
    Stack<Integer>  min;

    public MinStack() {
        content = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if(min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
        content.push(x);
    }

    public void pop() {
        if(min.peek().equals(content.peek())){
            min.pop();
        }
        content.pop();
    }

    public int top() {
        return content.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
