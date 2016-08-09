package leetcode;

/**
 * Created by user on 2016/8/5.
 */
public class ExcelSheet {
    public int titleToNumber(String s) {
        int ret = 0;
        for(int i = 0; i < s.length(); i++){
            ret = (ret*26) + (s.charAt(i) - 'A' + 1);
        }
        return ret;
    }
}
