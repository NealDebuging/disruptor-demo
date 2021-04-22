package org.example.demo;

import com.lmax.disruptor.EventHandler;

/**
 * csct
 *
 * @author Neal
 * @date 2021/4/21
 */
public class ReplicationConsumer implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("ReplicationConsumer" + event.getValue());
    }
}
