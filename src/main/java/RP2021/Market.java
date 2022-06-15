package RP2021;

public class Market {
    public static void main(String[] args) {
        Item item = new Item("Computer", 120000);
        Customer c = new Customer("c", item, 5);
        Producer p0 = new Producer("p0", item, 2);
        Producer p1 = new Producer("p1", item, 3);
        c.start();
        p0.start();
        p1.start();
    }
}
