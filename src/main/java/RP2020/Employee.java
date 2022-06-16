package RP2020;

import java.io.PrintStream;
import java.util.Objects;
import java.util.regex.Pattern;

public class Employee extends Unit {
    private static final Pattern namePattern = Pattern.compile("[A-Z][a-z]{2,24}");
    private static final Pattern numberPattern = Pattern.compile("[0-9]{5}");

    private final String id;
    private String name;

    public Employee(String name, String number) {
        if (number == null || !numberPattern.matcher(number).matches())
            throw new IllegalArgumentException("Number not valid!");
        if (name == null || !namePattern.matcher(name).matches())
            throw new IllegalArgumentException("Name not valid!");
        this.id = name.charAt(0) + "-" + number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || !namePattern.matcher(name).matches())
            throw new IllegalArgumentException("Name not valid!");
        this.name = name;
    }

    public void print(PrintStream out, String prefix) {
        out.println(prefix + name + " : " + id);
    }

    public static class Builder {
        private String name = null;
        private String id = null;

        public Builder setName(String n) {
            if (n == null || !namePattern.matcher(n).matches())
                throw new IllegalArgumentException("Name not valid!");
            name = n;
            return this;
        }

        public Builder setNumber(String n) {
            if (n == null || !numberPattern.matcher(n).matches())
                throw new IllegalArgumentException("Number not valid!");
            id = n;
            return this;
        }

        public Employee create() {
            if (name == null || id == null)
                throw new IllegalArgumentException("not all arguments set");
            return new Employee(name, id);
        }
    }

    @Override
    public boolean equals(Object o) {
        return this.id.equals(((Employee)o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
