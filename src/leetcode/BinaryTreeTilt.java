package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/23
 * Description :
 * Version : 2.0
 */
public class BinaryTreeTilt {

    int sum = 0;

    public int findTilt(TreeNode root) {
        getHelper(root);
        return sum;
    }

    private int getHelper(TreeNode root) {
        if (root == null) return 0;
        int left = getHelper(root.left);
        int right = getHelper(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }
}
