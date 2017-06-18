package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/6/17
 * Description :
 * Version : 2.0
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int key = 0;
        for (int i = 0; i < s.length(); i++) {
            key = ((key << 3) | (s.charAt(i) & 0x7)) & 0x3fffffff;
            if (i < 9) continue;
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else if (map.get(key) == 1) {
                result.add(s.substring(i - 9, i + 1));
                map.put(key, 2);
            }
        }

        return result;
    }
}
