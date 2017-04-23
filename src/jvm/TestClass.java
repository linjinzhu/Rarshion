package jvm;

/**
 * Created by rarshion on 16/12/30.
 */
public class TestClass {
    private int m;
    public static int x;
    public int inc() {
        try {
            x = 200;
            throw new RuntimeException("ex");
        } catch (Exception ex) {
            x = 500;
            return x;
        } finally {
            x = 200;
        }
    }

    public static void main(String[] args) {
        TestClass test = new TestClass();
        System.out.println(test.inc());
        System.out.println(test.x);
    }
}
