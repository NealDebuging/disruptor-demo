package org.example.demo;

import com.lmax.disruptor.EventHandler;

/**
 * @author lenovo
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
        System.out.println("Process Event: " + event);
    }
}