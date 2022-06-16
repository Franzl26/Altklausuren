package RP2020;

import java.util.HashMap;

public class Aufgabe2 {
    public static void main(String[] args) {
        Employee e0 = new Employee("Baumann", "12345");

        Employee e1 = (new Employee.Builder()).setName("Baumann").setNumber("12345").create();
        Employee e2 = (new Employee.Builder()).setName("Dent").setNumber("23742").create();

        HashMap<Employee, String> emails = new HashMap<>();

        emails.put(e1, "t61aanba@unibw.de");
        emails.put(e2, "t61aarde@unibw.de");

        Employee suche = (new Employee.Builder()).setName("Baumann").setNumber("12345").create();
        System.out.println("E-Mail-Adresse von Baumann: " + emails.get(suche));
    }
}
