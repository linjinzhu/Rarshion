package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/3/18
 * Description :
 * Version : 2.0
 */
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < findNums.length; i++) {
            int max = -1;
            Integer index = map.get(findNums[i]);
            if (index != null) {
                for (; index < nums.length; index++) {
                    if (nums[index] > findNums[i]) {
                        max = nums[index];
                        break;
                    }
                }
            }
            result[i] = max;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] findNums = {4, 1, 2};
        int[] nums = {1, 3, 4, 2};
        int[] result = nextGreaterElement(findNums, nums);
        for (int i = 0; i <result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
