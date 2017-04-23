package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/4/22
 * Description :
 * Version : 2.0
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                charToIndex.put(c, i);
            }
        }

        List<String> result = new ArrayList<>();
        for (String str : words) {
            if (str == null || str.isEmpty()) continue;
            boolean found = true;
            Integer index = charToIndex.get(str.toUpperCase().charAt(0));
            for (char c : str.toUpperCase().toCharArray()) {
                if (index != null && charToIndex.get(c) != index) {
                    found = false;
                    break;
                }
            }
            if (found) result.add(str);
        }

        String[] resultStr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultStr[i] = result.get(i);
        }

        return resultStr;
    }
}
