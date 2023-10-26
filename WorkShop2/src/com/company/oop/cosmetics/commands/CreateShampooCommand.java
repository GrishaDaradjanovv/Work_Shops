package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

import static com.company.oop.cosmetics.utils.ParsingHelpers.*;

public class CreateShampooCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;
    private final CosmeticsRepository cosmeticsRepository;

    public CreateShampooCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String shampooName = parameters.get(0);
        String shampooBrand = parameters.get(1);
        double shampooPrice = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3).toUpperCase());
        int milliliters = ParsingHelpers.tryParseInt(parameters.get(4), INVALID_MILLILITRES);
        UsageType usageType = ParsingHelpers.tryParseUsageType(parameters.get(5).toUpperCase());

        return createShampoo(shampooName, shampooBrand, shampooPrice, genderType, milliliters, usageType);
    }

    private String createShampoo(String shampooName, String shampooBrand, double shampooPrice, GenderType genderType
            , int milliliters, UsageType usageType) {
        if (cosmeticsRepository.productExist(shampooName)) {
            throw new IllegalArgumentException(String.format(PRODUCT_NAME_ALREADY_EXISTS, "Shampoo", shampooName));
        }
        cosmeticsRepository.createShampoo(shampooName, shampooBrand, shampooPrice, genderType, milliliters, usageType);
        return String.format(PRODUCT_CREATED, "Shampoo", shampooName);
    }
}
