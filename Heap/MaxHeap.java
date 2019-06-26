package com.company;
import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {

    private static final int DEFAULT_CAPACITY = 8;
    private T[] items;
    int heapSize,heapCapacity;

    public MaxHeap() {
        this.heapSize = 0;
        this.items = (T[])new Comparable[DEFAULT_CAPACITY];
        this.heapCapacity = DEFAULT_CAPACITY;
    }

    public T[] resize() {
        return Arrays.copyOf(this.items, this.heapCapacity * 2);
    }

    public T[] toArray() {
        return Arrays.copyOf(this.items,this.heapSize);
    }

    public String toString() {
        return Arrays.toString(items);
    }

    public int parent(int i) {
        return (i - 1)/2;
    }

    public int left(int i) {
        return 2*i + 1;
    }

    public int right(int i) {
        return 2*i + 2;
    }

    // O(n) time to construct a heap
    public void buildHeap() {

        int n = this.heapSize;
       for(int i = n/2 - 1; i >=0 ;i--)
           heapify(i);

    }

    // O(lgn) time complexity
    public void heapify(int i) {

       int l = left(i);
       int r = right(i);

       int largest = i;

       if(l < this.heapSize && items[l].compareTo(items[largest]) > 0) largest = l;

       if(r < this.heapSize && items[r].compareTo(items[largest]) > 0) largest = r;

       if(largest!=i) {
           swap(items,largest,i);
           heapify(largest);
       }

    }

    public void swap(T[] items, int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // this is equivalent to getMax() O(1) time operation
    public T peek() {

        if(this.isEmpty())
           return null;

        return this.items[0];
    }

    public boolean isEmpty() {
        return this.heapSize == 0;
    }

// remove operation O(lgn) time
    public T extractMax() {

        if(this.isEmpty())
            return null;

        T item = items[0];
        items[0] = items[this.heapSize - 1];
        this.items[this.heapSize - 1] = null;
        this.heapSize--;

        this.heapify(0);
        return item;
    }

    // O(lgn) complexity
    public void increaseKey(int i,T val) {

        this.items[i] = val;

        while(i > 0 && this.items[i].compareTo(this.items[parent(i)]) > 0)
        {
            swap(items,i,parent(i));
            i = parent(i);
        }
    }
    // O(lgn) complexity
    public void insert(T val) {

        if(this.heapSize == this.heapCapacity)
        {
            this.items = resize();
            this.heapCapacity = this.items.length;
        }
        this.heapSize++;
        increaseKey(this.heapSize - 1, val);
    }

}
