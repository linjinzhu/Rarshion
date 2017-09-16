package leetcode;

import java.util.Arrays;

/**
 * Author ： Martin
 * Date : 17/9/10
 * Description :
 * Version : 2.0
 */
public class MaximumLengthofPairChain {

    private static class Pair implements Comparable<Pair> {
        private int left;
        private int right;

        public Pair(int left, int right) {
                this.left = left;
                this.right = right;
            }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        @Override
        public int compareTo(Pair o) {
            return this == o ? 0 : this.getLeft() > this.getRight() ? -1 : 1;
        }

        public Boolean equals(Pair o) {
            return this == o || (this.getLeft() == o.getLeft() && this.getRight() == o.getRight());
        }

//       if (pairs == null || pairs.length == 0) {
//            return 0;
//        }
//
//        Set<Pair> pairSet = new TreeSet<>();
//        for (int i = 0; i < pairs.length; i++) {
//            pairSet.add(new Pair(pairs[i][0], pairs[i][1]));
//        }

    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int len = pairs.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] temp = new int[][] {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(temp));
    }
}
