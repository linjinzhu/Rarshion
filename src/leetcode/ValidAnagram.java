package leetcode;

import java.util.Arrays;

/**
 * Created by user on 2016/8/5.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        /*
        boolean flag = false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return String.valueOf(sArray).equals(String.valueOf(tArray));
        */


        if(s.length() != t.length())
            return false;

        int bit[] = new int[26], len = s.length();

        for(int i = 0; i < bit.length; i++){
            bit[i] = 0;
        }

        for(int i = 0; i < len; i++){
            bit[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < len; i++){
            if(--bit[t.charAt(i) - 'a'] < 0)
                return false;
        }

        return true;
    }
}
