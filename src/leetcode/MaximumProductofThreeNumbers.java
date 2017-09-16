package leetcode;

import java.util.Arrays;

/**
 * Author ： Martin
 * Date : 17/7/8
 * Description :
 * Version : 2.0
 */
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int a = nums[0];
        int b = nums[1];
        int c = nums[len - 1];
        int d = nums[len - 2];
        int e = nums[len - 3];
        int start = a * b * c;
        int end = c * d * e;
        return start > end ? start : end;

    }
}
