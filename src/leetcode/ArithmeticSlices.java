package leetcode;

/**
 * Created by rarshion on 16/11/5.
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {

        int ret = 0, count = 0;

        for (int i = 2; i < A.length; i++) {
            if (A[i -1] - A[i] == A[i - 2] - A[i - 1]) {
                count += ++ret;
            } else {
                ret = 0;
            }
        }

        return count;
    }
}
