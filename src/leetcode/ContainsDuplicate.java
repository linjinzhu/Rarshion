package leetcode;

import java.util.HashSet;

/**
 * Created by user on 2016/8/8.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        if(nums == null || nums.length == 0){
            return false;
        }

        HashSet<Integer> maps = new HashSet<Integer>();

        for(int elem : nums){
            if (!maps.add(elem)) {
                return true;
            }
        }

        return false;
    }
}
