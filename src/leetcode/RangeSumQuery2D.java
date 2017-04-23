package leetcode;

/**
 * Created by rarshion on 16/10/6.
 */
public class RangeSumQuery2D {

    public static class NumMatrix {

        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }


        public int sumRegion(int row1, int col1, int row2, int col2) {
            if ( row1 > row2 || col1 > col2) {
                return 0;
            }

            if ( row2 > matrix.length || col2 > matrix[0].length) {
                row2 = matrix.length;
                col2 = matrix[0].length;
            }

            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    sum += matrix[i][j];
                }
            }

            return sum;
        }
    }

    public  static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix nums = new NumMatrix(matrix);
        System.out.println (nums.sumRegion(2,1,4,3));
    }
}
