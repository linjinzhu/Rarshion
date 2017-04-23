package jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rarshion on 17/1/7.
 */
public class AtomicIntegerCompareTest {

    private int value;

    public AtomicIntegerCompareTest(int value) {
        this.value = value;
    }

    public synchronized  int increase() {
        return value++;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        AtomicIntegerCompareTest test = new AtomicIntegerCompareTest(0);
        for (int i = 0; i < 100000; i++) {
            test.increase();
        }

        long end = System.currentTimeMillis();
        System.out.println("time elapse:" + (end - start));


        start = System.currentTimeMillis();
        AtomicInteger testInt = new AtomicInteger(0);
        for (int i = 0; i < 100000; i++) {
            testInt.incrementAndGet();
        }
        end = System.currentTimeMillis();
        System.out.println("time elapse:" + (end - start));
    }


}
