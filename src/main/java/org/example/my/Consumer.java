package org.example.my;

import java.util.concurrent.Callable;

/**
 * csct
 *
 * @auth Neal
 * @date 2021/4/19
 */
public class Consumer<T> implements Callable {

    private int expectedCount = 4;
    private CircularBuffer buffer;

    public Consumer(CircularBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public T[] call() {
        T[] items = (T[]) new Object[expectedCount];
        for (int i = 0; i < items.length;) {
            T item = (T) buffer.poll();
            if (item != null) {
                items[i++] = item;
                System.out.println("Consumed: " + item);
            }
        }
        return items;
    }
}
