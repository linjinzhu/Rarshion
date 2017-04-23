package leetcode;

import java.util.*;

/**
 * Author ： Martin
 * Date : 17/3/19
 * Description :
 * Version : 2.0
 */
public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            int temp = queue.peek().val;
            if (queue.peek().left != null) {
                queue.offer(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.offer(queue.peek().right);
            }
            queue.poll();
            for (int i = 1; i < levelNum; i++) {
                if (queue.peek().val > temp) temp = queue.peek().val;
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                queue.poll();
            }
            result.add(temp);
        }

        return result;
    }
}
