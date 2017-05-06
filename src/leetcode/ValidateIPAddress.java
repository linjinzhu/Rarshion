package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/30
 * Description :
 * Version : 2.0
 */
public class ValidateIPAddress {

    public static String validIPAddress(String IP) {
        if (IP == null || IP.isEmpty()) return "Neither";
        if (IP.contains(".")) return isIPV4(IP) ? "IPv4" : "Neither";
        else return isIPV6(IP) ? "IPv6" : "Neither";
    }

    private static boolean isIPV6(String ip) {
        int dotCount = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == ':') dotCount++;
        }
        if (dotCount != 7) return false;
        String[] parts = ip.split(":");
        if (parts.length != 8) return false;
        for (String part : parts) {
            if (part == null || part.isEmpty()) return false;
            if (part.length() > 4) return false;
            for (int i = 0; i < part.length(); i++) {
                char ch = part.charAt(i);
                if (!((ch >= '0' && ch <= '9') || (ch>='a' && ch<='f') || (ch>='A' && ch<='F')))
                    return false;
            }
        }
        return true;
    }

    private static boolean isIPV4(String ip) {
        int dotCount = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == '.') dotCount++;
        }
        if (dotCount != 3) return false;
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;
        for (String part : parts) {
            if (part == null || part.isEmpty()) return false;
            if (part.length() > 3) return false;
            try {
                int value = Integer.parseInt(part);
                if (value > 255 || value < 0) return false;
                if ((part.charAt(0) == '0') && (value != 0 || part.length() > 1)) return false;
                if (part.charAt(0) > '9' || part.charAt(0) < '0') return false;
            } catch (Exception ex) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int test = Integer.parseInt("-0");
        System.out.println(test);
        //validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
    }

}
