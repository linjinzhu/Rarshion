package leetcode;

import java.util.*;

/**
 * Author ： Martin
 * Date : 17/10/28
 * Description :
 * Version : 2.0
 */
public class SecondMinimumNodeInaBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            set.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(set);

        if (list.size() > 1) {
            return list.get(1);
        } else {
            return -1;
        }
    }
}
