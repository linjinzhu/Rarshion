package leetcode;

/**
 * Author ： Martin
 * Date : 17/10/20
 * Description :
 * Version : 2.0
 */
public class MaxAreaofIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, i, j));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + dfs(grid, i, j + 1) + dfs(grid, i, j - 1)
                    + dfs(grid, i + 1, j) + dfs(grid, i - 1, j);
        }
        return 0;
    }
}
