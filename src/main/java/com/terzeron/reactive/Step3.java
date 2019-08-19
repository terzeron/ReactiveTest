package com.terzeron.reactive;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;


public class Step3 {
    public static void main(String[] args) throws Exception {
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
            }

            public void failed(Throwable exc, Object attachment) {
                print("Error! " + exc.getMessage());
            }
        });
        Thread.sleep(5000);
    }

    private static String decodeBuffer(ByteBuffer buffer) {
        buffer.flip();
        Charset charset = Charset.defaultCharset();
        return charset.decode(buffer).toString();
    }

    private static String longTermJob(String name) throws Exception {
        print("start job");
        Thread.sleep(5000);
        print("end job");
        return "**" + name + "**";
    }

    private static void print(String msg) {
        System.out.println(String.format("%s %s %s", LocalDateTime.now().toString(), Thread.currentThread().getName()
                , msg));
    }
}
