package leetcode;

/**
 * Author ： Martin
 * Date : 17/8/6
 * Description :
 * Version : 2.0
 */
public class MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        double sum = 0;
        double res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                res = Math.max(res, sum);
            }
        }
        return res/k;
    }

    public static void main(String[] args) {
        System.out.print(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
