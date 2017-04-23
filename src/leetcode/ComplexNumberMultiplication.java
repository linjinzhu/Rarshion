package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/3
 * Description :
 * Version : 2.0
 */
public class ComplexNumberMultiplication {

    public static String complexNumberMultiply(String a, String b) {
        int signPos = a.indexOf('+');
        int numPos = a.indexOf('i');
        int s1 = Integer.parseInt(a.substring(0, signPos));
        int s2 = Integer.parseInt(a.substring(signPos + 1, numPos));
        signPos = b.indexOf('+');
        numPos = b.indexOf('i');
        int s3 = Integer.parseInt(b.substring(0, signPos));
        int s4 = Integer.parseInt(b.substring(signPos + 1, numPos));
        return String.format("%s+%si", (s1 * s3 - s2 * s4), (s1 * s4 + s2 * s3));
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
