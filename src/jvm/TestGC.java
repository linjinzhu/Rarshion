package jvm;

/**
 * Created by user on 2016/8/2.
 */
public class TestGC {
    public void localvarGc1(){
        byte[]  a = new byte[6*1024*1024];
        System.gc();
    }

    public static void main(String[] args){
        TestGC gc = new TestGC();
        gc.localvarGc1();
    }
}
