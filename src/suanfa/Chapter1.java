package mianshi;

/**
 * Author ： Martin
 * Date : 17/9/25
 * Description :
 * Version : 2.0
 */
public class Chapter1 {
    public static boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
}
