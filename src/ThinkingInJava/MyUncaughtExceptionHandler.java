package ThinkingInJava;

/**
 * Created by rarshion on 16/9/14.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught" + e);
    }
}
