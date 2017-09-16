package JavaSocket.test1;

import java.util.concurrent.*;

/**
 * Author ： Martin
 * Date : 17/8/14
 * Description :
 * Version : 2.0
 */
public class MultithreadFindMaxFinder {

    public static int max(int[] data) throws ExecutionException, InterruptedException {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException();
        }

        FindMaxTask task1 = new FindMaxTask(data, 0, data.length / 2);
        FindMaxTask task2 = new FindMaxTask(data, data.length / 2, data.length);
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);
        return Math.max(future1.get(), future2.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] data = {1, 2, 3, 6, 2, 4, 1, 2};
        System.out.println(max(data));
    }
}
