package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/9
 * Description :
 * Version : 2.0
 */
public class LongestUncommonSubsequence {
    public int findLUSlength(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        if (a.equals(b)) {
            return maxLen;
        }
        return -1;
    }
}
