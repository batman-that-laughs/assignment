package com.assignment.patient.repositories;

import com.assignment.patient.constants.QueryConstants;
import com.assignment.patient.domain.PatientListResponse;
import com.assignment.patient.domain.PatientProfile;
import com.assignment.patient.domain.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

    @Query(QueryConstants.IF_ANY_DATA_EXIST_QUERY)
    Integer anyDataExists();

    @Query(QueryConstants.GET_PATIENTS_QUERY)
    List<PatientListResponse> getPatientList();

    @Query(QueryConstants.GET_PATITENT_BY_ID_QUERY)
    PatientProfile getPatientById(@Param("id") Integer id);

    @Override
    void deleteById(Integer id);

    @Override
    boolean existsById(Integer id);
}
