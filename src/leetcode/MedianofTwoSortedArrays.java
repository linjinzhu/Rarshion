package leetcode;

/**
 * Created by rarshion on 16/9/13.
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;

        if(total % 2 == 0){
            int sa = findkthMin(nums1, nums2, total/2);
            int sb = findkthMin(nums1,nums2, total/2 + 1);
            return ((double)sa + (double)sb) / 2;
        }else{
            return findkthMin(nums1, nums2, total/2 + 1);
        }
    }

    public int findkthMin(int[] nums1, int[] nums2, int k){

        int p = 0, q = 0;

        for(int i = 0; i < k - 1; i++){
            if(p >= nums1.length && q < nums2.length){
                q++;
            }else if(p < nums1.length && q >= nums2.length) {
                p++;
            }else if(nums1[p] > nums2[q]){
                q++;
            }else{
                p++;
            }
        }

        if(p >= nums1.length){
            return nums2[q];
        }else if(q >= nums2.length){
            return nums1[p];
        }else{
            return Math.min(nums1[p], nums2[q]);
        }

    }

    public static void main(String[] args){
        MedianofTwoSortedArrays test = new MedianofTwoSortedArrays();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(test.findMedianSortedArrays(nums1,nums2));
    }
}
