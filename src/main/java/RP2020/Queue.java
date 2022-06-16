package RP2020;

import java.util.Iterator;
import java.util.function.Predicate;

public class Queue<E> implements Iterable<E> {
    private SLL<E> head = null;
    private SLL<E> tail = null;

    private static class SLL<K> {
        private K element;
        private SLL<K> next;

        private SLL(K el, SLL<K> n) {
            element = el;
            next = n;
        }
    }

    public void enqueue(E el) {
        if (el == null) throw new IllegalArgumentException("no nulls");
        if (head == null) {
            head = tail =  new SLL<>(el, null);
        } else {
            tail.next = new SLL<>(el, null);
            tail = tail.next;
        }
    }

    public E getFirst() {
        return head.element;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public E dequeue() {
        E tmp = head.element;
        head = head.next;
        if (head == null) tail = null;
        return tmp;
    }

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    public class QueueIterator implements Iterator<E> {
        private SLL<E> tmp = head;
        public boolean hasNext() {
            return (tmp != null);
        }
        public E next() {
            E tmp2 = tmp.element;
            tmp = tmp.next;
            return tmp2;
        }
    }

    public static <E extends Comparable<E>> E min(Queue<E> q) {
        E min = null;
        for (E el : q) {
            if (min == null) {min = el; continue;}
            if (el.compareTo(min) < 0) min = el;
        }
        return min;
    }

    public Queue<E> filter(Predicate<E> p) {
        Queue<E> q = new Queue<>();
        for (E el: this) {
            if (p.test(el)) q.enqueue(el);
        }
        return q;
    }
}
