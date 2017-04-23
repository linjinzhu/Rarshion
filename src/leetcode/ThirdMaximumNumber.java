package leetcode;

import static java.lang.Long.MIN_VALUE;

public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        long first = MIN_VALUE, second = MIN_VALUE, third = MIN_VALUE;

        for (int item : nums) {
            if (item > first) {
                third = second;
                second = first;
                first = item;
            } else if (item < first && item > second) {
                third = second;
                second = item;
            } else if (item < second && item > third) {
                third = item;
            }
        }

        return (int) ((third == MIN_VALUE || third == second) ? first : third);
    }

    public static void main(String[] args) {
        int[] temp = {1,2,3};
        System.out.println(thirdMax(temp));
    }
}
