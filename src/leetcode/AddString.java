package leetcode;

/**
 * Created by rarshion on 16/10/27.
 */
public class AddString {

    public static String addStrings(String num1, String num2) {

        String result = "";
        char[] str1 = num1.toCharArray();
        char[] str2 = num2.toCharArray();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;

        while (index1 >= 0 || index2 >= 0) {
            int a = (index1 >= 0 ? (str1[index1--] - '0'): 0);
            int b = (index2 >= 0 ? (str2[index2--] - '0'): 0);
            int sum = a + b + carry;
            result = String.valueOf(sum % 10) + result;
            carry = sum / 10;
        }

        return carry > 0 ? "1" + result : result;
    }


    public static void main(String[] args) {
        System.out.println(addStrings("123", "1237"));
    }



}
