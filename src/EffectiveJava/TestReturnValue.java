package EffectiveJava;

import java.util.Collections;
import java.util.List;

/**
 * Created by rarshion on 16/11/11.
 */
public class TestReturnValue {

    private static List<Object> getList() {
        return Collections.EMPTY_LIST;
        //return null;
    }

    public static void main(String[] args) {
        List<Object> temp = getList();
        for (Object item : temp) {

        }
    }
}
