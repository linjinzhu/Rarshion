package ExceptionRestruct;

import java.io.FileNotFoundException;

/**
 * Author ： Martin
 * Date : 17/6/14
 * Description :
 * Version : 2.0
 */
public class MyInputStream implements AutoCloseable {
    @Override
    public void close() throws Exception {
        try {
            System.out.println("MyInputStreamClose");
            throw new FileNotFoundException();
        } catch (Exception e) {
            throw new CleanupException(e);
        }
    }
}
