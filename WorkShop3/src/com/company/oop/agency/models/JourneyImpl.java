package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey {

    private static final int START_LOCATION_MIN_LENGTH = 5;
    private static final int START_LOCATION_MAX_LENGTH = 25;
    private static final int DESTINATION_MIN_LENGTH = 5;
    private static final int DESTINATION_MAX_LENGTH = 25;
    private static final int DISTANCE_MIN_VALUE = 5;
    private static final int DISTANCE_MAX_VALUE = 5000;
    public static final String START_LOCATION_ERR_MSG = String.format(
            "The StartingLocation's length cannot be less than %d or more than %d symbols long.",
            START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH);
    public static final String DESTINATION_ERR_MSG = String.format(
            "The Destination'slength cannot be less than %d or more than %d symbols long.",
            DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH);
    public static final String DISTANCE_ERR_MSG = "The Distance cannot be less than 5 or more than 5000 kilometers.";

    private int id;
    private String startLocation;
    private String destination;
    private int distance;
    private Vehicle vehicle;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        setId(id);
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        setVehicle(vehicle);
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setStartLocation(String startLocation) {
        ValidationHelper.validateStringLength(startLocation, START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH,
                START_LOCATION_ERR_MSG);
        this.startLocation = startLocation;
    }

    public void setDestination(String destination) {
        ValidationHelper.validateStringLength(destination, DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH,
                DESTINATION_ERR_MSG);
        this.destination = destination;
    }

    private void setDistance(int distance) {
        ValidationHelper.validateValueInRange(distance, DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE, DISTANCE_ERR_MSG);
        this.distance = distance;
    }

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double calculateTravelCosts() {
        return distance * vehicle.getPricePerKilometer();
    }

    @Override
    public String getAsString() {
        return String.format("""
                Journey----
                Start location: %s
                Destination: %s
                Distance: %d
                Vehicle type: %s
                Travel costs: $%.2f
                """, startLocation, destination, distance, vehicle.getType(), calculateTravelCosts());
    }
    /*
    Journey ----
Start location: {startLocation}
Destination: {destination}
Distance: {distance}
Vehicle type: {vehicleType}
Travel costs: {costs}
     */
}