package leetcode;

import java.text.ParseException;
import java.util.*;

/**
 * Created by rarshion on 16/10/6.
 */
public class LexicographicalNumbers {

    public static List<Integer> lexicalOrder(int n) {

        /*
        List<String> src = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            src.add(String.valueOf(i));
        }


        Collections.sort(src, (o1, o2) -> {

            String s1 = o1, s2 = o2;
            if (s1 == s2 || s1.equals(s2))
                return 0;

            int i, j;
            for (i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
                if (s1.charAt(i) > s2.charAt(j)) {
                    return 1;
                } else if(s1.charAt(i) < s2.charAt(j)) {
                    return -1;
                }
            }

            if (i < s1.length())
                return 1;

            if (j < s2.length())
                return -1;

            return 0;
        });

        List<Integer> dst = new ArrayList<>();
        for (int i = 0; i < src.size(); i++) {
            dst.add(Integer.parseInt(src.get(i)));
        }

        return dst;
        */

        List<Integer> result = new ArrayList<>();

        if (n < 1)
            return result;

        result.add(1);

        while (result.size() < n) {

            int lastNum = result.get(result.size() - 1);
            if (lastNum * 10 <= n) {
                result.add(lastNum * 10);
            } else {
                if ((lastNum + 1) % 10 == 0) {
                    result.add(divideNten(lastNum + 1));
                } else {
                    if (lastNum + 1 <= n) {
                        result.add(lastNum + 1);
                    } else {
                        result.add(lastNum / 10 + 1);
                    }
                }
            }

        }

        return result;
    }


    private static int divideNten(int n) {
        while (n%10 == 0) {
            n /= 10;
        }
        return n;
    }

    public static void main(String[] args) {
        List<Integer> temp = lexicalOrder(25);
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
    }
}
