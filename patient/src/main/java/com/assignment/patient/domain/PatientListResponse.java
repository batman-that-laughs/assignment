package com.assignment.patient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientListResponse {

    private Integer patientId;

    private String fullName;
}
