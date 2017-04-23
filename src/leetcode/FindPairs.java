package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/4/2
 * Description :
 * Version : 2.0
 */
public class FindPairs {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i) {
                map.remove(nums[i] + k);
                res++;
            }
        }

        return res;

    }
}
