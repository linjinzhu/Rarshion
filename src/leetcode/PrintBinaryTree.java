package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author ： Martin
 * Date : 17/11/22
 * Description :
 * Version : 2.0
 */
public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        int high = computeHigh(root);
        int column = (int) (Math.pow(2, high) - 1);
        int row = high;
        List<List<String>> result = new ArrayList(row);
        for (int i = 0; i < row; i++) {
            List<String> elem = new ArrayList(column);
            for (int j = 0; j < column; j++) {
                elem.add("");
            }
            result.add(elem);
        }
        DFS(root, result, 0, 0, column);
        return result;
    }

    private int computeHigh(TreeNode root) {
        if (root == null) return 0;
        return Math.max(computeHigh(root.left), computeHigh(root.right)) + 1;
    }

    private void DFS(TreeNode root, List<List<String>> result, int depth, int l, int r) {
        int mid = (l + r) / 2;
        result.get(depth).set(mid, String.valueOf(root.val));
        if (root.left != null) {
            DFS(root.left, result, depth + 1, l, mid - 1);
        }
        if (root.right != null) {
            DFS(root.right, result, depth + 1, mid + 1, r);
        }
    }

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            List<String> elem = new ArrayList<>(3);
            for (int j = 0; j < 3; j++) {
                elem.add("111");
            }
            result.add(elem);
        }
        System.out.println(result.toString());
    }
}
