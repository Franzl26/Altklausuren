package RP2021;

public interface Orderable<O> {
    void placeOrder(O order);
    O handleOrder();
}
