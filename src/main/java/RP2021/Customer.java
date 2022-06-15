package RP2021;

public class Customer extends Thread{
    private final Item item;
    private int orders = 0;

    public Customer(String name, Item item, int orders) {
        super(name);
        this.item = item;
        this.orders = orders;
    }

    @Override
    public void run() {
        while (!isInterrupted() && orders > 0) {
            int number = (int) (Math.random() * 1000);
            item.placeOrder(number);
            orders--;
        }
    }
}
