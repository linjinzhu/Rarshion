package JavaSocket.test1.test2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author ： Martin
 * Date : 17/8/15
 * Description :
 * Version : 2.0
 */
public class PooledWebLog {
    private static final int THREAD_NUM = 4;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);
        Queue<LogEntry> results = new LinkedList<>();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"))) {
            for (String entry = in.readLine(); entry != null; entry = in.readLine()) {
                LookupTask task = new LookupTask(entry);
                Future<String> future = pool.submit(task);
                LogEntry result = new LogEntry(entry, future);
                results.add(result);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (LogEntry entry : results) {

        }
    }
}
