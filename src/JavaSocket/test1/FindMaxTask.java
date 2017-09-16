package JavaSocket.test1;

import java.util.concurrent.Callable;

/**
 * Author ： Martin
 * Date : 17/8/14
 * Description :
 * Version : 2.0
 */
public class FindMaxTask implements Callable<Integer> {

    private int[] data;
    private int start;
    private int end;


    FindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if ( data[i] > max) max = data[i];
        }
        return max;
    }
}
