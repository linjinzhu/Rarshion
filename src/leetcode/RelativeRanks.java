package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/18
 * Description :
 * Version : 2.0
 */
public class RelativeRanks {

    public static String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] array = new int[nums.length];
        System.arraycopy(nums,0, array, 0, nums.length);
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == array[j]) {
                    switch (j) {
                        case 0:
                            result[i] = "Gold Medal";
                            break;
                        case 1:
                            result[i] = "Silver Medal";
                            break;
                        case 2:
                            result[i] = "Bronze Medal";
                            break;
                        default:
                            result[i] = String.valueOf(j + 1);
                            break;
                    }
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] result = findRelativeRanks(new int[] {5, 4, 3, 2, 1});
        for (String str : result) {
            System.out.println(str);
        }
    }
}
