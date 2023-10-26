package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;

public abstract class ProductImpl implements Product {
    private String name;
    private String brandName;

    private double price;
    private final GenderType genderType;

    public ProductImpl(String name, String brandName, double price, GenderType genderType) {
       setName(name);
       setBrandName(brandName);
       setPrice(price);

        this.genderType = genderType;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        nameValidation(name);
        this.name = name;
    }
    protected abstract void nameValidation(String name);

    @Override
    public String getBrandName() {
        return brandName;
    }

    private void setBrandName(String brandName) {
        brandNameValidation(brandName);
        this.brandName = brandName;
    }
    protected abstract void brandNameValidation(String brandName);

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        priceValidation(price);
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
            #%s %s
             #Price: $%.2f
             #Gender: %s""",name,brandName,price,genderType);
    }

}
