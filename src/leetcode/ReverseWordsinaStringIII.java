package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/21
 * Description :
 * Version : 2.0
 */
public class ReverseWordsinaStringIII {

    private static void reverseChars(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;j--;
        }
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == ' ') {
                reverseChars(chars, i, j-1);
                i = j + 1;
            }
        }
        reverseChars(chars, i, chars.length - 1);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }


}
