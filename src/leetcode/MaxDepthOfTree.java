package leetcode;

/**
 * Created by user on 2016/8/4.
 */
public class MaxDepthOfTree {

    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int res = 1;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ?  l+1 : r+1;
    }

}
