package WP2020;

import java.util.function.Function;

public class Queue<E> extends RP2020.Queue<E>{
    public static <E extends Comparable<E>> E max(Queue<E> q) {
        if (q == null || q.isEmpty()) throw new IllegalArgumentException("schlechte Queue");
        E max = null;
        for (E el : q) {
            if (max == null) {
                max = el;
                continue;
            }
            if (el.compareTo(max) < 0) max = el;
        }
        return max;
    }

    public <F> Queue<F> map(Function<E, F> f) {
        Queue<F> q = new Queue<>();
        for (E el:this) {
            q.enqueue(f.apply(el));
        }
        return q;
    }
}
