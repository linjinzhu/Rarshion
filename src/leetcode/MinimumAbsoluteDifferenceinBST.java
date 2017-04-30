package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/23
 * Description :
 * Version : 2.0
 */
public class MinimumAbsoluteDifferenceinBST {

    int minDiff = Integer.MAX_VALUE;
    int prev = -1;

    public int getMinimumDifference(TreeNode root) {
        getHelper(root);
        return minDiff;
    }

    private void getHelper(TreeNode root) {
        if (root.left != null) getHelper(root.left);
        if (prev != -1) minDiff = Math.min(minDiff, Math.abs(prev - root.val));
        prev = root.val;
        if (root.right != null) getHelper(root.right);
    }

}


