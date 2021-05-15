package com.assignment.patient.service;

import com.assignment.patient.domain.PatientListResponse;
import com.assignment.patient.domain.PatientProfile;
import com.assignment.patient.domain.PatientRequest;

import java.util.List;


public interface PatientProfileCrudService {

    void savePatientProfile(PatientProfile profile) throws Exception;

    List<PatientListResponse> getPatientList() throws Exception;

    PatientProfile getPatientDetail(PatientRequest profileRequest) throws Exception;

    void deletePatientDetail(PatientRequest profileRequest) throws Exception;
}
