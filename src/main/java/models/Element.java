package models;

public class Element implements Weighable {
    public int value;
    public int priority;
    Element(int v, int p) { value = v; priority = p; }

    @Override
    public double getWeight() {
        return priority;
    }
}
