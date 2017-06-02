package leetcode;

/**
 * Author ： Martin
 * Date : 17/5/13
 * Description :
 * Version : 2.0
 */
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
//        StringBuilder s1 = new StringBuilder();
//        StringBuilder s2 = new StringBuilder();
//        helper(s1, s);
//        helper(s2, t);
//        return s1.toString().contains(s2.toString());
//

        if (s == null) return false;
        else return isSame(s.left, t) || isSame(s.right, t);
    }

    private void helper(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(",").append(root.val);
        helper(sb, root.left);
        helper(sb, root.right);
    }


    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
