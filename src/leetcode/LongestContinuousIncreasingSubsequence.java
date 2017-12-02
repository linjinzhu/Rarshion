package leetcode;

/**
 * Author ： Martin
 * Date : 17/10/28
 * Description :
 * Version : 2.0
 */
public class LongestContinuousIncreasingSubsequence {

    public static int findLengthOfLCIS1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int max = 1;
        int[] map = new int[len];
        for (int i = 0; i < len; i++) {
            map[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && map[i] < map[j] + 1) {
                    map[i] = map[j] + 1;
                    max = Math.max(map[i], max);
                }
            }
        }

        return max;
    }


    public static int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 1, maxLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                maxLen++;
            } else {
                maxLen = 1;
            }
            result = Math.max(result, maxLen);
        }

        return result;
    }


    public static void main(String[] args) {
//        System.out.println(findLengthOfLCIS(new int[] { 2, 2, 2, 2, 2}));
        System.out.println(findLengthOfLCIS(new int[] {1, 3, 5, 4, 7}));
    }

}
