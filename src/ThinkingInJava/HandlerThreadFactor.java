package ThinkingInJava;

import java.util.concurrent.ThreadFactory;

/**
 * Created by rarshion on 16/9/14.
 */
public class HandlerThreadFactor implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        System.out.println("eh= " + t.getUncaughtExceptionHandler());
        return t;
    }
}
