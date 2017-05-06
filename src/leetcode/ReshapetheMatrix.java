package leetcode;

/**
 * Author ： Martin
 * Date : 17/5/6
 * Description :
 * Version : 2.0
 */
public class ReshapetheMatrix {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        if (nums == null || nums.length == 0) return null;
        int sr = nums.length;
        int sc = nums[0].length;
        if (sr * sc != r * c) return nums;
        int[][] dst = new int[r][c];
        int[] array = new int[sr * sc];

        int f = 0;
        for (int[] i : nums) {
            System.arraycopy(i, 0, array, f, i.length);
            f += i.length;
        }

        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dst[i][j] = array[index++];
            }
        }

        return dst;
    }

    public static void main(String[] args) {
         int[][] temp = new int[][] {{1, 2}, {3, 4}};
         int[][] test = matrixReshape(temp, 1, 4);
    }

}
