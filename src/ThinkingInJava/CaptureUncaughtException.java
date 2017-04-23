package ThinkingInJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rarshion on 16/9/14.
 */
public class CaptureUncaughtException {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactor());
        exec.execute(new ExceptionThread2());
    }

}
