package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/3
 * Description :
 * Version : 2.0
 */
public class FindBottomLeftTreeValue {
    int maxDepth, result;

    public void findValueHelper(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            result = root.val;
        }
        findValueHelper(root.left, depth + 1);
        findValueHelper(root.right, depth + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        maxDepth = 0;
        findValueHelper(root, 1);
        return result;
    }
}
