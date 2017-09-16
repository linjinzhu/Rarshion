package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author ： Martin
 * Date : 17/9/4
 * Description :
 * Version : 2.0
 */
public class AddOneRowtoTree {

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }

        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            if (--d == 0) return root;
            for (int i = 0; i < queue.size(); ++i) {
                current = queue.peek();
                queue.poll();
                if (d == 1) {
                    TreeNode left = current.left;
                    TreeNode right = current.right;
                    TreeNode newLeft = new TreeNode(v);
                    TreeNode newRight = new TreeNode(v);
                    current.left = newLeft;
                    current.right = newRight;
                    newLeft.left = left;
                    newRight.right = right;
                } else {
                    if (current.left != null)
                        queue.offer(current.left);
                    if (current.right != null)
                        queue.offer(current.right);
                }
            }

        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        addOneRow(node1, 0, 0);

    }


}
