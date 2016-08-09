package leetcode;

/**
 * Created by user on 2016/8/6.
 */
public class HammingWeight {

    public static int hammingWeight(int n){

        int left = 0, ret = 0;

        while(n > 0){
            left = n & 0x01;
            ret += left;
            n >>= 1;
        }

        return ret;
    }

    public static void main(String[] args){
        System.out.println(hammingWeight(5));
    }
}
