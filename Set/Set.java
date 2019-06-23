package com.company;

import java.util.Arrays;

public class Set {

    private Object[] items;
    private int capacity, size;

    public Set(int c) {
        this.capacity = c;
        this.items = new Object[this.capacity];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object item) {

        if(isEmpty())
            return false;

        for (Object i : this.items) {
            if (item.equals(i))
                return true;
        }

        return false;
    }

    public boolean add(Object item) {

        boolean flag = this.contains(item);

        if (flag == false) {

            if (this.size == this.capacity) {
                items = Arrays.copyOf(items, 2 * this.capacity);
            }
            items[size++] = item;
            return true;
        }

        return false;
    }

    public boolean remove(Object item) {

        if(isEmpty())
            return false;

        for (int i = 0; i < this.size; i++) {

            if (item.equals(this.items[i])) {
                items[i] = items[size - 1];
                size--;
                return true;
            }
        }

        return false;
    }

    public Object[] toArray() {
        return Arrays.copyOf(this.items,this.capacity);
    }

    public void clear(){
        this.items = null;
        this.size = 0;
    }

}
