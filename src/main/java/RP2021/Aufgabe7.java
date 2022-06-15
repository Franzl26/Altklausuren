package RP2021;

public class Aufgabe7 {
    public static void main(String[] args) {
        a7();
        b7();
        c7();
    }

    public static void a7() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        for (Integer i : queue) {
            System.out.println(i);
        }
    }

    public static void b7() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("AA");
        queue.enqueue("CC");
        queue.enqueue("ZZ");
        queue.enqueue("EE");
        String maxString = Queue.max(queue);
        System.out.println(maxString);
    }

    public static void c7() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("abc");
        queue.enqueue("aa");
        queue.enqueue("def");
        queue.enqueue("z");
        queue.enqueue("zzdf");
        int sum = queue.sum(e -> e.length());
        System.out.println(sum);
    }
}
