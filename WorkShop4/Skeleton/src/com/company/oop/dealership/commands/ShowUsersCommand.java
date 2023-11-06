package com.company.oop.dealership.commands;

import com.company.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.company.oop.dealership.models.contracts.User;
import com.company.oop.dealership.models.enums.UserRole;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.List;

public class ShowUsersCommand extends BaseCommand {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 0;
    public ShowUsersCommand(VehicleDealershipRepository vehicleDealershipRepository){
        super(vehicleDealershipRepository);
    }

    @Override
    protected boolean requiresLogin() {
        return true;
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        User user = getVehicleDealershipRepository().getLoggedInUser();
        if (user.getRole() != UserRole.ADMIN){
        throw new IllegalArgumentException("You are not admin!");
        }
        return user.getUsername();
    }

}