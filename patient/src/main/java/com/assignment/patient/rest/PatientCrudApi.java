package com.assignment.patient.rest;

import com.assignment.patient.constants.ResponseMessage;
import com.assignment.patient.domain.PatientListResponse;
import com.assignment.patient.domain.PatientProfile;
import com.assignment.patient.domain.PatientRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public interface PatientCrudApi {

    @PostMapping(path = "/save", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "save a patient record")
    @ApiResponses(value = {@ApiResponse(code=HttpServletResponse.SC_OK, message = ResponseMessage.SUCCESS_MESSAGE),
            @ApiResponse(code=HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = ResponseMessage.ERROR_MESSAGE)})
    ResponseEntity savePatientProfile(@RequestBody PatientProfile profile);

    @GetMapping(path = "/getpatientlist", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "get list of patients")
    @ApiResponses(value = {@ApiResponse(code=HttpServletResponse.SC_OK, message = ResponseMessage.SUCCESS_MESSAGE, response = PatientListResponse.class, responseContainer = "List"),
            @ApiResponse(code=HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = ResponseMessage.ERROR_MESSAGE)})
    ResponseEntity getPatientList();

    @PostMapping(path = "/getpatientprofile", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "get a patient profile based on patient id")
    @ApiResponses(value = {@ApiResponse(code=HttpServletResponse.SC_OK, message = ResponseMessage.SUCCESS_MESSAGE, response = PatientProfile.class),
            @ApiResponse(code=HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = ResponseMessage.ERROR_MESSAGE)})
    ResponseEntity getPatientProfile(@RequestBody PatientRequest profileRequest);

    @DeleteMapping(path = "/deletepatient", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "delete a patient record from db")
    @ApiResponses(value = {@ApiResponse(code=HttpServletResponse.SC_OK, message = ResponseMessage.SUCCESS_MESSAGE),
            @ApiResponse(code=HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = ResponseMessage.ERROR_MESSAGE)})
    ResponseEntity deletePatient(@RequestBody PatientRequest patientRequest);

}
