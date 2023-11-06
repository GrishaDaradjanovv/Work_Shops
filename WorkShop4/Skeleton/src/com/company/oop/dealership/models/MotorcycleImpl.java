package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class MotorcycleImpl extends VehicleImpl implements Motorcycle{

//    public static final int MAKE_NAME_LEN_MIN = 2;
//    public static final int MAKE_NAME_LEN_MAX = 15;
//    private static final String MAKE_NAME_LEN_ERR = format(
//            "Make must be between %s and %s characters long!",
//            MAKE_NAME_LEN_MIN,
//            MAKE_NAME_LEN_MAX);
//    public static final int MODEL_NAME_LEN_MIN = 1;
//    public static final int MODEL_NAME_LEN_MAX = 15;
//    private static final String MODEL_NAME_LEN_ERR = format(
//            "Model must be between %s and %s characters long!",
//            MODEL_NAME_LEN_MIN,
//            MODEL_NAME_LEN_MAX);
//    public static final double PRICE_VAL_MIN = 0;
//    public static final double PRICE_VAL_MAX = 1000000;
//    private static final String PRICE_VAL_ERR = format(
//            "Price must be between %.1f and %.1f!",
//            PRICE_VAL_MIN,
//            PRICE_VAL_MAX);
    private static final int CATEGORY_LEN_MIN = 3;
    private static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);

    private String category;
    private List<Comment>comments;

    public MotorcycleImpl(String make, String model,double price, String category){
        super(make,model,price);
        setCategory(category);
        setVehicleType(VehicleType.MOTORCYCLE);

    }

    private void setCategory(String category) {
        ValidationHelpers.validateIntRange(category.length(),CATEGORY_LEN_MIN,CATEGORY_LEN_MAX,CATEGORY_LEN_ERR);
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int getWheels() {
        return 2;
    }

//    @Override
//    public void addComment(Comment comment) {
//        comments.add(comment);
//    }
//
//    @Override
//    public void removeComment(Comment comment) {
//        comments.remove(comment);
//    }
//
//    @Override
//    public List<Comment> getComments() {
//        return new ArrayList<>(comments);
//    }


    @Override
    public String toString() {
        return String.format("""
                %s
                Wheels: %d
                Category: %s
                """, super.toString(),getWheels(),getCategory());
    }
}