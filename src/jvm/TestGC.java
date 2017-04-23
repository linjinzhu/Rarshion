package jvm;

/**
 * Created by user on 2016/8/2.
 */
public class TestGC {

    private static final int _1MB = 1024 * 1024;

    public void localvarGc1(){
        byte[]  a = new byte[6*1024*1024];
        System.gc();
    }

    public static void main(String[] args){
//        TestGC gc = new TestGC();
//        gc.localvarGc1();

        byte[] allocation1, allocation2, allocation3,allocation4;
        allocation1 = new byte[_1MB * 4];


    }
}
