package leetcode;

/**
 * Created by rarshion on 16/8/16.
 */
public class ProductofArrayExceptSelf {

/*
    public static int[] productExceptSelf(int[] nums) {

        int[] ret = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int sum = 1;

            for(int j = 0; j < nums.length; j++){
                if(i != j)
                    sum *= nums[j];
            }
            ret[i] = sum;
        }

        return ret;
    }
*/

    public static int[] productExceptSelf(int[] nums) {

        int[] ret = new int[nums.length];
        for(int i = 0; i < ret.length; i++){
            ret[i] = 1;
        }

        for(int i = 1; i < ret.length; i++){
            ret[i] = ret[i-1] * nums[i-1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            ret[i] *= right;
            right *= nums[i];
        }

        return ret;
    }



    public static void main(String[] args){
        int[] temp = new int[]{1,2,3,4};
        int[] tem = productExceptSelf(temp);
        for(int i = 0; i < tem.length; i++){
            System.out.println(tem[i]);
        }
    }


}
