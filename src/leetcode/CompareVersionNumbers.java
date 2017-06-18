package leetcode;

/**
 * Author ： Martin
 * Date : 17/6/2
 * Description :
 * Version : 2.0
 */
public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
//        String[] strs1 = version1.split(".");
//        String[] strs2 = version2.split(".");
//
//        int len1 = strs1.length;
//        int len2 = strs2.length;
//        int i = 0, j = 0;
//
//        for (; i <len1 && j < len2; i++, j++) {
//            Integer i1 = Integer.parseInt(strs1[i]);
//            Integer i2 = Integer.parseInt(strs2[j]);
//            if (i1 > i2) {
//                return 1;
//            } else if (i1 < i2) {
//                return -1;
//            }
//        }
//
//        if (i == len1) {
//            return 1;
//        } else if (j == len2) {
//            return -1;
//        }
//
//        return 0;


        int val1 = 0, val2 = 0;
        int idx1 = 0, idx2 = 0;

        while (idx1 < version1.length() || idx2 < version2.length()) {

            val1 = 0;
            while (idx1 < version1.length()) {
                if (version1.charAt(idx1) == '.') {
                    ++idx1;
                    break;
                }
                val1 = val1 * 10 + (version1.charAt(idx1) - '0');
                ++idx1;
            }

            val2 = 0;
            while (idx2 < version2.length()) {
                if (version2.charAt(idx2) == '.') {
                    ++idx2;
                    break;
                }
                val2 = val2 * 10 + (version2.charAt(idx2) - '0');
                ++idx2;
            }

            if (val1 > val2) return 1;
            if (val1 < val2) return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));

        int a = 1, b = 2;
        System.out.println((a%b) * 10);
    }
}
