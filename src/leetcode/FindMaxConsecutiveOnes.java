package leetcode;

/**
 * Author ： Martin
 * Date : 17/3/18
 * Description :
 * Version : 2.0
 */
public class FindMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, max = 0;
        for (int elem : nums) {
            if (elem == 1)
                cnt++;
            else {
                max = Math.max(cnt, max);
                cnt = 0;
            }
        }
        max = Math.max(max, cnt);
        return max;
    }

    public static void main(String[] args) {
        int[] arrys = new int[] {1,1,0,1,1,1};
        int result = findMaxConsecutiveOnes(arrys);
        System.out.println(result);
    }
}
