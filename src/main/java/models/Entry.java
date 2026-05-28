package models;

public class Entry<T> implements Weighable {
    public T node;
    public double accumulatedWeight;

    public Entry(T node, double weight) {
        this.node = node;
        this.accumulatedWeight = weight;
    }

    @Override
    public double getWeight() {
        return accumulatedWeight;
    }
}