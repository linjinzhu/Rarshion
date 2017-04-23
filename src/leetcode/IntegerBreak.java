package leetcode;

/**
 * Created by rarshion on 16/8/17.
 */
public class IntegerBreak{

    public static int integerBreak(int n) {

        if (n == 2) return 1;
        if (n == 3) return 2;

        int ret = 1;

        while ( n > 4) {
            ret *= 3;
            n -= 3;
        }

        return  ret * n;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
