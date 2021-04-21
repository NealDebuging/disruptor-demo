package org.example.my;

/**
 * csct
 *
 * @auth Neal
 * @date 2021/4/19
 */
public class Producer<S> implements Runnable {
    private String[] items = new String[]{"11", "22", "33", "44"};
    private CircularBuffer buffer;

    public Producer(CircularBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < items.length; ) {
            if (buffer.offer(items[i])) {
                System.out.println("Produced: " + items[i]);
                i++;
            }
        }
    }
}
