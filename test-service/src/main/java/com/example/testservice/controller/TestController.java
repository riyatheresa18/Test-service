package com.example.testservice.controller;


import com.example.testservice.entity.*;
import com.example.testservice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping(value="/{ecuName}") //find by ecuName
    public ResponseVO findbyEcuName(String ecuName){

        return  testService.findbyEcuName(ecuName);
    }

    @GetMapping(value="/view-all")   //get all data
    public Map<String, List<Versions>> getAllData(){

        return testService.getAllData();
    }

    @GetMapping(value="/findbytoolName/{ecuName}/{toolName}")  //find tioolname using ecuname
    public List<Versions> getAllToolName(@PathVariable String ecuName, @PathVariable String toolName){

        return testService.getAllToolName(ecuName, toolName);
    }

    @PostMapping(value="/addTest")  //Add data
    public ResponseVO addTest(@RequestBody ResponseTemplate responseTemplate){
        return testService.postTest(responseTemplate);

    }

    @PostMapping(value="/addToReportTable")  //Add data to Report Table
    public ReportTable addToReportTable(@RequestBody ReportTable reportTable){
        return testService.addToReportTable(reportTable);

    }
}
