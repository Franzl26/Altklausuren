package RP2019;

public class Aufgabe9 {
    public static int getMin(int a, int b, int c) {
        int min = a;
        if (b < c) {

            if (b < a) {
                min = b;
            }
        } else {
            if (c < a) {
                min = c;
            }
        }
        return min;
    }
}
