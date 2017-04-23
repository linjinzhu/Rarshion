package leetcode;

/**
 * Created by rarshion on 16/11/5.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int len = nums.length;
        int sum = 0;

        for (int i = 0; i <len; i++) {
            sum += nums[i];
        }

        if ((sum % 2) == 1)
            return false;

        sum /= 2;
        int[] dp = new int[sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            for (int j = sum; j >= 1; j--) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
                }
            }
        }

        return dp[sum] == sum;
    }
}

