package RP2021;

import java.util.regex.Pattern;

public class Item implements Orderable<Integer> {
    private static int instanceCounter = 0;
    // protected static final Pattern namePattern = Pattern.compile("");
    // Aufgabe 8a
    protected static final Pattern namePattern = Pattern.compile("[ a-zA-Z]{3,128}");

    final long instanceNumber;
    public final String name;
    private int price;
    private Queue<Integer> orders = new Queue<>();

    public Item(String name, int price) {
        if (name == null || !namePattern.matcher(name).matches())
            throw new IllegalArgumentException("Name not valid");
        if (price < 0)
            throw new IllegalArgumentException("Negative Price not valid!");
        instanceNumber = instanceCounter++;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Item{name=" + name + ", price=" + price + ", orders=" + orders + "}";
    }

    public int getPrice() {
        return price;
    }

    void setPrice(int price) {
        if (price < 0)
            throw new IllegalArgumentException("Negative price not valid!");
        this.price = price;
    }

    public synchronized void placeOrder(Integer order) {
        System.out.println(Thread.currentThread().getName() + ": placeOrder(" + order + ")");
        orders.enqueue(order);
        notifyAll();
    }

    public synchronized Integer handleOrder()  {
        while (orders.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + ": handleOrder() -> " + orders.getFirst());
        return orders.dequeue();
    }

    // Aufgabe 8b
    public static class Builder {
        private String name = null;
        private int price = -1;

        public Builder name(String n) {
            if (n == null || !namePattern.matcher(n).matches())
                throw new IllegalArgumentException("Name not valid");
            name = n;
            return this;
        }

        public Builder price(int p) {
            if (p < 0)
                throw new IllegalArgumentException("Negative Price not valid!");
            price = p;
            return this;
        }

        public Item build() {
            if (name == null || price < 0) throw new IllegalArgumentException("nicht alle Parameter gesetzt");
            return new Item(name, price);
        }
    }
}
