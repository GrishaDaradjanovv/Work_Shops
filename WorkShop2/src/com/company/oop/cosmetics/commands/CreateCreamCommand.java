package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

import static com.company.oop.cosmetics.utils.ParsingHelpers.PRODUCT_CREATED;
import static com.company.oop.cosmetics.utils.ParsingHelpers.PRODUCT_NAME_ALREADY_EXISTS;

public class CreateCreamCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateCreamCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        String creamName = parameters.get(0);
        String creamBrandName = parameters.get(1);
        double creamPrice = ParsingHelpers.tryParseDouble(parameters.get(2),ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        ScentType scentType = ParsingHelpers.tryParseScent(parameters.get(4));

        return createCream(creamName,creamBrandName,creamPrice,genderType,scentType);
    }
    private String createCream(String creamName, String brandName, double cramPrice,GenderType genderType
            ,ScentType scentType){
        if (cosmeticsRepository.productExist(creamName)){
            throw new IllegalArgumentException(String.format(PRODUCT_NAME_ALREADY_EXISTS,"Cream",creamName));
        }
        cosmeticsRepository.createCream(creamName,brandName,cramPrice,genderType,scentType);

        return String.format(PRODUCT_CREATED,"Cream",creamName);
    }

}
