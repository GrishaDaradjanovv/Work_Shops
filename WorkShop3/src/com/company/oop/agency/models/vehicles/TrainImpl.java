package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleImpl implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String TRAIN_PASSENGER_ERROR_LENGTH = String.format(
            "A train cannot have less than %d passengers or more than %d passengers."
            , PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final String PRICE_ERR_MSG = String.format(
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!"
            , PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    private static final String CARTS_ERR_MSG = String.format(
            "A train cannot have less than %d cart or more than %d carts."
            , CARTS_MIN_VALUE, CARTS_MAX_VALUE);

    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(passengerCapacity, pricePerKilometer, id);
        setCarts(carts);
    }

    private void setCarts(int carts) {
        ValidationHelper.validateValueInRange(carts, CARTS_MIN_VALUE, CARTS_MAX_VALUE, CARTS_ERR_MSG);
        this.carts = carts;
    }

    @Override
    void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE
                , TRAIN_PASSENGER_ERROR_LENGTH);
    }

    @Override
    void validatePricePerKm(double pricePerKilometer) {
        ValidationHelper.validateValueInRange(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE, PRICE_ERR_MSG);
    }



    @Override
    public int getCarts() {
        return carts;
    }

//    @Override
//    public String print() {
//        return String.format("""
//                Train----
//                %s
//                Carts amount: %d
//                """, super.print(), getCarts());
//    }


    @Override
    public VehicleType getType() {
        return VehicleType.LAND;
    }

    @Override
    public String getAsString() {
        return String.format("""
                Train ----
                %s
                Carts amount: %d
                """, super.getAsString(), getCarts());
    }
}