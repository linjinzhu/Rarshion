package leetcode;

/**
 * Created by rarshion on 16/10/20.
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int[] bitNum = new int[32];
        int res =  0;
        for (int i = 0; i < bitNum.length; i++) {
            bitNum[i] = 0;
        }

        for (int i = 0; i < bitNum.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                bitNum[i] += (nums[j] >> i) & 1;
            }
            res |= (bitNum[i]%3) << i;
        }

        return res;
    }
}
