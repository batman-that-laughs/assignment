package com.assignment.patient.rest.impl;

import com.assignment.patient.constants.ResponseMessage;
import com.assignment.patient.domain.Response;
import com.assignment.patient.rest.SDKDemoApi;
import com.assignment.patient.service.SDKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SDKDemoApiImpl implements SDKDemoApi {

    @Autowired
    SDKService sdkService;

    @Override
    public ResponseEntity sdkDemo() {
        sdkService.callDemoMethod();
        return new ResponseEntity(new Response("SDK Called Successfully", ResponseMessage.SUCCESS_MESSAGE, null), HttpStatus.OK);
    }
}
