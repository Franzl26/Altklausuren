package RP2020;

import java.io.PrintStream;
import java.util.ArrayList;

public class Department extends Unit {
    private final ArrayList<Unit> units = new ArrayList<>();
    public final String name;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void add(Unit unit) {
        if (unit != null) {
            units.add(unit);
        }
    }

    @Override
    public void remove(Unit unit) {
        unit.remove(unit);
    }

    @Override
    public Unit getComponent(int i) {
        return units.get(i);
    }

    @Override
    public void print(PrintStream out, String prefix) {
        out.println(prefix + name);
        units.forEach(u -> u.print(out, prefix + "\t"));
    }
}
