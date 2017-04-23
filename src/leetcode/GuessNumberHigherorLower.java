package leetcode;

/**
 * Created by rarshion on 16/10/28.
 */
public class GuessNumberHigherorLower {
    private int guess(int n) {
        return 0;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left  + (right - left) / 2, t = guess(mid);
            if (t == 0) return mid;
            else if (t == 1) left = mid;
            else right = mid;
        }
        return left;
    }

}
