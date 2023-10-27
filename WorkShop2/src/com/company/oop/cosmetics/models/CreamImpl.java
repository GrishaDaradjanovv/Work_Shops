package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import static com.company.oop.cosmetics.utils.ParsingHelpers.INVALID_PRICE;

public class CreamImpl extends ProductImpl implements Cream {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 15;
    private static final int BRAND_NAME_MIN_LENGTH = 3;
    private static final int BRAND_NAME_MAX_LENGTH = 15;
    private final ScentType scent;

    public CreamImpl(String name, String brandName, double price, GenderType genderType, ScentType scent) {
        super(name, brandName, price, genderType);
        this.scent = scent;
    }

    @Override
    public ScentType getScent() {
        return this.scent;
    }

    @Override
    protected void nameValidation(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Name");
    }

    @Override
    protected void brandNameValidation(String brandName) {
        ValidationHelpers.validateStringLength(brandName,BRAND_NAME_MIN_LENGTH,BRAND_NAME_MAX_LENGTH,
                "Brand name");
    }

    @Override
    protected void priceValidation(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

    @Override
    public String print() {
        return String.format("""
                 %s
                 #Scent: %s
                """, super.print(),getScent());
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreamImpl cream = (CreamImpl) o;
        return getName().equals(cream.getName()) &&
                getBrandName().equals(cream.getBrandName()) &&
                getPrice() == cream.getPrice() &&
                getGenderType().equals(cream.getGenderType()) &&
                getScent().equals(cream.getScent());
    }
}
