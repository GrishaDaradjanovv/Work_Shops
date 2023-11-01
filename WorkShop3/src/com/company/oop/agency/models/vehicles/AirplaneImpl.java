package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.utils.ValidationHelper;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    private static final int PASSENGER_MIN_VALUE = 1;
    private static final int PASSENGER_MAX_VALUE = 800;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String AIRPLANE_PASSENGER_ERROR_LENGTH = String.format(
            "An airplane cannot have less than %d passengers or more than %d passengers."
            , PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    public static final String PRICE_ERR_MSG = String.format(
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!"
            , PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    private final boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(passengerCapacity, pricePerKilometer,id);
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE
                , AIRPLANE_PASSENGER_ERROR_LENGTH);
    }

    @Override
    void validatePricePerKm(double pricePerKilometer) {
        ValidationHelper.validateValueInRange(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE, PRICE_ERR_MSG);
    }

    @Override
    public boolean hasFreeFood() {
       return hasFreeFood;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.AIR;
    }
    //    @Override
//    public String print() {
//        return String.format("""
//                Airplane----
//                %s
//                Has free food: %s
//                """,super.print(),hasFreeFood) ;
//

    @Override
    public String getAsString() {
        return String.format("""
                Airplane----
                %s
                Has free food: %s
                """,super.getAsString(),hasFreeFood) ;
    }
}