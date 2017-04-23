package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/21
 * Description :
 * Version : 2.0
 */
public class StudentAttendanceRecordI {

    public static boolean checkRecord(String s) {
        int absentCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i  < chars.length; i++) {
            if (chars[i] == 'A') absentCount++;
            if (i > 1 && chars[i] == 'L'
                    && (chars[i] == chars[i-1])
                    && (chars[i - 1] == chars[i - 2])) return false;
            if (absentCount > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }
}
