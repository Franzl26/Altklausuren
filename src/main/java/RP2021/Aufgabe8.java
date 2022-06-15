package RP2021;

public class Aufgabe8 {
    public static void main(String[] args) {
        Item apple = (new Item.Builder()).name("Green Apple").price(49).build();
        Item pear = (new Item.Builder()).price(59).name("Yellow Pear").build();
        System.out.println(apple);
        System.out.println(pear);
    }
}
