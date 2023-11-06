package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleImpl implements Vehicle {
    private String make;
    private String model;
    private double price;
    private List<Comment> comments;
    private VehicleType vehicleType;
    private final int MAKE_MIN_LENGTH = 2;
    private final int MAKE_MAX_LENGTH = 15;
    private final int MODEL_MIN_LENGTH = 1;
    private final int MODEL_MAX_LENGTH = 15;
    private final double PRICE_MIN_NUMBER = 0.0;
    private final double PRICE_MAX_NUMBER = 1000000.0;
    private final String ERROR_MESSAGE = "%s must be between %d and %d characters long!";
    public  final String PRICE_ERR_MSG = String.format("Price must be between %.1f and %.1f!",
            PRICE_MIN_NUMBER,
            PRICE_MAX_NUMBER);
    /*
    make -  string with a length between 2 and 15 symbols.
    model - a string with а length between 1 and 15 symbols.
    price - a number between 0.0 and 1000000.0.
    Firstname must be between 2 and 20 characters long!
     */

    public VehicleImpl(String make, String model, double price) {
        setMake(make);
        setModel(model);
        setPrice(price);
        comments = new ArrayList<>();
        setVehicleType(vehicleType);

    }

    private void setMake(String make) {
        ValidationHelpers.validateStringLength(make,
                MAKE_MIN_LENGTH,
                MAKE_MAX_LENGTH,
                String.format(ERROR_MESSAGE, make, MAKE_MIN_LENGTH, MAKE_MAX_LENGTH));
        this.make = make;
    }

    private void setModel(String model) {
        ValidationHelpers.validateStringLength(model,
                MODEL_MIN_LENGTH,
                MODEL_MAX_LENGTH,
                String.format(ERROR_MESSAGE, make, MAKE_MIN_LENGTH, MODEL_MAX_LENGTH));
        this.model = model;
    }

    private void setPrice(double price) {
        ValidationHelpers.validateDecimalRange(price,PRICE_MIN_NUMBER,PRICE_MAX_NUMBER, PRICE_ERR_MSG);
        this.price = price;
    }

    protected void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public List<Comment> getComments() {
        return  new ArrayList<>(comments);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public VehicleType getType() {
        return vehicleType;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
    public String toString(){
        return String.format("""
                #. %s
                Make: %s
                Model: %s
                Price: $%.1f
                """,getType(),getMake(),getModel(),getPrice());
    }
    /*
    Make: {make}
Model: {model}
Wheels: {wheels}
Price: ${price}
     */
}
