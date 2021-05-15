package com.assignment.patient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileValidatorResult {

    private Boolean isValid;

    private List<String> errorMessages;

}
