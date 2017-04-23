package leetcode;

/**
 * Created by rarshion on 16/8/22.
 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {

        if(numbers == null || numbers.length < 1)
            return null;

        int left = 0, right = numbers.length - 1;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                return new int[]{left+1, right+1};
            }
        }

        return null;
    }

    public static void main(String[] args){
        int[] temp = {2,7,11,15};
        int[] test = twoSum(temp, 9);
        ArrayUtils.printArray(test);

    }

}
