package JavaSocket.test1.test2;

import java.util.concurrent.Future;

/**
 * Author ： Martin
 * Date : 17/8/15
 * Description :
 * Version : 2.0
 */
public class LogEntry {
    String original;
    Future<String> future;

    LogEntry(String original, Future<String> future) {
        this.original = original;
        this.future = future;
    }
}
