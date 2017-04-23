package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/21
 * Description :
 * Version : 2.0
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int sum = 0;
        char[] chArr = word.toCharArray();

        if (chArr[0] >= 'a' && chArr[0] <= 'z') {
            if (chArr.length == 1) return true;
            for (int i = 1; i < chArr.length; i++) {
                if (!((chArr[i] >='a') && (chArr[i] <= 'z')))
                    return false;
            }
        } else if (chArr[0] >= 'A' && chArr[0] <= 'Z') {
            if (chArr.length == 1) return true;
            for (int i = 1; i < chArr.length; i++) {
                if (chArr[i] >= 'A' && chArr[i] <= 'Z') sum++;
            }
            if (sum == 0 || sum == chArr.length - 1)
                return true;
            else
                return false;
        }

        return true;
    }

}
