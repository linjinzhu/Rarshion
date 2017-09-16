package leetcode;

import java.util.Arrays;

/**
 * Author ： Martin
 * Date : 17/7/2
 * Description :
 * Version : 2.0
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
