package leetcode;

import java.util.Arrays;

/**
 * Author ： Martin
 * Date : 17/7/3
 * Description :
 * Version : 2.0
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);

        int start = 0;
        while (start < nums.length && temp[start] == nums[start]) start++;

        int end = nums.length - 1;
        while (end > start && temp[end] == nums[end]) end--;

        return end - start + 1;
    }
}
