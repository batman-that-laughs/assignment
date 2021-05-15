package com.assignment.patient.rest;

import com.assignment.patient.constants.ResponseMessage;
import com.assignment.patient.domain.PatientRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/sdk")
public interface SDKDemoApi {

    @PostMapping(path = "/demo", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "call to demo sdk method")
    @ApiResponses(value = {@ApiResponse(code= HttpServletResponse.SC_OK, message = ResponseMessage.SUCCESS_MESSAGE),
            @ApiResponse(code=HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = ResponseMessage.ERROR_MESSAGE)})
    ResponseEntity sdkDemo();

}
