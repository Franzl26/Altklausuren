package RP2021;

import java.util.Iterator;

// public class Queue<V> {
// Aufgabe 7a
public class Queue<V> implements Iterable<V> {
    private Element<V> head = null;
    private Element<V> tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(V v) {
        if (v != null) {
            if (tail == null) {
                head = tail = new Element<>(v);
            } else {
                tail.next = new Element<>(v);
                tail= tail.next;
            }
        }
    }

    public V dequeue() {
        V v = head.element;
        head = head.next;
        if (head == null) tail = null;
        return v;
    }

    public V getFirst() {
        return head.element;
    }

    private static class Element<E> {
        private final E element;
        private Element<E> next = null;

        private Element(E element) {
            this.element = element;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Element<V> iter = head;
        while (iter != null) {
            result.append(iter.element);
            iter = iter.next;
            if (iter != null) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }

    // Aufgabe 7a
    public Iterator<V> iterator() {
        return new QueueIterator();
    }

    // Aufgabe 7a
    public class QueueIterator implements Iterator<V> {
        private Element<V> tmp = head;

        public boolean hasNext() {
            return tmp != null;
        }

        public V next() {
            V el = tmp.element;
            tmp = tmp.next;
            return el;
        }
    }

    // Aufgabe 7b
    public static <E extends Comparable<E>> E max(Queue<E> q) {
        if (q == null || q.isEmpty()) throw new IllegalArgumentException();
        Iterator<E> it = q.iterator();
        E max = null;
        for (E el : q) {
            if (max == null) {
                max = el;
                continue;
            }
            if (max.compareTo(el) < 0) max =  el;
        }
        return max;
    }

    // Aufgabe 7c
    public int sum(ToIntFunction<V> f) {
        int sum = 0;
        for (V el : this) {
            sum += f.applyAsInt(el);
        }
        return sum;
    }
}
