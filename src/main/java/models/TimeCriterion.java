package models;


import interfaces.WeightCriterion;

public class TimeCriterion implements WeightCriterion<Flight> {
    @Override
    public double getWeight(Flight flight) {
        return flight.time;
    }
}