package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author ： Martin
 * Date : 17/11/20
 * Description :
 * Version : 2.0
 */
public class SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
           if (isSelfDividing(i)) {
               result.add(i);
           }
        }
        return result;
    }

    private static boolean isSelfDividing(int elem) {
        int tmp = elem;
        int digit = 0;
        while (elem > 0) {
            digit = elem % 10;
            if ( digit == 0 || tmp % digit != 0) return false;
            elem /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }
}
