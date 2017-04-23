package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/22
 * Description :
 * Version : 2.0
 */
public class ReverseStringII {

    private void reverseString(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++; r--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=k) {
            if ((i % (2*k)) == 0) {
                reverseString(chars, i, Math.min(i + k - 1, chars.length -1));
            }
        }
        return new String(chars);
    }


}
