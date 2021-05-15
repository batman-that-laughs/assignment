package com.assignment.patient.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidDataException extends Exception{

    private String message;

    private List<String> errorMessages;
}
