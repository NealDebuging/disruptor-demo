package org.example.demo;

import com.lmax.disruptor.EventFactory;

/**
 * @author lenovo
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}