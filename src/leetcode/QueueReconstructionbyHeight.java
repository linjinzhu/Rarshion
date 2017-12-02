package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rarshion on 16/10/3.
 */
public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> {
                    if (o1[0] != o2[0]) {
                        return -o1[0] + o2[0];
                    } else {
                        return o1[1] -  o2[1];
                    }
                }
        );

        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }

        return res.toArray(new int[people.length][]);
    }
}
