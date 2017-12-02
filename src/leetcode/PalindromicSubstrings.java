package leetcode;

/**
 * Author ： Martin
 * Date : 17/9/16
 * Description :
 * Version : 2.0
 */
public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        String str1, str2;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                str1 = s.substring(i, j);
                str2 = str1;
                if (str2.equals(new StringBuffer(str1).reverse().toString())) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }
}
