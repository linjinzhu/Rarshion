package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author ： Martin
 * Date : 17/7/16
 * Description :
 * Version : 2.0
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;

        Arrays.sort(nums);

        int index = 0;
        int len = nums.length;
        int j = 1;
        while (index < nums.length - 1 && nums[index] <= 0) index++;
        while (index < len) {
            while(index < len - 1 && nums[index] == nums[index + 1]) index++;
            if (nums[index] != j) break;
            index++; j++;
        }
        return j;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, -2, 0, 1, 5};
//        System.out.println(firstMissingPositive(nums));
//
//
        String[] strs = (String[]) Array.newInstance(String.class, 8);



    }
}
