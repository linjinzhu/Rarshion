package jvm;

/**
 * Created by rarshion on 17/1/3.
 */
public class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.interrupted() + "init DeepLoopClass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dls = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);



    }
}
