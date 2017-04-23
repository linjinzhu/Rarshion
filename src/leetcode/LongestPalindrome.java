package leetcode;

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

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcba"));
    }


}
