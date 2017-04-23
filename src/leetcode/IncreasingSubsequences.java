package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author ： Martin
 * Date : 17/4/15
 * Description :
 * Version : 2.0
 */
public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        helper(set, new ArrayList<>(), nums, 0);
        return new ArrayList<>(set);
    }

    private void helper(Set<List<Integer>> set, List<Integer> subList, int[] nums, int startIndex) {
        if (subList.size() >= 2) {
            set.add(new ArrayList<>(subList));
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (subList.size() == 0 || subList.get(subList.size() - 1) <= nums[i]) {
                subList.add(nums[i]);
                helper(set, subList, nums, startIndex + 1);
                subList.remove(subList.size() - 1);
            }
        }
    }
}
