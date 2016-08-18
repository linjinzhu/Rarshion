package leetcode;

/**
 * Created by rarshion on 16/8/14.
 */
public class ReverseInteger {

    public static int reverse(int x) {

        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        int sum = 0;

        System.out.println(max + "  " + min);

        while(x != 0){
            sum = sum*10 + x%10;
            //if(sum > max || sum < min){
              //  sum = sum > 0? max:min;
                //return sum;
            //}
            x /= 10;
        }

        return sum;
    }

    public static void main(String[] args){
        System.out.println(reverse(-123));
    }

}
