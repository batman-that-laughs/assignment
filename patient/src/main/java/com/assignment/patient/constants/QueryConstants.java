package com.assignment.patient.constants;

public class QueryConstants {

    public static final String GET_PATIENTS_QUERY = "select new com.assignment.patient.domain.PatientListResponse(" +
            "pe.patientId, pe.fullName) from com.assignment.patient.domain.entities.PatientEntity pe";

    public static final String GET_PATITENT_BY_ID_QUERY = "select new com.assignment.patient.domain.PatientProfile(" +
            "pe.patientId, pe.fullName, pe.gender, pe.phoneNumber) from com.assignment.patient.domain.entities.PatientEntity pe " +
            "where pe.patientId = :id";

    public static final String IF_ANY_DATA_EXIST_QUERY = "select count(pe) from com.assignment.patient.domain.entities.PatientEntity pe";
}
