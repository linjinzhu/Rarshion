package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author ： Martin
 * Date : 17/4/15
 * Description :
 * Version : 2.0
 */
public class LargestPalindromeProduct {
//
//    public static boolean isPalindrome(int number) {
//        StringBuilder sb = new StringBuilder(String.valueOf(number));
//        String nStr = sb.toString();
//        String rSb = sb.reverse().toString();
//        return nStr.equals(rSb);
//    }

    public static boolean isPalindrome(int number) {
        if (number < 0) return false;
        int tmp = number, res = 0;
        while(tmp > 0) {
            res = res * 10 + tmp%10;
            tmp /= 10;
        }
        return number == res;
    }

    public static int largestPalindrome(int n) {
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }

        int ret = 0;
        for (int i = 1; i < max; i++) {
            for (int j = 1; j < max; j++) {
                if (isPalindrome(i*j) && (i*j > ret)) {
                    ret = i*j;
                }
            }
        }
        return ret % 1337;
    }

    public static void main(String[] args) {
        System.out.println(largestPalindrome(2));
    }
}
