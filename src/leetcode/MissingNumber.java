package leetcode;

import java.util.Arrays;

/**
 * Created by rarshion on 16/8/18.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        int min = 0, max = nums.length - 1;

        Arrays.sort(nums);

        while(min < max){
            int mid = (min + max) / 2;
            if(mid == nums[mid]){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        return nums[min] == min ? min+1 : min;
    }

    public static void main(){

    }
}
