package edu.konditer.alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private final List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(E element) {
        elements.add(element);
        heapifyUp(size() - 1);
    }

    @Override
    public E peek() {
        return !elements.isEmpty() ? elements.get(0) : null;
    }

    @Override
    public E poll() {
        if (elements.isEmpty()) return null;
        E element = elements.get(0);

        Collections.swap(elements, 0, elements.size() - 1);
        elements.remove(elements.size() - 1);
        heapifyDown(0);
        return element;
    }

    private void heapifyUp(int index) {
        while (index > 0 && less(getParent(index), get(index))) {
            int parentIndex = getParentIndex(index);
            Collections.swap(elements, parentIndex, index);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        while (index < elements.size() - 1) {
            int swapIndex = index;
            E left = getLeft(index);
            E right = getRight(index);
            E curr = get(index);

            boolean leftExists = left != null;
            boolean rightExists = right != null;

            if (leftExists && rightExists && less(left, right) && less(curr, right)) {
                swapIndex = getRightIndex(index);
            }
            else if (leftExists && less(curr, left)) {
                swapIndex = getLeftIndex(index);
            }

            if (swapIndex == index) return;
            Collections.swap(elements, index, swapIndex);
            index = swapIndex;
        }
    }

    private E get(int index) {
        return elements.get(index);
    }

    private int getParentIndex(int index) {
        return (int) (index - 1) / 2;
    }

    private E getParent(int index) {
        return getParentIndex(index) < elements.size() ? elements.get(getParentIndex(index)) : null;
    }

    private int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    private E getLeft(int index) {
        return getLeftIndex(index) < elements.size() ? elements.get(getLeftIndex(index)) : null;
    }

    private int getRightIndex(int index) {
        return 2 * index + 2;
    }

    private E getRight(int index) {
        return getRightIndex(index) < elements.size() ? elements.get(getRightIndex(index)) : null;
    }

    private boolean less(E e1, E e2) {
        return e1.compareTo(e2) < 0;
    }

    @Override
    public String toString() {
        return String.join(" ", elements.stream().map(e -> e.toString()).toList());
    }
}
