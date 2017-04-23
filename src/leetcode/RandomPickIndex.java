package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rarshion on 16/10/4.
 */
public class RandomPickIndex {

    private int[] nums;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> idx = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                idx.add(i);
            }
        }
        return idx.get(r.nextInt(idx.size()));
    }
}
