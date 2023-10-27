package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import static com.company.oop.cosmetics.utils.ParsingHelpers.INVALID_MILLILITRES;
import static com.company.oop.cosmetics.utils.ParsingHelpers.INVALID_PRICE;


public class ShampooImpl extends ProductImpl implements Shampoo {

    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_NAME_MIN_LENGTH = 2;
    private static final int BRAND_NAME_MAX_LENGTH = 10;
    private int milliliters;
    private final UsageType usageType;

    public ShampooImpl(String name, String brand, double price, GenderType genderType, int milliliters, UsageType usageType) {
        super(name, brand, price, genderType);
        setMilliliters(milliliters);
        this.usageType = usageType;
    }

    @Override
    protected void nameValidation(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Name");
    }

    @Override
    protected void brandNameValidation(String brandName) {
        ValidationHelpers.validateStringLength(brandName, BRAND_NAME_MIN_LENGTH, BRAND_NAME_MAX_LENGTH,
                "Brand name");
    }

    @Override
    protected void priceValidation(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

    private void setMilliliters(int milliliters) {
        if (milliliters < 0) {
            throw new IllegalArgumentException(INVALID_MILLILITRES);
        } else {
            this.milliliters = milliliters;
        }
    }

    @Override
    public int getMillilitres() {
        return this.milliliters;
    }

    @Override
    public UsageType getUsageType() {
        return this.usageType;
    }

    @Override
    public String print() {
        return String.format("""
                %s
                 #Milliliters: %d
                 #Usage: %s
                """, super.print(), milliliters, usageType);
    }

    /*
    #{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Milliliters: {milliliters}
 #Usage: {usageType}
 ===
     */
//     This method should be uncommented when you are done with the class.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShampooImpl shampoo = (ShampooImpl) o;
        return getName().equals(shampoo.getName()) &&
                getBrandName().equals(shampoo.getBrandName()) &&
                getPrice() == shampoo.getPrice() &&
                getGenderType().equals(shampoo.getGenderType()) &&
                getMillilitres() == shampoo.getMillilitres() &&
                getUsageType().equals(shampoo.getUsageType());
    }
}
