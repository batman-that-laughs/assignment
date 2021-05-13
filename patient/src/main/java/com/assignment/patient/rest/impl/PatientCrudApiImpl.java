package com.assignment.patient.rest.impl;

import com.assignment.patient.constants.ResponseMessage;
import com.assignment.patient.domain.PatientListResponse;
import com.assignment.patient.domain.PatientProfile;
import com.assignment.patient.domain.PatientRequest;
import com.assignment.patient.domain.Response;
import com.assignment.patient.exceptions.InvalidDataException;
import com.assignment.patient.rest.PatientCrudApi;
import com.assignment.patient.service.PatientProfileCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientCrudApiImpl implements PatientCrudApi {

    @Autowired
    private PatientProfileCrudService patientProfileCrudService;

    @Override
    public ResponseEntity savePatientProfile(PatientProfile profile) {
        try {
            patientProfileCrudService.savePatientProfile(profile);
            return new ResponseEntity(new Response("Created Successfully", ResponseMessage.SUCCESS_MESSAGE, null), HttpStatus.OK);
        }catch(InvalidDataException invalidDataException){
            return new ResponseEntity(new Response(null, ResponseMessage.ERROR_MESSAGE, invalidDataException.getErrorMessages()), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception e){
            return new ResponseEntity(new Response(null, ResponseMessage.ERROR_MESSAGE, List.of(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity getPatientList() {
        try{
            List<PatientListResponse> patientListResponseList = patientProfileCrudService.getPatientList();
            return new ResponseEntity(new Response(patientListResponseList, ResponseMessage.SUCCESS_MESSAGE, null), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new Response(null, ResponseMessage.ERROR_MESSAGE, List.of(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity getPatientProfile(PatientRequest profileRequest) {
        try{
            PatientProfile patientProfile = patientProfileCrudService.getPatientDetail(profileRequest);
            return new ResponseEntity(new Response(patientProfile, ResponseMessage.SUCCESS_MESSAGE, null), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new Response(null, ResponseMessage.ERROR_MESSAGE, List.of(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deletePatient(PatientRequest patientRequest) {
        try{
            patientProfileCrudService.deletePatientDetail(patientRequest);
            return new ResponseEntity(new Response("Deleted Successfully", ResponseMessage.SUCCESS_MESSAGE, null), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new Response(null, ResponseMessage.ERROR_MESSAGE, List.of(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
