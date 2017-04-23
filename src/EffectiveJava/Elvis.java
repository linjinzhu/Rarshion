package EffectiveJava;

/**
 * Created by rarshion on 16/11/7.
 */
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {}
    public static Elvis getInstance() {return INSTANCE;}
}
