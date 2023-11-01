package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public abstract class VehicleImpl implements Vehicle {
    private int passengerCapacity;
    private double pricePerKilometer;
    private int id;

    public VehicleImpl(int passengerCapacity, double pricePerKilometer, int id) {
       setPassengerCapacity(passengerCapacity);
       setPricePerKilometer(pricePerKilometer);
       setId(id);
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKm(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }
     abstract void validatePassengerCapacity(int passengerCapacity);
     abstract void validatePricePerKm(double pricePerKilometer);
    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }
    private void setId(int id){
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
    //    public String print(){
//        return String.format("""
//                Passenger capacity: %d
//                Price per kilometer: %.2f
//                Vehicle type: %s
//                """,getPassengerCapacity(),getPricePerKilometer(),getType());
//    }

    @Override
    public String getAsString() {
        return String.format("""
                Passenger capacity: %d
                Price per kilometer: %.2f
                Vehicle type: %s
                """,getPassengerCapacity(),getPricePerKilometer(),getType());
    }
    /*
    Passenger capacity: {capacity}
Price per kilometer: {pricePerKilometer}
Vehicle type: {vehicleType}
     */
}
