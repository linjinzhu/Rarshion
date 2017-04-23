package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/3
 * Description :
 * Version : 2.0
 */
public class ConvertBSTtoGreaterTree {

    int sum;
    public void convertBSTHelper(TreeNode root) {
        if (root == null) return;
        convertBSTHelper(root.right);
        root.val = sum + root.val;
        sum = root.val;
        convertBSTHelper(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        sum = 0;
        convertBSTHelper(root);
        return root;
    }
}
