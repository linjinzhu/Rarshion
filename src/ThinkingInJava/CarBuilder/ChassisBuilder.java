package ThinkingInJava.CarBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by rarshion on 16/9/23.
 */
public class ChassisBuilder implements Runnable {

    private CarQueue carQueue;
    private int counter = 0;
    public ChassisBuilder(CarQueue queue){
        this.carQueue = queue;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                Car c = new Car(counter++);
                System.out.println("ChassisBuilder created "+c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Interrupted: ChassisBuilder");
    }

}
