package leetcode;

/**
 * Created by rarshion on 16/10/27.
 */
public class SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 0;

        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val;

        if (root.right != null && (root.right.left != null || root.right.right != null))
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        
        return sumOfLeftLeaves(root.left);
    }
}
