package models;

public class Flight {
    public double price;
    public double distance;
    public double time;
    public String flightNumber;

    public Flight(String flightNumber, double price, double distance, double time) {
        this.flightNumber = flightNumber;
        this.price = price;
        this.distance = distance;
        this.time = time;
    }

    @Override
    public String toString() {
        return flightNumber;
    }
}
