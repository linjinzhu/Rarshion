package leetcode;

/**
 * Created by user on 2016/8/4.
 */
public class AddDigits {

    public static int split(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int addDigits(int num) {

        while(num >= 10){
            num = split(num);
        }

        return num;
    }

    public static void test(final String test){
        //test = "hello";
        System.out.println(test);
    }

    public static void main(String[] args){
        //System.out.println(addDigits(73));
        test("hello");
    }

}
