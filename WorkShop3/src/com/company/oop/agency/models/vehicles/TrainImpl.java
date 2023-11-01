package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleImpl implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    private static final String TRAIN_PASSENGER_ERROR_LENGTH = String.format(
            "A train cannot have less than %d passengers or more than %d passengers."
            , PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    public static final String PRICE_ERR_MSG = String.format(
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!"
            , PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    public static final String CARTS_ERR_MSG = String.format(
            "A train cannot have less than %d cart or more than %d carts."
            ,CARTS_MIN_VALUE,CARTS_MAX_VALUE);

    private int carts;
    private int id;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(passengerCapacity,pricePerKilometer,VehicleType.LAND);
        setCarts(carts);
    }

    private void setCarts(int carts) {
        ValidationHelper.validateValueInRange(carts,CARTS_MIN_VALUE,CARTS_MAX_VALUE, CARTS_ERR_MSG);
        this.carts = carts;
    }

    @Override
    void validatePassengerCapacity() {
        ValidationHelper.validateValueInRange(getPassengerCapacity(), PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE
                , TRAIN_PASSENGER_ERROR_LENGTH);
    }

    @Override
    void validatePricePerKm() {
        ValidationHelper.validateValueInRange(getPricePerKilometer(), PRICE_MIN_VALUE, PRICE_MAX_VALUE, PRICE_ERR_MSG);
    }


    @Override
    public int getCarts() {
        return carts;
    }

    @Override
    public String print() {
        return String.format("""
                Train----
                %s
                Carts amount: %d
                """, super.print(),getCarts());
    }
}