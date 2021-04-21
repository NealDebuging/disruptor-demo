package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.my.CircularBuffer;
import org.junit.Test;


public class AppTest 
{
    @Test
    public void givenCircularBuffer_whenAnElementIsEnqueued_thenSizeIsOne() {
        CircularBuffer<String> buffer = new CircularBuffer<>();

        assertTrue(buffer.offer("Square"));
        assertEquals(1, buffer.size());
    }

    @Test
    public void givenCircularBuffer_whenAnElementIsDequeued_thenElementMatchesEnqueuedElement() {
        CircularBuffer<String> buffer = new CircularBuffer<>();
        buffer.offer("Triangle");
        String shape = buffer.poll();

        assertEquals("Triangle", shape);
    }
}
