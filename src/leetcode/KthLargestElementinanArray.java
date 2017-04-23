package leetcode;

import java.text.ParseException;
import java.util.*;

/**
 * Created by rarshion on 16/8/25.
 */
public class KthLargestElementinanArray {


    public static int[] parseIntArray(final ArrayList<Integer> list){
        int tempNums[] = new int[list.size()];
        Integer tempInteger[] = new Integer[list.size()];
        list.toArray(tempInteger);

        for(int i  = 0; i < tempInteger.length; i++){
            tempNums[i] = tempInteger[i].intValue();
        }

        return tempNums;
    }

    public static int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        if(len == 1)
            return nums[0];

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i = 1; i < len; i++){
            if(nums[i] > nums[0])
                right.add(nums[i]);
            else
                left.add(nums[i]);
        }

        len = right.size();
        if(len >= k){
            return findKthLargest(parseIntArray(right), k);
        }else if(len == k - 1){
            return nums[0];
        }else{
            return findKthLargest(parseIntArray(left), k - len - 1);
        }
    }

    static<T> void test(Iterable<T> ib){
        for(T t : ib){
            System.out.println(t + " ");
        }
    }
    
    public static void main(String[] args){

        int[] test = new int[]{1,2,4,5};
       // System.out.println(findKthLargest(test, 1));
        System.out.println(1 >> 3);

        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("hello", 1);
        testMap.put("hi", 2);
        testMap.put("nihao", 3);

        //Queue<Integer> queue = new LinkedList<>();

        test(Arrays.asList(1,2,3));


    }
}
