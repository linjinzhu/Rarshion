package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rarshion on 16/11/8.
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> repeatMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (repeatMap.containsKey(item)) {
                repeatMap.put(item, (repeatMap.get(item)) + 1);
            } else {
                repeatMap.put(item, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (repeatMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;

    }
}
