package leetcode;

/**
 * Created by rarshion on 16/8/10.
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {

        if(n == 1)
            return 1;

        if(n == 2)
            return 2;

        return climbStairs(n-1) + climbStairs(n-2);

    }

    public static int climStairs1(int n){

        int a = 0, b = 1, sum = 0;

        for(int i = 1;i <= n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;

    }

    public static void main(String[] args){

       // System.out.println(climbStairs(44));
        System.out.println(climStairs1(44));

    }

}
