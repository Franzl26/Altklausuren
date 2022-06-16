package WP2020;

public interface Subscribable<M> {
    void send(M message);
}
