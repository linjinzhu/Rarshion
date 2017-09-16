package leetcode;

/**
 * Author ： Martin
 * Date : 17/8/23
 * Description :
 * Version : 2.0
 */
public class ImageSmooth {
    public static int[][] imageSmoother(int[][] M) {
       int n = M.length;
        int m = M[0].length;
        int[][] dst = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                int cnt = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k < 0 || l < 0 || k >= n || l >= m) {
                            continue;
                        }
                        sum += M[k][l];
                        cnt++;
                    }
                }
                dst[i][j] = sum / cnt;
            }
        }
        return dst;
    }

    public static void main(String[] args) {
        int[][] temp = imageSmoother(new int[][] { {1,1,1}, {1,0,1}, {1,1,1}});
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                System.out.print(temp[i][j]);
            }
            System.out.println();
        }
    }
}
