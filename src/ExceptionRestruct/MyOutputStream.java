package ExceptionRestruct;

import java.io.IOException;

/**
 * Author ： Martin
 * Date : 17/6/14
 * Description :
 * Version : 2.0
 */
public class MyOutputStream implements AutoCloseable {
    @Override
    public void close() throws Exception {
        try {
            System.out.println("MyOutputStreamClose");
            throw new IOException();
        } catch (Exception e) {
            throw new CleanupException(e);
        }
    }
}
