package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/9
 * Description :
 * Version : 2.0
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int count = 0, duplicate = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    if (i != 0 && grid[i - 1][j] == 1) {
                        duplicate += 1;
                    }

                    if (i != grid.length - 1 && grid[i + 1][j] == 1) {
                        duplicate += 1;
                    }

                    if (j != 0 && grid[i][j - 1] == 1) {
                        duplicate += 1;
                    }

                    if (j != grid[0].length - 1 && grid[i][j + 1] == 1) {
                        duplicate += 1;
                    }
                }
            }
        }

        return count - duplicate;
    }
}
