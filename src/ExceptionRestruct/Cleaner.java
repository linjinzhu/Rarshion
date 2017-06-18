package ExceptionRestruct;

import java.util.Stack;

/**
 * Author ： Martin
 * Date : 17/6/15
 * Description :
 * Version : 2.0
 */
public class Cleaner {
    private Stack<AutoCloseable> stack;
    private Throwable leadException;
    private CleanupException outgoingCleanupException;

    private Cleaner() {
        stack = new Stack<>();
        leadException = null;
        outgoingCleanupException = null;
    }

    public static  Cleaner newInstance() {
        return new Cleaner();
    }

    public <T extends AutoCloseable> T push(T obj) {
        return (T) stack.push(obj);
    }

    public void setLeadException(Throwable lead) {
        leadException = lead;
    }

    public void clear() {

    }
}
