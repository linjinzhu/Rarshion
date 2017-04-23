package ThinkingInJava.CarBuilder;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by rarshion on 16/9/23.
 */
public class Assembler implements Runnable{

    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool robotPool;

    public Assembler(CarQueue cq, CarQueue fq, RobotPool rp) {
        chassisQueue = cq;
        finishingQueue = fq;
        robotPool = rp;
    }

    public Car car(){
        return car;
    }

    public CyclicBarrier barrier(){
        return barrier;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car = chassisQueue.take();

            }

        } catch (Exception ex) {

        }

        System.out.print("Assembler off");
    }

}
