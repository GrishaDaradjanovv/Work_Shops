package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleImpl implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    private static final String BUS_PASSENGER_ERROR_LENGTH = String.format(
            "A bus cannot have less than %d passengers or more than %d passengers."
            , PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    public static final String PRICE_ERR_MSG = String.format(
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!"
            , PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    private int id;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(passengerCapacity,pricePerKilometer,VehicleType.LAND);
    }

    @Override
    void validatePassengerCapacity() {
        ValidationHelper.validateValueInRange(getPassengerCapacity(), PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE
                , BUS_PASSENGER_ERROR_LENGTH);
    }

    @Override
    void validatePricePerKm() {
        ValidationHelper.validateValueInRange(getPricePerKilometer(), PRICE_MIN_VALUE, PRICE_MAX_VALUE, PRICE_ERR_MSG);
    }
}