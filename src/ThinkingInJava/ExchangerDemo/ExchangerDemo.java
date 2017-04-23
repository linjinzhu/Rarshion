package ThinkingInJava.ExchangerDemo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * Created by rarshion on 16/9/22.
 */

class ExchangerProducer implements Runnable{

    private Exchanger<List<Integer>> exchanger;
    private List<Integer> holder;
    Random random = new Random();

    ExchangerProducer(Exchanger<List<Integer>> exchg, List<Integer> holder){
        this.exchanger = exchg;
        this.holder = holder;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                for(int i = 0; i < ExchangerDemo.size; i++){
                    holder.add(random.nextInt());
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

class ExchangerConsumer implements Runnable{

    private Exchanger<List<Integer>> exchanger;
    private List<Integer> holder;
    private volatile int value;
    ExchangerConsumer(Exchanger<List<Integer>> ex, List<Integer> holder){
        this.exchanger = ex;
        this.holder = holder;
    }

    @Override
    public void run() {
        try{

        } catch (Exception ex){

        }
    }
}



public class ExchangerDemo {

    static int size = 10;

}
