package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by rarshion on 16/11/10.
 */
public class NumberofBoomerangs {

    public int numberOfBoomerangs(int[][] points) {

        if (points.length < 3)
            return 0;

        int result = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++){

                if (i != j) {
                    int dis = distance(points[i], points[j]);
                    if (!map.containsKey(dis)) {
                        map.put(dis, 1);
                    } else {
                        map.put(dis, map.get(dis) + 1);
                    }
                }

                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int count = entry.getValue();
                    if (count >= 2) {
                        result += count * (count - 1);
                    }
                }
            }

        }

        return result;

    }

    public int distance(final int[] a, final int[] b) {
        int x = (a[0] - b[0]) * (a[0] - b[0]);
        int y = (a[1] - b[1]) * (a[1] - b[1]);
        return x + y;
    }
}
