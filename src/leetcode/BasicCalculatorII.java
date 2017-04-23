package leetcode;

import java.util.Stack;

/**
 * Created by rarshion on 16/11/6.
 */
public class BasicCalculatorII {

    public int calculate(String s) {

        if (s == null || s.length() == 0)
            return 0;

        Stack<Integer> nums = new Stack<>();
        Stack<Character> symbols = new Stack<>();

        boolean isNum = false;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ' ')
                continue;

            if (Character.isDigit(temp)) {
                count = count * 10 + (temp - '0');
                isNum = true;
            } else if (isNum) {
                nums.push(count);
                if (!symbols.isEmpty() && (symbols.peek() == '*' || symbols.peek() == '/')) {
                    char symbol = symbols.pop();
                    int b = nums.pop();
                    int a = nums.pop();
                    if (symbol == '*') {
                        nums.push(a * b);
                    } else {
                        nums.push(a / b);
                    }
                }
            }

            if (!Character.isDigit(temp)) {
                symbols.push(temp);
            }

        }

        if (isNum) {
            nums.push(count);
            if (!symbols.isEmpty() && (symbols.peek() == '*' || symbols.peek() == '/')) {
                char symbol = symbols.pop();
                int b = nums.pop();
                int a = nums.pop();
                if (symbol == '*') {
                    nums.push(a * b);
                } else {
                    nums.push(a/b);
                }
            }
        }

        if (!symbols.isEmpty()) {
            int rep = 0;
            while (!symbols.isEmpty()) {
                char symbol = symbols.pop();
                int a = nums.pop();
                if (symbol == '+') {
                    rep += a;
                } else {
                    rep -= a;
                }
            }
            nums.push(rep + nums.pop());
        }

        return nums.pop();
    }
}
