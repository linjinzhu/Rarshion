package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/9
 * Description :
 * Version : 2.0
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        if (x == y) return 0;
        String xBinaryStr = Integer.toBinaryString(x);
        String yBinaryStr = Integer.toBinaryString(y);
        int xLen = xBinaryStr.length();
        int yLen = yBinaryStr.length();
        String minStr = (xLen >= yLen ? yBinaryStr : xBinaryStr);
        String maxStr = (xLen >= yLen ? xBinaryStr : yBinaryStr);
        int minLen = Math.min(xLen, yLen);
        int maxLen = Math.max(xLen, yLen);
        int diffLen = maxLen - minLen;
        StringBuilder sb = new StringBuilder();
        while (diffLen > 0) {
            sb.append("0");
            diffLen--;
        }
        sb.append(minStr);
        minStr = sb.toString();

        int ret = 0;
        sb.append(minStr);
        for (int i = 0; i < maxLen; i++) {
            if (!(minStr.charAt(i) == maxStr.charAt(i))) {
                ret += 1;
            }
        }
        return ret;
    }

    public static int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += hammingDistance(i, j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(5));
//        System.out.println(Integer.toBinaryString(50));
        System.out.println(hammingDistance(1, 4));

    }


}
