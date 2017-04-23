package ThinkingInJava.Lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by rarshion on 16/9/26.
 */
public class ReaderWriterList<T> {
    private ArrayList<T> lockedList;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);


    public ReaderWriterList(int size, T initialValue) {
        lockedList = new ArrayList<>(Collections.nCopies(size, initialValue));
    }

    public T set(int index, T element) {
        Lock wLock =  this.lock.writeLock();
        wLock.lock();
        try {
            return lockedList.set(index, element);
        } finally {
            wLock.unlock();
        }
    }

    public T get(int index) {
        Lock rLock = lock.readLock();
        rLock.lock();
        try {
            if(lock.getReadLockCount() > 1) {
                System.out.println(lock.getReadHoldCount());
            }
            return lockedList.get(index);
        } finally {
             rLock.unlock();
        }
    }

}
