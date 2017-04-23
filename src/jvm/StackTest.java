package jvm;

/**
 * Created by rarshion on 16/12/31.
 */
public class StackTest {
    public static void main(String[] args) {
        byte i = 125;

        byte j = -128;

        int k = i + j;

        short a = 32767;

        short b = - 32768;

        int c = a + b;

        int x = 2147483647;

        int y = -2147483648;

        int z = x + y;

        long I = 2147483648L;

        long J = -2147483649L;

        long K = I + J;
    }
}
