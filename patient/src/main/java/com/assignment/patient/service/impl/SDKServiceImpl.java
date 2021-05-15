package com.assignment.patient.service.impl;

import com.example.demo.sdkDemo.SDKDemo;
import com.assignment.patient.service.SDKService;
import org.springframework.stereotype.Service;

@Service
public class SDKServiceImpl implements SDKService {

    SDKDemo sdkDemo;

    @Override
    public String callDemoMethod(){
        sdkDemo = new SDKDemo();
        return sdkDemo.demo();
    }
}
