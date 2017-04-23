package ThinkingInJava;

/**
 * Created by rarshion on 16/9/13.
 */
public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for liftOff");
    }
}
