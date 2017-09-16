package JavaSocket.test1.test5;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author ： Martin
 * Date : 17/8/18
 * Description :
 * Version : 2.0
 */
public class DayTimeClient {


    public static Date getDateFromNetwork() throws IOException, ParseException {
        try (Socket socket = new Socket("time.nist.gov", 13)) {
            socket.setSoTimeout(150000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            return parseDate(time.toString());
        }
    }

    private static Date parseDate(String s) throws ParseException {
        String[] pieces = s.split(" ");
        String dateTime = pieces[1] + " " + pieces[2]  + " UTC";
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
        return dateFormat.parse(s);
    }

    public static void main(String[] args) {
        String hostName = args.length > 0 ? args[0] : "time.nist.gov";
        Socket socket = null;
    }
}
