package com.assignment.patient.dao;

import com.assignment.patient.domain.PatientListResponse;
import com.assignment.patient.domain.PatientProfile;
import com.assignment.patient.domain.PatientRequest;
import com.assignment.patient.domain.entities.PatientEntity;

import java.util.List;


public interface PatientProfileCrudDao {

    void savePatientProfile(PatientEntity patientEntity);

    List<PatientListResponse> getPatientList() throws Exception;

    PatientProfile getPatient(PatientRequest profileRequest) throws Exception;

    void deleteRecord(Integer id) throws Exception;
}
