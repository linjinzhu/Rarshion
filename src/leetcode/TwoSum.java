package leetcode;

/**
 * Created by user on 2016/8/5.
 */
public class TwoSum {

    public static int getSum(int a, int b){

        while(b > 0){
            int carry = a  & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args){
        System.out.println(getSum(5,11));
    }

}
