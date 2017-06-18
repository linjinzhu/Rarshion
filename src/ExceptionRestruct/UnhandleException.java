package ExceptionRestruct;

/**
 * Author ： Martin
 * Date : 17/6/16
 * Description :
 * Version : 2.0
 */
public class UnhandleException extends RuntimeException {

    public UnhandleException() {
        super();
    }

    public UnhandleException(Throwable e) {
        super(e);
    }

    public UnhandleException(String msg) {
        super(msg);
    }

    public UnhandleException(String msg, Throwable e) {
        super(msg, e);
    }

}
