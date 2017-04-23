package leetcode;

/**
 * Created by rarshion on 16/9/13.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        if(s.length() == 0)
            return true;

        if(t.length() == 0 && s.length() > 0)
            return false;

        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){

            if(s.charAt(i) == t.charAt(j))
                i++;

            if(i >= s.length())
                return true;

            j++;
        }
        return false;
    }
}
