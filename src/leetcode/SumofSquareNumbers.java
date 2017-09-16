package leetcode;

/**
 * Author ： Martin
 * Date : 17/8/24
 * Description :
 * Version : 2.0
 */
public class SumofSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a  <= b) {
            int d = a * a + b  * b;
            if (d == c) return true;
            else if (d < c) a++;
            else b--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }
}
