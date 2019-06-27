public class MyCircularDeque {

    private final int items[];
    private int front,rear, size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.items = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if(isFull())
            return false;

        front = front == 0 ? items.length - 1 : front - 1;
        items[front] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {

        if(isFull())
            return false;

        items[rear] = value;
        rear = (rear + 1) % this.items.length;
        size++;
        return true;

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {

        if(isEmpty())
            return false;

        front = (front + 1) % this.items.length;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {

        if(isEmpty())
            return false;

        rear = (rear == 0) ? this.items.length - 1 : rear - 1;
        size--;

        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {

        return isEmpty() ? -1: items[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {

        return isEmpty() ? -1 : items[ (rear == 0) ? items.length - 1 : rear - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {

        return size == this.items.length;
    }
}
