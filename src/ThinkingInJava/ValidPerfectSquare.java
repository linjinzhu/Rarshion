package ThinkingInJava;

/**
 * Created by rarshion on 16/9/15.
 */
public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {

        /*
        int low = 0, high = 46340;

        while(low < high){
            int mid = (low + high) / 2;
            if(mid * mid == num)
                return true;
            else if(mid * mid > num){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low * low == num;
        */

        for(int i = 0; num > 0; i+=2){
            num -= i;
        }

        return 0==num;
    }

    public static void main(String[] args){
        System.out.println(isPerfectSquare(16));
    }

}
