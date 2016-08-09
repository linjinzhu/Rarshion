package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 2016/8/9.
 */
public class HappyNumber {

    public static long split(long n){
        long sum = 0, m = 0;
        while(n > 0){
            m = n %10;
            sum += m * m;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {

        if(n <= 0) return false;

        long ln = n;
        Set<Long> set = new HashSet<Long>();

        while(ln <= Integer.MAX_VALUE){
            if(set.contains(ln))
                return false;
            else
                set.add(ln);

            ln = split(ln);

            if(1 == ln)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(isHappy(50));

    }

}
