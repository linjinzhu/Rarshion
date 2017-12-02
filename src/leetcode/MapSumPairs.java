package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/12/2
 * Description :
 * Version : 2.0
 */
public class MapSumPairs {

    private final Map<String, Integer> sumMap;

    /** Initialize your data structure here. */
    public MapSum() {
         sumMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        sumMap.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : sumMap.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSumPairs mapSumPairs = new MapSumPairs();
    }
}
