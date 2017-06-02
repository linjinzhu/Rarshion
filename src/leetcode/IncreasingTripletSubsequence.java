package leetcode;

/**
 * Created by rarshion on 16/8/28.
 */
public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {

        int dp[] = new int[nums.length];
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if(dp[i] >= 3)
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean increasingTriplet2(int[] nums) {
        return true;
    }





    public static void main(String[] args){
        int[] test = {1,8,1,4};
        System.out.println(increasingTriplet(test));
    }

}
