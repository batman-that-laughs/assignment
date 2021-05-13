package com.assignment.patient.validators;

import com.assignment.patient.domain.PatientProfile;
import com.assignment.patient.domain.ProfileValidatorResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientProfileValidator {

    public ProfileValidatorResult isValid(PatientProfile profile){

        List<String> errorMessages = new ArrayList<>();
        String numberValue = profile.getPhoneNumber() + "";
        if(numberValue.length() != 10 )
            errorMessages.add("Phone Number must have 10 digits.");

        if(profile.getFullName().length() > 200)
            errorMessages.add("Full name must not exceed 200 characters.");


        if(errorMessages.size() > 0)
            return new ProfileValidatorResult(false, errorMessages);
        else
            return new ProfileValidatorResult(true, null);
    }
}
