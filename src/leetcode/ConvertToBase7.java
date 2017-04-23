package leetcode;

/**
 * Author ： Martin
 * Date : 17/3/18
 * Description :
 * Version : 2.0
 */
public class ConvertToBase7 {

    public static String convertToBase7(int num) {
        if (num == 0)
            return "0";

        String result = "";
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }

        while (num > 0) {
            int tmp = num % 7;
            num = num / 7;
            result = String.valueOf(tmp) + result;
        }

        if (flag)
            result = "-" + result;

        return result;
    }

    public static void main(String[] args) {
        String result = convertToBase7(-12);
        System.out.println(result);
    }
}
