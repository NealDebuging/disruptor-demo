package org.example.my;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * csct
 *
 * @auth Neal
 * @date 2021/4/19
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CircularBuffer<String> buffer = new CircularBuffer<>();
        executorService.submit(new Producer<String>(buffer));
        executorService.submit(new Consumer<String>(buffer));
        executorService.shutdown();
    }
}
