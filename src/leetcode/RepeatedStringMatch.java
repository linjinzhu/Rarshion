package leetcode;

/**
 * Author ： Martin
 * Date : 17/11/27
 * Description :
 * Version : 2.0
 */
public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        String temp = A;
        for (int i = 1; i <= (B.length() / A.length()) + 2; i++) {
            if (temp.indexOf(B) != -1) {
                return i;
            } else {
                temp += A;
            }
        }
        return -1;
    }
}
