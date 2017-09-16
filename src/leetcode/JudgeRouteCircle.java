package leetcode;

/**
 * Author ： Martin
 * Date : 17/8/19
 * Description :
 * Version : 2.0
 */
public class JudgeRouteCircle {


    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }

        if (moves.length() == 1) {
            return false;
        }

        int u = 0, d = 0, l = 0, r = 0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            switch (ch) {
                case 'u':
                case 'U': u++; break;
                case 'd':
                case 'D': d++; break;
                case 'l':
                case 'L': l++; break;
                case 'r':
                case 'R': r++; break;
            }
        }

        return u == d && l == r;
    }
}
