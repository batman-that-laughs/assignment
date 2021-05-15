package com.assignment.patient.dao.impl;

import com.assignment.patient.dao.PatientProfileCrudDao;
import com.assignment.patient.domain.PatientListResponse;
import com.assignment.patient.domain.PatientProfile;
import com.assignment.patient.domain.PatientRequest;
import com.assignment.patient.domain.entities.PatientEntity;
import com.assignment.patient.exceptions.DataNotFoundException;
import com.assignment.patient.exceptions.NoDataPresentException;
import com.assignment.patient.repositories.PatientRepository;
import com.assignment.patient.utils.CrudOperationsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientProfileCrudDaoImpl implements PatientProfileCrudDao {

    @Autowired
    private CrudOperationsUtils utils;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void savePatientProfile(PatientEntity patientEntity) {
        patientRepository.save(patientEntity);
    }

    @Override
    public List<PatientListResponse> getPatientList() throws Exception{
        utils.checkIfAnyDataIsPresent();
        return patientRepository.getPatientList();
    }

    @Override
    public PatientProfile getPatient(PatientRequest profileRequest) throws Exception {
        utils.checkIfAnyDataIsPresent();
        utils.checkIfParticularDataIsPresent(profileRequest.getId());
        return patientRepository.getPatientById(profileRequest.getId());
    }

    @Override
    public void deleteRecord(Integer id) throws Exception {
        utils.checkIfAnyDataIsPresent();
        utils.checkIfParticularDataIsPresent(id);
        patientRepository.deleteById(id);
    }


}
