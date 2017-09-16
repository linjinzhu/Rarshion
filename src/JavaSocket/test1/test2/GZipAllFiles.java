package JavaSocket.test1.test2;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author ： Martin
 * Date : 17/8/15
 * Description :
 * Version : 2.0
 */
public class GZipAllFiles {
    private final static int THREAD_COUNT = 4;


    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (String fileName : args) {
            File f = new File(fileName);
            if (f.exists()) {
                if (f.isDirectory()) {
                    File[] files = f.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        if (!files[i].isDirectory()) {
                            Runnable task = new GZipRunnable(files[i]);
                            pool.submit(task);
                        }
                    }
                } else {
                    Runnable task = new GZipRunnable(f);
                    pool.submit(task);
                }
            }
            pool.shutdown();
        }
    }


}
