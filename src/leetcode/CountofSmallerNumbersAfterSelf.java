package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rarshion on 16/9/27.
 */
public class CountofSmallerNumbersAfterSelf {

    private class TreeNode{
        public int val;
        public int count = 1;
        public TreeNode left, right;

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        TreeNode root = new TreeNode(nums[nums.length - 1]);
        result.add(0);

        for (int i =  nums.length - 2; i >= 0; i--) {
            int count = addNode(root, nums[i]);
            result.add(count);
        }

        Collections.reverse(result);
        return result;
    }

    private int addNode(TreeNode root, int val) {
        int curCount = 0;
        while (true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                curCount += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return curCount;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{5, 2, 6, 1, 7, 8, 10, 3};
        CountofSmallerNumbersAfterSelf self = new  CountofSmallerNumbersAfterSelf();
        List<Integer> result = self.countSmaller(temp);
        result.forEach(System.out::println);
    }

}
