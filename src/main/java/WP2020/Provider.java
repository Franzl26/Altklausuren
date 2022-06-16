package WP2020;

import java.util.Arrays;
import java.util.HashSet;

public class Provider<M> {
    private HashSet<Subscribable<M>> subscribers = new HashSet<>();
    public synchronized void subscribe(Subscribable<M> subscribable) {
        if (subscribable != null) subscribers.add(subscribable);
    }

    public synchronized void unsubscribe(Subscribable<M> subscribable) {
        if (subscribable != null) subscribers.remove(subscribable);
    }

    public void post(M message) {
        Subscribable<M>[] tmp;
        synchronized (this) {
            tmp = this.subscribers.toArray(new Subscribable[0]);
        }
        Arrays.stream(tmp).parallel().forEach(s -> (new Thread(() -> s.send(message))).start());
    }
}
