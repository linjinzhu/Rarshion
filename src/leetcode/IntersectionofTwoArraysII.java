package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author ： Martin
 * Date : 17/4/23
 * Description :
 * Version : 2.0
 */
public class IntersectionofTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int lenA = nums1.length;
        int lenB = nums2.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0, j = 0; i < lenA && j < lenB; ) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int size = result.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        intersect(new int[]{1,2,3}, new int[]{2,3,4});
    }
}
