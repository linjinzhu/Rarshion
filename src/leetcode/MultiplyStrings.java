package leetcode;

import java.text.ParseException;

/**
 * Created by rarshion on 16/9/18.
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int[] resultNum = new int[num1.length() + num2.length()];

        for(int i = 0; i < num1.length(); i++){
            int a = num1.charAt(i) - '0';
            for(int j = 0; j < num2.length(); j++){
                int b = num2.charAt(j) - '0';
                resultNum[i+j] += a * b;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < resultNum.length; i++){
            int digit = resultNum[i] % 10;
            int carry = resultNum[i] / 10;
            sb.insert(0, digit);
            if(i < resultNum.length - 1){
                resultNum[i+1] += carry;
            }
        }

        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();

    }

    public static void main(String[] args){
        String s1 = "1", s2 = "2345";
        System.out.println(multiply(s1,s2));
    }
}
