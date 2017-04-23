package leetcode;

import java.util.Arrays;

/**
 * Created by rarshion on 16/8/25.
 */
public class HIndex {
    public int hIndex(int[] citations) {

        int h = 0;
        if(null == citations)
            return h;

        Arrays.sort(citations);

        for(int i = citations.length - 1; i >= 0; i--){
            if(i >= citations[i])
                return i;
        }
        return citations.length;
    }
}
