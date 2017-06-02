package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/5/28
 * Description :
 * Version : 2.0
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (map.containsKey(key + 1)) {
                int tmp =  entry.getValue() + map.get(key + 1);
                max = Math.max(tmp, max);
            }
        }

        return max;

    }
}
