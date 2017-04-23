package leetcode;

/**
 * Created by rarshion on 16/8/21.
 */
public class Searcha2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 || matrix[0].length == 0)
            return false;

        int i = 0, j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0){
            int elem = matrix[i][j];
            if(target == elem)
                return true;
            else if(target < elem)
                --j;
            else
                ++i;
        }

        return false;
    }

}
