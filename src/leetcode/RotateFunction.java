package leetcode;

/**
 * Created by rarshion on 16/10/3.
 */
public class RotateFunction {

    public int maxRotateFunction(int[] A) {

        if (A == null || A.length  == 0)
            return 0;


        long max = 0, result = 0, sum  = 0;

        for (int i = 0; i < A.length; i++) {
             sum += A[i];
        }

        for (int i = 0; i < A.length; i++) {
            result += i * A[i];
        }

        max = result;

        for (int k = 1; k < A.length; k++) {
            result += result + sum - (A.length) * A[A.length - k];
            max = Math.max(result, max);
        }

        return (int) max;

    }
}
