package leetcode;

/**
 * Created by rarshion on 16/8/12.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int newIndex = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[newIndex++] = nums[i];
            }
        }

        return newIndex;
    }
}
