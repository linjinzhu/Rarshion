import java.util.ArrayList;
import java.util.List;

/**
 * Author ： Martin
 * Date : 17/7/31
 * Description :
 * Version : 2.0
 */
public class RestoreIpAddressesExample {


    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() <= 0) return res;
        helper(s, 0, res, "", 0);
        return res;
    }

    public static void helper(String s, int begin, ArrayList<String> res, String path, int count) {
        if (count == 4 && begin == s.length()) {
            res.add(path);
            return;
        } else if (count == 4) {
            return;
        }

        for (int i = begin; i < begin + 3 && i < s.length(); i++) {
            String sub = s.substring(begin, i+1);
            if (Integer.parseInt(sub) <= 255) {
                if (i == begin || i-begin > 0 && sub.charAt(0) != '0') {
                    helper(s, i+1, res, path+sub+(count < 3 ? "." : ""), count+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = restoreIpAddresses("224255111352");
        System.out.println("aa121212".matches("[0-9]{1,}"));
    }

}
