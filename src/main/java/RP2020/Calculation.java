package RP2020;

public class Calculation extends Thread {
    private static final int START_VALUE = 10;
    private static final int END_VALUE = START_VALUE * 10 - 1;

    private volatile static long value = START_VALUE;
    private static int countEmirp = 0;
    private final static String lock = "lock";

    public Calculation(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            testValue();
        }
    }

    private synchronized void testValue() {
        long tmpValueAbs = 0;
        synchronized (lock) {
            tmpValueAbs = value++;
        }
        if (tmpValueAbs > END_VALUE) {
            interrupt();
            return;
        }

        long tmpValue = tmpValueAbs;
        long tmpMirroredValue = 0;
        while (tmpValue > 0) {
            tmpMirroredValue = tmpMirroredValue * 10 + tmpValue % 10;
            tmpValue /= 10;
        }
        int countDividerOfMirroredValue = 0;
        for (long i = 1; i <= tmpMirroredValue; i++) {
            if (tmpMirroredValue % i == 0) countDividerOfMirroredValue++;
        }

        tmpValue = tmpValueAbs;
        int countDividerOfValue = 0;
        for (long i = 1; i <= tmpValue; i++) {
            if (tmpValue % i == 0) countDividerOfValue++;
        }

        if (countDividerOfValue == 2 && countDividerOfMirroredValue == 2) {
            System.out.println(getName() + ": " + tmpValueAbs + " ist Mirpzahl");
            countEmirp++;
        }
    }

    /*private synchronized void testValue() {
        if (value > END_VALUE) interrupt();
        int tmp = switch (getName()) {
            case "B" -> 1;
            case "C" -> 2;
            default -> 0;
        };


        long tmpValue = value;

        if ((tmpValue - tmp) % 3 != 0) return;

        long tmpMirroredValue = 0;
        while (tmpValue > 0) {
            tmpMirroredValue = tmpMirroredValue * 10 + tmpValue % 10;
            tmpValue /= 10;
        }
        int countDividerOfMirroredValue = 0;
        for (long i = 1; i <= tmpMirroredValue; i++) {
            if (tmpMirroredValue % i == 0) countDividerOfMirroredValue++;
        }

        tmpValue = value;
        int countDividerOfValue = 0;
        for (long i = 1; i <= tmpValue; i++) {
            if (tmpValue % i == 0) countDividerOfValue++;
        }

        if (countDividerOfValue == 2 && countDividerOfMirroredValue == 2) {
            System.out.println(getName() + ": " + value + " ist Mirpzahl");
            countEmirp++;
        }

        value++;
    }*/

    public static void main(String[] args) throws InterruptedException {
        Calculation threadA = new Calculation("A");
        Calculation threadB = new Calculation("B");
        Calculation threadC = new Calculation("C");

        threadA.start();
        threadB.start();
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("In [" + START_VALUE + ", " + END_VALUE + "] gibt es " + countEmirp + " Mirpzahlen");
    }
}
