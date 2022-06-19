package RP2019;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static RP2019.Aufgabe9.getMin;
import static org.junit.jupiter.api.Assertions.*;

class Aufgabe9Test {
    @Test
    @Disabled
    void test1() {
        assertEquals(0, getMin(1, 0, 2));
        assertEquals(0, getMin(1, 2, 0));
    }

    @Test
    void test2() {
        assertEquals(0, getMin(1, 0, 2));
        assertEquals(0, getMin(1, 2, 0));
        assertEquals(0, getMin(0, 1, 2));
        assertEquals(0, getMin(0, 2, 1));
    }
}