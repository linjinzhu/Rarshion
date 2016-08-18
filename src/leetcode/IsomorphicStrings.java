package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rarshion on 16/8/12.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;

        if(s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map.containsKey(ch1)){
                if(map.get(ch1) != ch2)
                    return false;
            }else{
                if(set.contains(ch2))
                    return false;
                else{
                    map.put(ch1, ch2);
                    set.add(ch2);
                }
            }
        }

        return true;
    }
}
