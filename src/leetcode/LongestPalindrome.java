package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rarshion on 16/11/8.
 */
public class LongestPalindrome {


    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }


    public static int longestPalindrome(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int maxPalindromeLen = 0;
        String loggestPalindrome = null;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int length = j - i;
                String curr = s.substring(i, j+1);
                if (isPalindrome(curr)) {
                    if (length > maxPalindromeLen) {
                        loggestPalindrome = curr;
                        maxPalindromeLen = length;
                    }
                }
            }
        }

        return maxPalindromeLen;
    }


    public static int longPalidrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count += 2;
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return count + (set.size() > 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcba"));
    }


}
