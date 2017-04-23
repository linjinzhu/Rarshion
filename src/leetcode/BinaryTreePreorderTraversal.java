package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rarshion on 16/8/19.
 */
public class BinaryTreePreorderTraversal {


    void preOrder(TreeNode node, List<Integer> list){
        if(null != node){
            list.add(node.val);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        if(null == root)
            return result;
        preOrder(root, result);
        return  result;
    }
}
