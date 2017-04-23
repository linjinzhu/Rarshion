package ThinkingInJava.SemaphoreDemo;

import java.util.concurrent.TimeUnit;

/**
 * Created by rarshion on 16/9/22.
 */
class CheckoutTask<T> implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;
    public CheckoutTask(Pool<T> pool){
        this.pool = pool;
    }

    public void run(){
        try{
            T item = pool.checkOut();
            System.out.print(this + "checked out" + item);
            TimeUnit.SECONDS.sleep(1);
            pool.checkIn(item);
        } catch (InterruptedException ex){

        }
    }

    public String toString(){
        return "CheckoutTask id: " + id + " ";
    }
}