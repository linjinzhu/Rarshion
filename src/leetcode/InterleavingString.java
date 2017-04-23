package leetcode;

/**
 * Created by rarshion on 16/9/24.
 */
public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int m =s1.length(), n = s2.length();

        if ((m + n) != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;


        for(int i = 0; i < m; i++){
            dp[i+1][0] = dp[i][0] && (s1.charAt(i) == s3.charAt(i));
        }

        for (int j = 0; j < n; j++) {
            dp[0][j+1] = dp[0][j] && (s2.charAt(j) == s3.charAt(j));
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i+1][j+1] = (dp[i][j+1] && (s1.charAt(i) == s3.charAt(i+j+1)))
                                    |  (dp[i+1][j] && (s2.charAt(j) == s3.charAt(i+j+1)));
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(dp[i][j] + "    ");
            }
            System.out.println();
        }


        return dp[m][n];
    }

    public static void main(String[] args){
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

}
