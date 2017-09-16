package leetcode;

/**
 * Author ： Martin
 * Date : 17/8/5
 * Description :
 * Version : 2.0
 */
public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {

        int[] res = new int[2];

        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                res[0] = Math.abs(i);
            } else {
                nums[Math.abs(i) - 1]  *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] dst = findErrorNums(new int[] {1, 2, 2, 4});
        for (int elem : dst) {
            System.out.println(elem);
        }
    }

}
