package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private int id;
    private Journey journey;
    private double costs;
    private static final String COSTS_ERR_MSG = "Value of 'costs' must be a positive number. Actual value: %.2f.";

    public TicketImpl(int id, Journey journey, double costs) {
        setId(id);
        setJourney(journey);
        setCosts(costs);
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }

    private void setCosts(double costs) {
        if (costs < 0){
            throw new InvalidUserInputException(String.format(COSTS_ERR_MSG,costs));
        }
        this.costs = costs;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return  costs * journey.calculateTravelCosts();

    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }

    @Override
    public String getAsString() {
        return String.format("""
                Ticket ----
                Destination: %s
                Price: $%.2f
                """,journey.getDestination(),calculatePrice());
    }
}
