package leetcode;

/**
 * Created by user on 2016/8/9.
 */
public class PowerofThree {

    public static boolean isPowerOfThree(int n) {
        if(n == 0)
            return false;
        else if(n == 1)
            return true;

        while(n != 3 && n%3 == 0)
            n /= 3;

        if(n == 3)
            return true;
        else
            return false;
    }



    public static boolean isPowerOfFour(int n) {
        if(n == 0)
            return false;
        else if(n == 1)
            return true;

        while(n != 4 && n%4 == 0)
            n /= 4;

        if(n == 4)
            return true;
        else
            return false;
    }



    public static void main(String[] args){

        //System.out.println(isPowerOfThree(9));

        //System.out.println(isPowerOfFour(9));
    }
}
