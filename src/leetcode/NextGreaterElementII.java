package leetcode;

import java.util.Stack;

/**
 * Author ： Martin
 * Date : 17/4/4
 * Description :
 * Version : 2.0
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        boolean[] found = new boolean[nums.length];
        int[] ret = new int[nums.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = -1;
            found[i] = false;
        }

        for (int i = nums.length - 1; i >= 0; --i) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ret[i] = stack.peek();
                found[i] = true;
            }
            stack.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!found[i]) {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ret[i] = stack.peek();
                }
            }
        }

        return ret;
    }
}
