package leetcode;

/**
 * Author ： Martin
 * Date : 17/11/27
 * Description :
 * Version : 2.0
 */
public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null && root.left.val == root.val) {
            res = 1 + dfs(root.left);
        }

        if (root.right != null && root.right.val == root.val) {
            res = 1 + dfs(root.right);
        }

        return Math.max(res, Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int res = 0;
        int val = node.val;

        if (node.left != null && node.left.val == val) {
            res = 1 + dfs(node.left);
        }

        if (node.right != null && node.right.val == val) {
            res = Math.max(res, 1 + dfs(node.right));
        }

        return res;
    }
}
