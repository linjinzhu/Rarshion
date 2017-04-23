package ThinkingInJava.Lock;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by rarshion on 16/9/26.
 */
public class ActiveObjectDemo {
    private ExecutorService ex = Executors.newSingleThreadExecutor();
    private Random random = new Random(47);

    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(factor));
        } catch (InterruptedException ex) {
            System.out.println("sleep() interrupted");
        }
    }

    public Future<Integer> calculateInt(final int x, final int y) {
        return ex.submit(new Callable<Integer>() {
            public Integer call() {
                System.out.println("starting " + x + " + " + y);
                pause(500);
                return x + y;
            }
        });
    }

    public Future<Float> calculateFload(final float x, final float y) {
        return ex.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.println("starting " + x + " + " + y);
                pause(2000);
                return x + y;
            }
        });
    }

    public void shutdown() {
        ex.shutdown();
    }

    public static void main(String[] args) {
        ActiveObjectDemo d1 = new ActiveObjectDemo();
        List<Future<?>> results = new CopyOnWriteArrayList<>();
        for(float f = 0.0f; f < 1.0f; f += 0.2f) {

        }
    }
}
