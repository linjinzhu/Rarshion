package jvm;

/**
 * Created by rarshion on 17/1/5.
 */
public class IntegerCache {

    static final int low = -128;
    static final int high;
    static final Integer cache[];

    static {
        int h = 127;
        String integerCacheHighProValue = sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        if (integerCacheHighProValue != null) {
            try {
                int i = Integer.parseInt(integerCacheHighProValue);
                i = Math.max(i, 127);
                h = Math.min(i, Integer.MAX_VALUE - (-low) - 1);
            } catch (NumberFormatException ex) {

            }
        }
        high = h;

        cache = new Integer[(high - low) + 1];
        int j = low;
        for (int k = 0; k < cache.length; k++) {
            cache[k] = new Integer(j++);
        }

        assert IntegerCache.high >= 127;
    }

    private IntegerCache() {}


    public static void main(String[] args) {

    }

}
