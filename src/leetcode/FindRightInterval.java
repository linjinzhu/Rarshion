package leetcode;

/**
 * Created by rarshion on 16/11/3.
 */
public class FindRightInterval {

    class Interval {
      int start;
      int end;
      public Interval() {
          start = 0;
          end = 0;
      }
      public Interval(int s, int e) {
          start = s;
          end = e;
      }

      @Override
      public boolean equals(Object o) {
          if (o == null || !(o instanceof  Interval)) return false;
          Interval val = (Interval)o;
          return ((val.start == start && val.end == end));
      }
    }

    public int[] findRightInterval(Interval[] intervals) {
         return null;
    }

}
