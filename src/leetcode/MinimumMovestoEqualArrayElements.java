package leetcode;

import java.util.Arrays;

/**
 * Author ： Martin
 * Date : 17/4/3
 * Description :
 * Version : 2.0
 */
public class MinimumMovestoEqualArrayElements {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int cnt = 0;
        while ( i < j) {
            cnt += nums[j--] - nums[i++];
        }
        return cnt;
    }
}
