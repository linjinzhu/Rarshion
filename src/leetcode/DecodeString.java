package leetcode;

import java.util.Stack;

/**
 * Created by rarshion on 16/9/27.
 */
public class DecodeString {

    public static String decodeString(String s) {

        if (s == null || s.length() == 0)
            return "";

        Stack<Integer> cntStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int count = 0;
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count = count * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                cntStack.push(count);
                strStack.push(temp);
                temp = "";
                count = 0;
            } else if (s.charAt(i) == ']') {
                int k = cntStack.pop();
                String topStr = strStack.peek();
                for (int j = 0; j < k; j++) {
                    topStr += temp;
                }
                temp = topStr;
                strStack.pop();
            } else {
                temp += s.charAt(i);
            }
        }

        return temp;

    }


    public static void main(String[] args) {
        String result = decodeString("9[a]");
        System.out.println(result);
    }
}
