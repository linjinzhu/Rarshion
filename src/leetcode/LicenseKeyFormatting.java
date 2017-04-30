package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/29
 * Description :
 * Version : 2.0
 */
public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {
        if (S == null || S.isEmpty()) return "";
        S = S.toUpperCase();
        String srcStr = "";
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '-') srcStr += S.charAt(i);
        }
        int len = srcStr.length();
        int i = len % K;
        String retStr = srcStr.substring(0, i);
        for (int j = 0; j < len / K; j++) {
            if (i != 0) retStr += '-';
            retStr += srcStr.substring(i, i + K );
            i += K;
        }
        return retStr;
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("2-4A0r7-4k", 4));
    }
}
