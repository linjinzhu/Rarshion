package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author ： Martin
 * Date : 17/6/2
 * Description :
 * Version : 2.0
 */
public class Matrix01 {

    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int row = cell[0] + d[0];
                int col = cell[1] + d[1];
                if (row < 0 || row >= m || col < 0 || col >= n) {
                    continue;
                }
                int value = matrix[row][col];
                int tmp = matrix[cell[0]][cell[1]] + 1;
                if (value <= tmp) continue;
                queue.offer(new int[]{row, col});
                matrix[row][col] = tmp;
            }
        }

        return matrix;

    }

    public static void main(String[] args) {
        int[][] test = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        updateMatrix(test);
    }
}
