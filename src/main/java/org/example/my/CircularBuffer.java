package org.example.my;

public class CircularBuffer<E> {
    public static final int DEFAULT_CAPACITY = 8;
    private final int capacity;
    private final E[] data;
    private volatile  int readSequence;
    private volatile  int writeSequence;

    @SuppressWarnings("unchecked")
    public CircularBuffer() {
        this(DEFAULT_CAPACITY);
    }

    public CircularBuffer(int capacity) {
        this.capacity = (capacity < 1) ? DEFAULT_CAPACITY : capacity;
        this.data = (E[]) new Object[this.capacity];
        this.readSequence = 0;
        this.writeSequence = -1;
    }

    /**
     * inserts an element into the buffer at the next available slot and returns true on success.
     * It returns false if the buffer can't find an empty slot,
     * that is, we can't overwrite unread values.
     *
     * @param element element
     * @return boolean
     */
    public boolean offer(E element) {
        boolean isFull = (writeSequence - readSequence) + 1 == capacity;
        if (!isFull) {
            int nextWriteSeq = writeSequence + 1;
            data[nextWriteSeq % capacity] = element;
            writeSequence++;
            return true;
        }
        return false;
    }

    /**
     * retrieves and removes the next unread element.
     * The poll operation doesn't remove the element but increments the read sequence.
     * @return
     */
    public E poll() {
        boolean isEmpty = writeSequence < readSequence;
        if (!isEmpty) {
            E nextValue = data[readSequence % capacity];
            readSequence++;
            return nextValue;
        }
        return null;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {

        return (writeSequence - readSequence) + 1;
    }

    public boolean isEmpty() {

        return writeSequence < readSequence;
    }

    public boolean isFull() {

        return size() >= capacity;
    }

    private boolean isNotEmpty() {

        return !isEmpty();
    }

    private boolean isNotFull() {

        return !isFull();
    }
}
