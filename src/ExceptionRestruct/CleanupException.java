package ExceptionRestruct;

/**
 * Author ： Martin
 * Date : 17/6/14
 * Description :
 * Version : 2.0
 */
public class CleanupException extends RuntimeException {
    public CleanupException(Exception e) {
        super(e);
    }
}
