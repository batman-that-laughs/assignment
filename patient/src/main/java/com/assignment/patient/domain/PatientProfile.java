package com.assignment.patient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientProfile {

    private Integer patientId;

    private String fullName;

    private String gender;

    private Long phoneNumber;
}
