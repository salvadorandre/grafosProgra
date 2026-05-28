package models;


import interfaces.WeightCriterion;

public class DistanceCriterion implements WeightCriterion<Flight> {
    @Override
    public double getWeight(Flight flight) {
        return flight.distance;
    }
}