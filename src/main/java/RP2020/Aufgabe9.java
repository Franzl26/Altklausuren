package RP2020;

public class Aufgabe9 {
    public static void main(String[] args) {
        Queue<Double> queue = new Queue<>();
        queue.enqueue(0.9);
        queue.enqueue(1.9);
        queue.enqueue(423.42349);
        queue.enqueue(12.234);
        for (Double d : queue) System.out.println(d);

        Queue<String> queue2 = new Queue<>();
        queue2.enqueue("AA");
        queue2.enqueue("CC");
        queue2.enqueue("ZZ");
        queue2.enqueue("EE");
        String minString = Queue.min(queue2);
        System.out.println(minString);

        Queue<String> queue3 = new Queue<>();
        queue3.enqueue("AA");
        queue3.enqueue("AD");
        queue3.enqueue("BA");
        queue3.enqueue("AZ");
        queue3.enqueue("BD");
        Queue<String> result = queue3.filter(e -> e.startsWith("A"));
        result.forEach(System.out::println);
    }
}
