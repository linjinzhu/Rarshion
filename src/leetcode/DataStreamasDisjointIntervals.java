package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by rarshion on 16/9/4.
 */
public class DataStreamasDisjointIntervals {


    public class SummaryRanges {

        class Interval {
            int start;
            int end;
            Interval() { start = 0; end = 0; }
            Interval(int s, int e) { start = s; end = e; }
        }

        private TreeSet<Interval> treeSet;

        public SummaryRanges() {
            treeSet  = new TreeSet<>(new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start;
                }
            });
        }

        //其实可考虑在左区间内与不在左区间两种情况
        public void addNum(int val) {//判断加入点的左右区间
            Interval interval = new Interval(val, val);
            Interval floor = treeSet.floor(interval);
            if(floor != null){//左区间
                if(floor.end >= val){//在左区间
                    return;
                }else if(floor.end + 1 == val){ //可合并左区间
                    interval.start = floor.start;
                    treeSet.remove(floor);
                }
            }

            Interval higher = treeSet.higher(interval);
            if(higher != null && val + 1 == higher.start){ //可合并右区间
                interval.end = higher.end;
                treeSet.remove(higher);
            }

            treeSet.add(interval);
        }

        public List<Interval> getIntervals() {
            return Arrays.asList(treeSet.toArray(new Interval[0]));
        }
    }

}
