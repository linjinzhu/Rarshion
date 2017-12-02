package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author ： Martin
 * Date : 17/10/29
 * Description :
 * Version : 2.0
 */
public class TwoSumIVInputisaBST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int x = 0, y = list.size() - 1;
        while (x < y) {
            if (list.get(x) + list.get(y) == k) {
                return true;
            } else if (list.get(x) + list.get(y) < k) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }


    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inOrder(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            inOrder(root.right, list);
        }
    }


}
