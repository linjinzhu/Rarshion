package JavaSocket.test1.test3;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Author ： Martin
 * Date : 17/8/17
 * Description :
 * Version : 2.0
 */
public class BinarySaver {
    public static void main(String[] args) {

    }

    public static void saveBinaryFile(URL u) throws IOException {
        URLConnection uc = u.openConnection();
        String contentType= uc.getContentType();
        int contentLength = uc.getContentLength();
        if (contentType.startsWith("text/") || contentLength == -1) {
            throw new IOException("This is no a binary file");
        }

        try (InputStream raw = uc.getInputStream()) {
            InputStream in = new BufferedInputStream(raw);
            byte[] data = new byte[contentLength];
            int offset = 0;
            while (offset < contentLength) {
                int byteRead = in.read(data, offset, data.length - offset);
                if (byteRead == -1) break;
                offset += byteRead;
            }
            if (offset != contentLength) {

            }
            String filename = u.getFile();
            filename = filename.substring(filename.lastIndexOf('/') + 1);
            try (FileOutputStream fout = new FileOutputStream(filename)) {
                fout.write(data);
                fout.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
