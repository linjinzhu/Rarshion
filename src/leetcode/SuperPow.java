package leetcode;

/**
 * Created by rarshion on 16/10/4.
 */
public class SuperPow {

    public boolean isPositive(int[] x) {
        for (int i = x.length - 1; i >= 0; i--) {
            if (x[i] > 0)
                return true;
        }
        return false;
    }

    public int superPow(int a, int[] b) {
        return 0;
    }
}
