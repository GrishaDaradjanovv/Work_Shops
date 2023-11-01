package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public class JourneyImpl implements Journey {

    private static final int START_LOCATION_MIN_LENGTH = 5;
    private static final int START_LOCATION_MAX_LENGTH = 25;
    private static final int DESTINATION_MIN_LENGTH = 5;
    private static final int DESTINATION_MAX_LENGTH = 25;
    private static final int DISTANCE_MIN_VALUE = 5;
    private static final int DISTANCE_MAX_VALUE = 5000;
    private int id;
    private String startLocation;
    private String destination;
    private int distance;
    private Vehicle vehicle;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getDistance() {
        return 0;
    }

    @Override
    public Vehicle getVehicle() {
        return null;
    }

    @Override
    public String getStartLocation() {
        return null;
    }

    @Override
    public String getDestination() {
        return null;
    }

    @Override
    public double calculateTravelCosts() {
        return 0;
    }

    @Override
    public String getAsString() {
        return null;
    }
}