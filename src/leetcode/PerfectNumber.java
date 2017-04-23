package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/3
 * Description :
 * Version : 2.0
 */
public class PerfectNumber {

    public static boolean checkPerfectNumber(int num) {

        if (num == 1)
            return false;

        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum +=  i + num/i;
            }
        }
        return num == sum;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
