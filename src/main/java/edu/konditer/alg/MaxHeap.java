package edu.konditer.alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private final List<E> elements;

    public MaxHeap() {
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

    private void heapifyUp(int index) {
        while (index > 0 && less(getParent(index), get(index))) {
            int parentIndex = getParentIndex(index);
            Collections.swap(elements, parentIndex, index);
            index = parentIndex;
        }
    }

    private E get(int index) {
        return elements.get(index);
    }

    private E getParent(int index) {
        return elements.get(getParentIndex(index));
    }

    private int getParentIndex(int index) {
        return (int) (index - 1) / 2;
    }

    private boolean less(E e1, E e2) {
        return e1.compareTo(e2) < 0;
    }

    @Override
    public String toString() {
        String str = "";
        if (elements.isEmpty()) return str;
        int height = (int) Math.ceil((Math.log(elements.size()) / Math.log(2))) + 1;
        int wide = (int) Math.pow(2, height - 1) * 4 - 3;

        for (int i = 0; i < height; i++) {
            int indent = (int) ((Math.pow(2, (height - i - 1)) - 1) * 2);
            int itemsAmount = (int) Math.pow(2, i);
            int spaceBetween = itemsAmount != 1 
                    ? (wide - itemsAmount - (indent * 2)) / (itemsAmount - 1)
                    : 0;

            for (int k = 0; k < indent; k++) {
                str += " ";
            }

            for (int j = 0; j < itemsAmount; j++) {

                if ((int) Math.pow(2, i) + j > elements.size()) {
                    break;
                }

                if (j != 0) {
                    for (int k = 0; k < spaceBetween; k++) {
                        str += " ";
                    }
                }

                str += elements.get((int) Math.pow(2, i) - 1 + j);
            }
            str += "\n";
        }

        return str;
    }
}
