package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author ： Martin
 * Date : 17/4/21
 * Description :
 * Version : 2.0
 */
public class FindModeinBinarySearchTree {

    Integer prev;
    int count = 1, max = 0;

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (prev == root.val) count++;
            else count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }


}
