package JavaSocket.test1.test2;

import java.io.*;
import java.util.zip.ZipOutputStream;

/**
 * Author ： Martin
 * Date : 17/8/15
 * Description :
 * Version : 2.0
 */
public class GZipRunnable implements Runnable{
    private final File input;

    public GZipRunnable(File input) {
        this.input = input;
    }

    @Override
    public void run() {
        if (!input.getName().endsWith(".gz")) {
            File output = new File(input.getParent(), input.getName() + ".gz");
            if (!output.exists()) {
                try(InputStream in = new BufferedInputStream(new FileInputStream(input));
                    OutputStream out = new BufferedOutputStream(new ZipOutputStream(new FileOutputStream(output)))) {
                    int b;
                    while ((b = in.read()) != -1) out.write(b);
                    out.flush();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
