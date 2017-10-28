package leetcode;

/**
 * Author ： Martin
 * Date : 17/5/13
 * Description :
 * Version : 2.0
 */
public class OptimalDivision {
    public static String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        if (nums.length == 2) {
            return String.format("%s/%s", nums[0], nums[1]);
        }

        String ans = nums[0] + "/";
        String temp = String.valueOf(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            temp += "/";
            temp += String.valueOf(nums[i]);
        }
        ans = String.format("%s(%s)", ans, temp);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(optimalDivision(new int[]{1000, 100, 10, 2}));
    }
}
