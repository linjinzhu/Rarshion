package JavaSocket.test1.test4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author ： Martin
 * Date : 17/8/20
 * Description :
 * Version : 2.0
 */
public class PooledDayTimeServer {
    public final static int PORT = 13;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(50);

        try (ServerSocket socket = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = socket.accept();
//                    Callable<Void> task =
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
