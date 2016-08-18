package leetcode;

/**
 * Created by rarshion on 16/8/14.
 */
public class CountingBits {

    public static int count(int num){

        int ret = 0;

        while(num != 0){
            int candy = num & 0x01;
            if(candy == 1)
                ret++;
            num >>= 1;
        }

        return ret;
    }


    public static int[] countBits(int num) {

        int[] count = new int[num+1];

        for(int i = 0; i <= num; i++){
            count[i] = count(i);
        }

        return count;
    }

    public static void main(String[] args){
        //System.out.println(count(16));

        int[] ret = countBits(5);
        for(int i = 0; i < ret.length; i++){
            System.out.println(ret[i]);
        }

    }
}
