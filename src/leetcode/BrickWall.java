package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/9/19
 * Description :
 * Version : 2.0
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = wall.size();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                int num = map.getOrDefault(sum, 0);
                map.put(sum, ++num);
                min = Math.min(min, wall.size() - num);
            }
        }
        return min;
    }
}
