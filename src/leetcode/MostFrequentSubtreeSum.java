package leetcode;

import java.util.*;

/**
 * Author ： Martin
 * Date : 17/4/15
 * Description :
 * Version : 2.0
 */
public class MostFrequentSubtreeSum {

    private int maxCount = 0;
    private HashMap<Integer, Integer> sum2Map = new HashMap<>();

    private int help(TreeNode root) {
        if (root == null) return 0;
        int left = help(root.left);
        int right = help(root.right);
        int sum = left + right + root.val;
        int count = sum2Map.getOrDefault(sum, 0) + 1;
        maxCount = count > maxCount ? count : maxCount;
        sum2Map.put(sum, count);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        help(root);
        Set<Map.Entry<Integer, Integer>> sumSet = sum2Map.entrySet();
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> item : sumSet) {
            if (item.getValue() == maxCount) {
                result.add(item.getKey());
            }
        }
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.indexOf(i);
        }
        return ret;
    }
}
