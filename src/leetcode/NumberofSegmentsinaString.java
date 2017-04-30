package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/29
 * Description :
 * Version : 2.0
 */
public class NumberofSegmentsinaString {

    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] elems = s.split(" ");
        int result = 0;
        for (String str : elems) {
            if (str.length() != 0)
                result++;
        }
        return result;
    }
}
