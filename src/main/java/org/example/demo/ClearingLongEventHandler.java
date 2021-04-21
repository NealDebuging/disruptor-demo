package org.example.demo;

import com.lmax.disruptor.EventHandler;

/**
 * @author lenovo
 */
public class ClearingLongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
        // Failing to call clear here will result in the
        // object associated with the event to live until
        // it is overwritten once the ring buffer has wrapped
        // around to the beginning.
        event.clear();
        System.out.println("Cleared Event: " + event);
    }
}