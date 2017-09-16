package leetcode;

/**
 * Author ： Martin
 * Date : 17/7/1
 * Description :
 * Version : 2.0
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 != null && t2 == null)
            return t1;

        if (t2 != null && t1 == null)
            return t2;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t2.right, t2.right);
        return t1;
    }



}
