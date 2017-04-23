package EffectiveJava;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rarshion on 16/11/10.
 */
public class BigGram {
    private final char first;
    private final char second;

    public BigGram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof  BigGram)) {
            return false;
        }
        BigGram b = (BigGram)o;
        return this.first == b.first && this.second == b.second;
    }

    public static void main(String[] args) {
        Set<BigGram> set = new HashSet<BigGram>();
        for (int i = 0; i < 10; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                set.add(new BigGram(c, c));
            }
        }
    }
}
