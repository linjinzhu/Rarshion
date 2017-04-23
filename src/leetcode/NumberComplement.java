package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/9
 * Description :
 * Version : 2.0
 */
public class NumberComplement {

    public int findComplement(int num) {
        int temp = num, mask = 1;
        while (temp > 0) {
            temp >>= 1;
            mask <<= 1;
        }
        return (mask - 1) ^ num;
    }
}
