package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public abstract class VehicleImpl implements Vehicle {
    private int passengerCapacity;
    private double pricePerKilometer;
    VehicleType vehicleType;

    public VehicleImpl(int passengerCapacity, double pricePerKilometer, VehicleType vehicleType) {
       setPassengerCapacity(passengerCapacity);
       setPricePerKilometer(pricePerKilometer);
        this.vehicleType = vehicleType;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity();
        this.passengerCapacity = passengerCapacity;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKm();
        this.pricePerKilometer = pricePerKilometer;
    }
     abstract void validatePassengerCapacity();
     abstract void validatePricePerKm();

    @Override
    public VehicleType getType() {
        return vehicleType;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }
    public String print(){
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
