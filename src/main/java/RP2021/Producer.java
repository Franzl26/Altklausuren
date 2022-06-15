package RP2021;

public class Producer extends Thread{
    private final Item item;
    private int orders = 0;

    public Producer(String name, Item item, int orders) {
        super(name);
        this.item = item;
        this.orders = orders;
    }

    @Override
    public void run() {
        while (!isInterrupted() && orders > 0) {
            int number = item.handleOrder();
            orders--;
        }
    }
}
