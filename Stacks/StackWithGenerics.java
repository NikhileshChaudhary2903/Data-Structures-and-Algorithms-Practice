package com.nik.practice;

import java.util.Arrays;

public class Stack<T> {

	int size, top;
	T items[];
	
	public Stack(int size) {
		this.size = size;
		this.top = -1;
		this.items = (T[]) new Object[size];
	}
	
	public boolean push(T item) {
		
		if(isFull()) {
			this.items = resizeArray();	
			this.size = this.items.length;
		}
		
		this.items[++top] = item;
		return true;
	}
	
	public boolean pop() {
		if(isEmpty())
			return false;
		
		top--;
		return true;
	}
	
	public T[] resizeArray() {
		return Arrays.copyOf(items, this.size * 2);
	}
	
	public T peek() {
		if(isEmpty())
			return null;
		
		return items[top];
	}
	public boolean isFull() {
		return this.top == this.size - 1;
	}
	
	public boolean isEmpty() {
		return this.top == -1;
	}
	
	
	@Override
	public String toString() {
		return "Stack [items=" + Arrays.toString(items) + "]";
	}

	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		System.out.println(stack.peek());
	

	}
}



