package jvm;


/**
 * Created by rarshion on 17/1/3.
 */
public class FieldResolution {
    interface  InterfaceB {
        int A = 0;
    }

    interface Interface1 extends  InterfaceB {
        int A =1;
    }

    interface Interface2 {
        int A =2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
