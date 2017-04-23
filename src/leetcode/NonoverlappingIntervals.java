package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by rarshion on 16/11/5.
 */
public class NonoverlappingIntervals {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    class IntervalCompator implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            Interval i1 = (Interval) o1;
            Interval i2 = (Interval) o2;
            return i1.start - i2.start;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new IntervalCompator());

        int ret = 0;
        int last = intervals[0].end;

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i].start >= last) {
                last = intervals[i].end;
                continue;
            }

            if (intervals[i].end >= last) {
                ret++;
            } else {
                ret++;
                last = intervals[i].end;
            }
        }

        return ret;

    }
}
