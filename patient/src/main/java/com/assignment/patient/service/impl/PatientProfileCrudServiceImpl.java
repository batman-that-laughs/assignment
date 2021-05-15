package com.assignment.patient.service.impl;

import com.assignment.patient.dao.PatientProfileCrudDao;
import com.assignment.patient.domain.PatientListResponse;
import com.assignment.patient.domain.PatientProfile;
import com.assignment.patient.domain.PatientRequest;
import com.assignment.patient.domain.ProfileValidatorResult;
import com.assignment.patient.domain.entities.PatientEntity;
import com.assignment.patient.exceptions.InvalidDataException;
import com.assignment.patient.service.PatientProfileCrudService;
import com.assignment.patient.utils.CrudOperationsUtils;
import com.assignment.patient.validators.PatientProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientProfileCrudServiceImpl implements PatientProfileCrudService {

    @Autowired
    private PatientProfileCrudDao patientProfileCrudDao;

    @Autowired
    private CrudOperationsUtils crudOperationsUtils;

    @Autowired
    private PatientProfileValidator validator;

    @Override
    public void savePatientProfile(PatientProfile profile) throws Exception{

        ProfileValidatorResult validatorResult = validator.isValid(profile);
        if(!validatorResult.getIsValid())
            throw new InvalidDataException("Invalid Profile Details", validatorResult.getErrorMessages());
        PatientEntity patientEntity = crudOperationsUtils.map(profile, PatientEntity.class);
        patientProfileCrudDao.savePatientProfile(patientEntity);

    }

    @Override
    public List<PatientListResponse> getPatientList() throws Exception{
        return patientProfileCrudDao.getPatientList();
    }

    @Override
    public PatientProfile getPatientDetail(PatientRequest profileRequest) throws Exception {
        return patientProfileCrudDao.getPatient(profileRequest);
    }

    @Override
    public void deletePatientDetail(PatientRequest profileRequest) throws Exception {
        patientProfileCrudDao.deleteRecord(profileRequest.getId());
    }
}
