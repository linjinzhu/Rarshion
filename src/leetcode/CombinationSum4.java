package leetcode;

import java.util.Arrays;

/**
 * Author ： Martin
 * Date : 17/9/17
 * Description :
 * Version : 2.0
 */
public class CombinationSum4{
    public static int combinationSum4(int[] nums, int target) {
        int[] result = new int[target + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        result[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int elem : nums) {
                if (elem < i) break;
                result[i] += result[i - elem];
            }
        }

        return result[result.length - 1];
    }

    public static void main(String[] args) {
        int[] temp = new int[3];
        temp[0] = 1;
        temp[1] = 2;
        temp[2] = 3;
        System.out.println(combinationSum4(temp, 4));
    }
}
