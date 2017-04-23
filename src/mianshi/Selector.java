package mianshi;

/**
 * Author ： Martin
 * Date : 17/4/10
 * Description :
 * Version : 2.0
 */
public interface Selector {
    boolean end();
    Object current();
    void next();
}
