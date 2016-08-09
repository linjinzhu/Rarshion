package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 2016/8/5.
 */
public class Intersection {

    public static int[] intersecition(int[] nums1, int[] nums2){

        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> insetSet = new HashSet<Integer>();

        for(int i=0;i<nums1.length;i++) {
            set.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++) {
            if(set.contains(nums2[i]))
                insetSet.add(nums2[i]);
        }

        int[] ret = new int[insetSet.size()];
        int cnt = 0;
        for(int ele : insetSet){
            ret[cnt++] = ele;
        }

        return ret;
    }

    public static int[] intersecition2(int[] nums1, int[] nums2){

        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return null;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> res = new ArrayList<Integer>();
        int indexa = 0, indexb = 0;

        while(indexa < nums1.length && indexb < nums2.length){

            if(nums1[indexa] == nums2[indexb]){
                indexa++;
                indexb++;
                res.add(nums1[indexa]);
            }else if(nums1[indexa] < nums2[indexb]){
                indexa++;
            }else{
                indexb++;
            }
        }

        return new int[5];
    }


    public static void main(String[] args){

        int[] a = {1,4,4,1};
        int[] b = {2,2};
        int[] c = intersecition(a, b);

        for(int i = 0; i <  c.length; i++){
            System.out.println(c[i]);
        }
    }

}
