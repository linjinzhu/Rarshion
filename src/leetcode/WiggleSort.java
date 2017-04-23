package leetcode;

import java.util.Arrays;

/**
 * Created by rarshion on 16/9/26.
 */
public class WiggleSort {

    public void wiggleSort(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int[] result = new int[len];
        int left = len;
        int mid = (len - 1) / 2 + 1;

        for (int i = 0; i < len; i++) {
            result[i] = (i % 2 == 0) ? nums[--mid] : nums[--left];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = result[i];
        }

        return;

    }
}
