package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/18
 * Description :
 * Version : 2.0
 */
public class DiameterofBinaryTree {

    private int max = 0;

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
}
