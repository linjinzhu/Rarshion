package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/23
 * Description :
 * Version : 2.0
 */
public class ConvertaNumbertoHexadecimal {

    public static String toHex(int num) {
        String resultStr = "";
        String hexStr = "0123456789abcdef";
        while(num != 0) {
            resultStr = hexStr.charAt(num & 0xf) + resultStr;
            num = (num >>> 4);
        }
        return resultStr.isEmpty() ? "0" : resultStr;
    }

    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }
}
