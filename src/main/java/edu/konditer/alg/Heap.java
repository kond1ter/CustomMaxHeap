package edu.konditer.alg;

public interface Heap<E> {

    /*
     * Get amount of elements
     */
    int size();
    
    /*
     * Add new element and heapify up
     */
    void add(E element);

    /*
     * Take max element without removing
     */
    E peek();
}

