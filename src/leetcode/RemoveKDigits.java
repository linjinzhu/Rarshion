package leetcode;

import javafx.beans.binding.StringBinding;

import java.util.Stack;

/**
 * Created by rarshion on 16/9/18.
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {

        if(k >= num.length())
            return "0";

        Stack<Character> stack = new Stack<>();
        String temp = new StringBuilder(num).reverse().toString();
        for(int i = 0; i < temp.length(); i++){ //倒序进栈
            stack.push(temp.charAt(i));
        }

        int nextV = -1;

        while(k > 0 && !stack.isEmpty()){

            char peekC = stack.pop();
            int peekV = peekC - '0'; //返回栈顶元素,并出栈

            if(!stack.isEmpty()){
                char nextC = stack.peek();
                nextV = nextC - '0';
            }

            if(peekV < nextV){ //比较已出栈与当前栈顶元素的大小
                stack.pop();
                stack.push(peekC);
            }

            k--;
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        while(result.charAt(0) == '0' && result.length() > 1)
            result.deleteCharAt(0);

        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(removeKdigits("10", 1));
    }
}
