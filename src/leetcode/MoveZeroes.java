package leetcode;

/**
 * Created by user on 2016/8/5.
 */
public class MoveZeroes {

    public static void moveZeros(int[] nums){
        int newIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(0 != nums[i])
                nums[newIndex++] = nums[i];
        }

        for(; newIndex < nums.length; newIndex++){
            nums[newIndex] = 0;
        }
    }

    public static void main(String[] args){

        int[] temp = {1,2,0,1,0};
        moveZeros(temp);
        for(int i = 0; i < temp.length; i++){
            System.out.println(temp[i]);
        }

    }
}
