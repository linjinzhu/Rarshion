package JavaSocket.test1.test2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

/**
 * Author ： Martin
 * Date : 17/8/15
 * Description :
 * Version : 2.0
 */
public class LookupTask implements Callable<String> {

    private String line;

    public LookupTask(String line) {
        this.line = line;
    }

    @Override
    public String call() throws Exception {
        try {
            int index = line.indexOf(' ');
            String address = line.substring(0, index);
            String theRest = line.substring(index);
            String hostName = InetAddress.getByName(address).getHostName();
            return hostName + " " + theRest;
        } catch (UnknownHostException e) {
            return line;
        }
    }
}
