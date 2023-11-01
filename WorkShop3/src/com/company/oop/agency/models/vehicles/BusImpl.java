package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleImpl implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String BUS_PASSENGER_ERROR_LENGTH = String.format(
            "A bus cannot have less than %d passengers or more than %d passengers."
            , PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    public static final String PRICE_ERR_MSG = String.format(
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!"
            , PRICE_MIN_VALUE, PRICE_MAX_VALUE);

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(passengerCapacity, pricePerKilometer, id);
    }

    @Override
    void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE
                , BUS_PASSENGER_ERROR_LENGTH);
    }

    @Override
    void validatePricePerKm(double pricePerKilometer) {
        ValidationHelper.validateValueInRange(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE, PRICE_ERR_MSG);
    }
    @Override
    public VehicleType getType() {
        return VehicleType.LAND;
    }

    @Override
    public String getAsString() {
        return String.format("""
                Bus ----
                %s
                """, super.getAsString());
    }
}