package leetcode;

/**
 * Author ： Martin
 * Date : 17/3/19
 * Description :
 * Version : 2.0
 */
public class RepeatedSubstringPattern {
    public static boolean RepeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return true;

        int len = s.length();
        for (int index = len / 2; index >= 1; index--) {
            if (len % index == 0) {
                int cnt = len / index;
                String subString = s.substring(0, index);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cnt; j++) {
                    sb.append(subString);
                }
                if (sb.toString().equals(s))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(RepeatedSubstringPattern("abcabcd"));
    }
}
