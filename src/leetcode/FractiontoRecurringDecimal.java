package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/6/4
 * Description :
 * Version : 2.0
 */
public class FractiontoRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {

        StringBuilder result = new StringBuilder();
        if (numerator == 0) {
            return "0";
        }

        result.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs(numerator);
        long den = Math.abs(denominator);
        result.append(num / den);
        num %= den;
        if (num == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(num != 0) {
            num *= 10;
            result.append(num/den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                map.put(num, result.length());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,3));

        System.out.println(Short.MAX_VALUE);
    }

}
