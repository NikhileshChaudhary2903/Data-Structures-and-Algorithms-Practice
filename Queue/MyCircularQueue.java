public class MyCircularQueue {
    /** Initialize your data structure here. Set the size of the queue to be k. */

    private int[] items;
    private int front,rear,size;

    public MyCircularQueue(int k) {

        items = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if(isFull()) {
            return false;
        }
        items[rear] = value;
        rear = (rear + 1)% items.length;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {

        if(isEmpty())
            return false;

        front = (front + 1) % this.items.length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return (isEmpty())? -1: items[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return (isEmpty())? -1: (rear == 0) ? items[items.length - 1] : items[rear - 1] ;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == this.items.length;
    }

    public String toString(){
        return Arrays.toString(items);
    }

}
