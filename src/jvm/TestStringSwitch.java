package jvm;

/**
 * Created by rarshion on 16/12/31.
 */
public class TestStringSwitch {

    public int testReturn() {
        String test = "d";
        switch(test) {
            case "a" :
                return 0;
            case "b" :
                return 1;
            case "c" :
                return 2;
            default:
                return 3;
        }
    }
}
