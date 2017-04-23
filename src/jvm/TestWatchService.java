package jvm;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.NetworkChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.file.*;
import java.util.Set;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * Created by rarshion on 17/1/7.
 */
public class TestWatchService {

    public static void main(String[] args) {
//        try {
//            boolean shutdown = false;
//            WatchService watcher = FileSystems.getDefault().newWatchService();
//            Path dir = FileSystems.getDefault().getPath("/Users/rarshion/技术文档");
//            WatchKey key = dir.register(watcher, ENTRY_MODIFY);
//            while( !shutdown) {
//                key = watcher.take();
//                key.pollEvents().stream().filter(event -> event.kind() == ENTRY_MODIFY).forEachOrdered(event -> {
//                    System.out.println("home dir changed");
//                });
//                key.reset();
//            }
//        } catch(IOException | InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            Path file = Paths.get("/Users/rarshion/Documents/萌友－直传OSS/windows/test14.exe");
//            AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
//            ByteBuffer buffer = ByteBuffer.allocate(100_000);
//            channel.read(buffer, 0, buffer,
//                    new CompletionHandler<Integer, ByteBuffer>() {
//                        @Override
//                        public void completed(Integer result, ByteBuffer attachment) {
//                            System.out.println("Bytes read [" + result + "]");
//                        }
//
//                        @Override
//                        public void failed(Throwable exc, ByteBuffer attachment) {
//                            System.out.println(exc.getMessage());
//                        }
//                    });
//        } catch (IOException ex) {
//
//        }
//
//        SelectorProvider provider = SelectorProvider.provider();
//        try {
//            NetworkChannel socketChannel = provider.openSocketChannel();
//            SocketAddress address = new InetSocketAddress(3080);
//            socketChannel = socketChannel.bind(address);
//            Set<SocketOption<?>>
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }

    }

}
