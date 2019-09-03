package com.terzeron.reactive.ch01_01;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;


public class CompletableFutureTest {
    boolean isStopped = false;

    public CompletableFutureTest() {
        System.out.println("---- CompletableFutureTest ----");
    }

    public void run() throws Exception {
        readFile().thenApply(str -> str + "!!")
                .thenAccept(str -> {
                    CompletableFutureTest.print(str);
                    isStopped = true;
                });

        while (!isStopped) {
            Thread.sleep(1000);
        }
    }

    private static CompletableFuture<String> readFile() throws IOException {
        CompletableFuture<String> cf = new CompletableFuture<>();
        AsynchronousFileChannel ch = AsynchronousFileChannel.open(Path.of("test.txt"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        ch.read(buffer, 0, null, new CompletionHandler<>() {
            public void completed(Integer result, Object attachment) {
                cf.complete(decodeBuffer(buffer));
            }

            public void failed(Throwable exc, Object attachment) {
                cf.completeExceptionally(exc);
            }
        });
        return cf;
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
