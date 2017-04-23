package leetcode;

/**
 * Created by rarshion on 16/11/21.
 */
public class RSA {
    public static void main(String[] args) {

        long t = 1;
        while (t< Integer.MAX_VALUE) {
            if ((41 * t - 1)%3248 == 0) {
                System.out.println(t);
            }
            t++;
        }
    }

}
