package EffectiveJava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by rarshion on 16/11/10.
 */
public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(args[0]);

        /*
        for (Method m : testClass.getDeclaredAnnotations()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException ex) {

                } catch (Exception ex) {

                }
            }
        }
        */
    }
}
