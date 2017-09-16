package JavaSocket.test1.test2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Author ： Martin
 * Date : 17/8/15
 * Description :
 * Version : 2.0
 */
public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";



    private static boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octed : quad) {
                int unsignedByte = octed < 0 ? octed + 256 : octed;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
