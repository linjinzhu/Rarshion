package leetcode;

/**
 * Author ： Martin
 * Date : 17/5/6
 * Description :
 * Version : 2.0
 */
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }
}
