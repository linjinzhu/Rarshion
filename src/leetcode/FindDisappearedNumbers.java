package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author ： Martin
 * Date : 17/3/18
 * Description :
 * Version : 2.0
 */
public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        int length = nums.length;
        int[] flags = new int[length];
        Arrays.fill(flags, -1);

        for (int i = 0; i < length; i++ ) {
            flags[nums[i] -1] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            if (flags[i] < 0)
                result.add(i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 4};
        List<Integer> result = findDisappearedNumbers(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.indexOf(i));
        }
    }
}
