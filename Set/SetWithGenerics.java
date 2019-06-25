package com.company;

import java.util.Arrays;

public class Set<T> {

    private T[] items;
    private int count, capacity;
    private static final int DEFAULT_CAPACITY = 4;

    public Set() {

        this.items = (T[]) (new Object[DEFAULT_CAPACITY]);
        this.capacity = DEFAULT_CAPACITY;
        this.count = 0;
    }

    public String toString() {
        return Arrays.toString(this.items);
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int size(){
        return this.count;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public T[] toArray() {
        return Arrays.copyOf(this.items,this.count);
    }

    public T[] resize(){
        return Arrays.copyOf(this.items, this.capacity * 2);
    }

    public boolean contains(T item) {

        // check empty
        if(this.isEmpty() || item == null)
            return false;

        for(T i:this.items) {

            if(item.equals(i))
            return true;
        }

    return false;

    }

    public boolean add(T item) {

        if(this.contains(item))
            return false;

        // check overflow condition resize array
        if(this.count == capacity) {
            this.items = this.resize();
            this.capacity = this.items.length;
        }

        this.items[count++] = item;

        return true;
    }

    public boolean remove(T item) {

        // cant remove when items is empty
        if(this.isEmpty())
            return false;

        for(int i = 0 ; i <this.items.length ;i++) {

            if(item.equals(this.items[i]))
            {
               this.items[i] = this.items[this.count - 1];
               this.items[this.count - 1] = null;
               this.count--;

               return true;

            }
        }
        return false;

    }



}
