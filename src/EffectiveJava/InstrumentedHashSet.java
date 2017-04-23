package EffectiveJava;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by rarshion on 16/11/8.
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet(){

    }

    public InstrumentedHashSet(int initCap, int loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}
