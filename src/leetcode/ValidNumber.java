package leetcode;

/**
 * Created by rarshion on 16/10/21.
 */
public class ValidNumber {

    public boolean isNumber(String s) {

        if (s == null || s.length() == 0) return false;

        int index = 0;

        while (index < s.length() && s.charAt(index) == ' ') index++;

        boolean space = false;
        boolean exp = false;
        boolean dot = false;
        boolean number = false;
        boolean neg = false;

        for (; index < s.length(); index++) {

            char c = s.charAt(index);

            if (c == ' ') {
                space = true;
            } else if (space == true) {
                return false;
            } else if ((c == 'e' || c == 'E') && exp ==false && number == true) {
                exp = true;
                number = false;
                dot = true;
                neg = false;
            } else if (c == '.' && dot == false) {
                dot = true;
                neg = true;
            } else if (c >= '0' && c <= '9') {
                number = true;
            } else if ((c == '+' || c == '-') && neg == false && number == false) {
                neg = true;
            } else {
                return false;
            }
        }

        return number;


    }

}
