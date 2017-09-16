package JavaSocket.test1.test3;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Author ： Martin
 * Date : 17/8/15
 * Description :
 * Version : 2.0
 */
public class OReillyByName {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);
        InetAddress address1 = InetAddress.getByName("127.0.0.1");
        System.out.println(address1.getHostName());
        byte[] addressBytes = { 107, 23, (byte) 216, (byte) 196};
        InetAddress lessWrong = InetAddress.getByAddress(addressBytes);
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
        }
    }
}
