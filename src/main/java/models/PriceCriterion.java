package models;

import interfaces.WeightCriterion;

public class PriceCriterion implements WeightCriterion<Flight> {
    @Override
    public double getWeight(Flight flight) {
        return flight.price;
    }
}