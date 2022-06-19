package RP2019;

public class Calculation extends Thread {
    private static final int START_VALUE = 20191216;
    private static final int END_VALUE = 20191400;

    private static volatile int value = START_VALUE;
    private static volatile int zaehlePrim = 0;

    private static final String valueLock = "lock";
    private static final String countLock = "lock";

    public Calculation(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!isInterrupted()) testValue();
    }

    /*private synchronized void testValue() {
        int anzahlTeiler = 0;

        for (int i = 1; i <= value; i++) {
            if (value % i == 0) anzahlTeiler += 1;
        }
        if (anzahlTeiler == 2) {
            System.out.println(getName() + ": " + value + " ist Primzahl.");
            zaehlePrim++;
        }
        value++;
        if (value > END_VALUE) interrupt();
    }*/

    private synchronized void testValue() {
        int absValue;
        int anzahlTeiler = 0;
        synchronized (valueLock) {
            absValue = value++;
        }
        if (absValue+1 > END_VALUE) {
            interrupt();
            return;
        }
        for (int i = 1; i <= absValue; i++) {
            if (absValue % i == 0) anzahlTeiler += 1;
        }
        if (anzahlTeiler == 2) {
            System.out.println(getName() + ": " + absValue + " ist Primzahl.");
            synchronized (countLock) {
                zaehlePrim++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Calculation threadA = new Calculation("A");
        Calculation threadB = new Calculation("B");
        Calculation threadC = new Calculation("C");

        threadA.start(); threadB.start(); threadC.start();
        threadA.join(); threadB.join(); threadC.join();

        System.out.println(zaehlePrim + " Primzahlen");
    }
}
