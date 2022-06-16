package WP2020;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Aufgabe2 {
    public static void main(String[] args) {
        // a
        MailSubscriber s0 = new MailSubscriber("Baumann", "t61aanba@unibw.de");
        System.out.println(s0);

        // b
        MailSubscriber s1 = (new MailSubscriber.Builder()).setName("Baumann").setEmail("t61aanba@unibw.de").create();
        MailSubscriber s2 = (new MailSubscriber.Builder()).setName("Dent").setEmail("arthur@dent.com").create();
        System.out.println(s1 + "\n" + s2);

        // c
        HashMap<MailSubscriber, String> realNames = new HashMap<>();
        realNames.put(s1, "Andrea Baumann");
        realNames.put(s2, "Arthur Dent");
        MailSubscriber suche = (new MailSubscriber.Builder()).setName("Unbekannt").setEmail("t61aanba@unibw.de").create();
        System.out.println("Klarname von 'suche': " + realNames.get(suche));

        // d
        PriorityQueue<MailSubscriber> subscribers = new PriorityQueue<>();
        subscribers.add(s1);
        subscribers.add(s2);
        while (!subscribers.isEmpty()) {
            System.out.println(subscribers.poll());
        }

    }
}
