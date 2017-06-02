package leetcode;

/**
 * Created by rarshion on 16/10/28.
 */
public class NthDigit {

    public static int findNthDigit(int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(String.valueOf(i));
        }

        return Integer.valueOf(sb.charAt(n-1) - '0');
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(11));
    }
}
