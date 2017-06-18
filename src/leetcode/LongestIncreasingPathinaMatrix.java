package leetcode;

/**
 * Author ： Martin
 * Date : 17/6/18
 * Description :
 * Version : 2.0
 */
public class LongestIncreasingPathinaMatrix {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int[][] mem = new int[matrix.length][matrix[0].length];
        int longest = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longest = Math.max(longest, dfs(mem, i, j, matrix));
            }
        }

        return longest;
    }


    private int dfs(int[][] mem, int i, int j, int[][] matrix) {

        if (mem[i][j] != 0)
            return mem[i][j];

        for (int index = 0; index < 4; index++) {
            int x = i + dx[index];
            int y = j + dy[index];

            if (x >= 0 && y >= 0
                    && x < matrix.length
                    && y < matrix[0].length
                    && matrix[x][y] > matrix[i][j]) {
                mem[i][j] = Math.max(mem[i][j], dfs(mem, x, y, matrix));
            }
        }

        return ++mem[i][j];

    }
}
