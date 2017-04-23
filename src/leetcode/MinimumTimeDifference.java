package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Author ： Martin
 * Date : 17/4/21
 * Description :
 * Version : 2.0
 */
public class MinimumTimeDifference {

    public static int findMinDifference(List<String> timePoints) {
        int[] timeRevert = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String timePoint = timePoints.get(i);
            String[] timePart  = timePoint.split(":");
            int hour = Integer.valueOf(timePart[0]);
            int min = Integer.valueOf(timePart[1]);
            int revert = hour * 60 + min;
            timeRevert[i] = revert;
        }
        Arrays.sort(timeRevert);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timeRevert.length; i++) {
            if (i < timeRevert.length - 1) {
                if (timeRevert[i + 1] - timeRevert[i] < min) {
                    min = timeRevert[i + 1] - timeRevert[i];
                }
            }  else {
                if (((timeRevert[0] + 24 * 60) - timeRevert[i]) < min) {
                    min = timeRevert[0] + 24 * 60 - timeRevert[i];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<String> temp = Arrays.asList("23:59", "00:00");
        System.out.println(findMinDifference(temp));
    }
}
