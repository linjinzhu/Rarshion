package leetcode;

/**
 * Created by user on 2016/8/5.
 */
public class IsSomeTree {

    public boolean isSameTree(TreeNode p, TreeNode q){

        if((null == p) && (null == q))
            return true;
        else if((null == p) || (null == q))
            return false;

        if(p.val != q.val)
            return false;
        else
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}