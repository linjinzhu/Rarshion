package EffectiveJava;

import java.util.Iterator;
import java.util.List;

/**
 * Created by rarshion on 16/11/9.
 */
public class MaxFunction {
    public static <T extends Comparable<T>> T max(List<T> list) {
        Iterator<T> i = list.iterator();
        T result = i.next();
        while(i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }
}
