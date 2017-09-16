package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author ： Martin
 * Date : 17/9/10
 * Description :
 * Version : 2.0
 */
public class MagicDictionary {

    Map<Integer, List<String>> map;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        if (dict == null || dict.length == 0) {
            return;
        }

        for (String word : dict) {
            map.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int len = word.length();
        if (!map.containsKey(len)) {
            return false;
        }
        List<String> list = map.get(len);
        for (String elem : list) {
            if (valid(word, elem)) {
                return true;
            }
        }
        return false;
    }

    private boolean valid(String word, String dict) {
        int j = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == dict.charAt(i)) {
                j++;
            }
        }
        return j == word.length() - 1;
    }
}
