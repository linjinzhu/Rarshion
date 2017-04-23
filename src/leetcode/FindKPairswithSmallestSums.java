package leetcode;

import java.util.*;

/**
 * Created by rarshion on 16/9/4.
 */



public class FindKPairswithSmallestSums {


    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        List<int[]> res = new ArrayList<>();

        if(len1 == 0 || len2 == 0 || k == 0){
            return res;
        }

        Queue<int[]> queue = new PriorityQueue<>(len1 * len2,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] i1, int[] i2) {
                        return i1[0]+i1[1] - i2[0]-i2[1];
                    }
                });

        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                int[] elem = new int[]{nums1[i], nums2[j]};
                queue.add(elem);
            }
        }

        if(k > queue.size())
            k = queue.size();

        while(k>0){
            res.add(queue.poll());
            k--;
        }

        return res;
    }

}
