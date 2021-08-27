package com.ljiangf.DataStructure;

import java.util.Arrays;

public class MyStack<T>{
    int capacity;
    int size;
    Object[] elements;

    private final int MAX_CAPACITY = 0x7ffffff7;

    /** initialize your data structure here. */
    public MyStack(int initCapacity) {
        elements = new Object[initCapacity];
        this.capacity = initCapacity;
        this.size = 0;
    }

    public void push(T val) {
        if(capacity == elements.length){
            grow();
        }
        elements[size++] = val;
    }

    public void pop() {
        if(size == 0){
            return;
        }
        size--;
    }

    public T top() {
        if(size == 0){
            return null;
        }
        return (T) elements[--size];
    }

    private void grow(){
        if(capacity == MAX_CAPACITY){
            throw new IllegalStateException("数组过大");
        }
        int enlargeSize = capacity >> 1;
        int newCapacity = capacity + enlargeSize;
        if(((enlargeSize ^ newCapacity) & (capacity ^ newCapacity)) < 0){
            newCapacity = MAX_CAPACITY;
        }
        elements = Arrays.copyOf(elements, newCapacity);
        this.capacity = newCapacity;
    }
}
