package edu.konditer.alg;

public class Lab4 {

    public static void main(String[] args) {

        Heap<Integer> heap = new MaxHeap<>();

        heap.add(3);
        heap.add(7);
        heap.add(5);
        heap.add(10);
        heap.add(4);
        heap.add(6);
        heap.add(8);

        System.out.println(heap);

        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(3);
        queue.add(5);
        queue.add(10);
        queue.add(2);
        queue.add(2);
        queue.add(8);
        queue.add(1);
        queue.add(4);

        System.out.println(queue);
        while (queue.size() > 0) {
            queue.poll();
            System.out.println(queue);
        }
    }
}
