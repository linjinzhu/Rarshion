package ExceptionRestruct;

import java.sql.SQLException;

/**
 * Author ： Martin
 * Date : 17/6/14
 * Description :
 * Version : 2.0
 */
public class MyConnectionException implements AutoCloseable {

    @Override
    public void close() throws Exception {
        try {
            System.out.println("MyConnectionClose");
            throw new SQLException();
        } catch (Exception e) {
            throw new CleanupException(e);
        }
    }
}
