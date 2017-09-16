package leetcode;

/**
 * Author ： Martin
 * Date : 17/8/24
 * Description :
 * Version : 2.0
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructHelper(nums, 0, nums.length - 1);
    }

    private TreeNode constructHelper(int[] nums, int start, int end) {
        if (start > end) return null;
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructHelper(nums, 0, index - 1);
        root.right = constructHelper(nums, index + 1, end);
        return root;
    }
}
