package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rarshion on 16/9/18.
 */
public class Sum4 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);//先排序

        for(int i = 0; i < nums.length - 3; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue; //如果重复则跳过
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue; //如果重复则跳过
                int k = j + 1, l = nums.length - 1;
                while(k < l){//采用夹逼
                    if(nums[i] + nums[j] + nums[k] + nums[l] < target){
                        k++;
                    }else if(nums[i] + nums[j] +nums[k] + nums[l] > target){
                        l--;
                    }else{
                        ArrayList<Integer> elem = new ArrayList<>();
                        elem.add(nums[i]);
                        elem.add(nums[j]);
                        elem.add(nums[k]);
                        elem.add(nums[l]);
                        result.add(elem);

                        k++;
                        l--;

                        while(k < l && nums[l] == nums[l+1]){
                            l--;
                        }

                        while(k < l && nums[k] == nums[k - 1]){
                            k++;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum(nums, 0);
        for(List<Integer> elem :result){
            for(Integer value : elem){
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
