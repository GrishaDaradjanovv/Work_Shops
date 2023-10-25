package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ParsingHelpers;

import java.util.Arrays;
import java.util.List;

import static com.company.oop.cosmetics.utils.ParsingHelpers.PRODUCT_CREATED;
import static com.company.oop.cosmetics.utils.ParsingHelpers.PRODUCT_NAME_ALREADY_EXISTS;

public class CreateToothpasteCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateToothpasteCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        String toothpasteName = parameters.get(0);
        String toothpasteBrandName = parameters.get(1);
        double toothpastePrice = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        String ingredients = parameters.get(4);
        List<String> ingredientsList = Arrays.asList(ingredients.split(","));

        return createToothpaste(toothpasteName,toothpasteBrandName,toothpastePrice,genderType,ingredientsList);
    }

    private String createToothpaste(String toothpasteName, String toothpasteBrandName, double toothpastePrice,
                                    GenderType genderType,List<String>ingredientsList){
        if (cosmeticsRepository.productExist(toothpasteName)){
            throw new IllegalArgumentException(String.format(PRODUCT_NAME_ALREADY_EXISTS,"Toothpaste", toothpasteName));
        }
        cosmeticsRepository.createToothpaste(toothpasteName,toothpasteBrandName,toothpastePrice,genderType
                ,ingredientsList);
        return String.format(PRODUCT_CREATED,"Toothpaste",toothpasteName);
    }

}