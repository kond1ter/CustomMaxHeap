package edu.konditer.alg;

public interface Queue<E> {

    /*
     * Get amount of elements
     */
    int size();

    /*
     * Add new element
     */
    void add(E element);

    /*
     * Take max element without removing
     */
    E peek();

    /*
     * Take and remove max element
     */
    E poll();
}
