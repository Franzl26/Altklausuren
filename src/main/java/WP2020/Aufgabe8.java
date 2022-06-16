package WP2020;

public class Aufgabe8 {
    public static void main(String[] args) {
        Queue<String> queue1 = new Queue<>();
        queue1.enqueue("AA");
        queue1.enqueue("CCd");
        queue1.enqueue("ZZddd");
        queue1.enqueue("E");
        String maxString = Queue.max(queue1);
        System.out.println(maxString);

        //Queue<Integer> mapped = queue1.map(e -> e.length());
        Queue<Integer> mapped = queue1.map(String::length);
        mapped.forEach(System.out::println);

    }
}
