package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;

public abstract class ProductImpl implements Product {
    protected String name;
    protected String brandName;

    protected double price;
    protected GenderType genderType;

    public ProductImpl(String name, String brandName, double price, GenderType genderType) {
       nameValidation(name);
       brandNameValidation(brandName);
       priceValidation(price);
        this.genderType = genderType;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
    protected abstract void nameValidation(String name);

    @Override
    public String getBrandName() {
        return brandName;
    }

    private void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    protected abstract void brandNameValidation(String brandName);

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
    protected abstract void priceValidation(double price);

    @Override
    public GenderType getGenderType() {
        return genderType;
    }

    @Override
    public String print(){
        return String.format("""
                 %s %s
                Price: $%.2f
                Gender: %s
                """,name,brandName,price,genderType);
    }

}
