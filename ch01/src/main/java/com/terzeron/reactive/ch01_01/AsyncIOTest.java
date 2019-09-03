package com.terzeron.reactive.ch01_01;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;


public class AsyncIOTest {
    boolean isStopped = false;

    public AsyncIOTest() {
        System.out.println("---- AsyncIOTest ----");
    }

    public void run() throws Exception {
        Path file;
        AsynchronousFileChannel ch = AsynchronousFileChannel.open(Path.of("test.txt"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        /*
        // future style
        Future<Integer> future = ch.read(buffer, 0);
        int size = future.get();
        System.out.println(size);
        System.out.println(decodeBuffer(buffer));
        */

        // callback style
        ch.read(buffer, 0, null, new CompletionHandler<>() {
            public void completed(Integer result, Object attachment) {
                print("Content: " + decodeBuffer(buffer));
                isStopped = true;
            }

            public void failed(Throwable exc, Object attachment) {
                print("Error! " + exc.getMessage());
                isStopped = true;
            }
        });

        while (!isStopped) {
            Thread.sleep(1000);
        }
    }

    private static String decodeBuffer(ByteBuffer buffer) {
        buffer.flip();
        Charset charset = Charset.defaultCharset();
        return charset.decode(buffer).toString();
    }

    private static void print(String msg) {
        System.out.println(String.format("%s %s %s", LocalDateTime.now().toString(), Thread.currentThread().getName()
                , msg));
    }
}
