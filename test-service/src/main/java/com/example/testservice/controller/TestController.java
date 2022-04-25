package com.example.testservice.controller;


import com.example.testservice.entity.ResponseTemplate;
import com.example.testservice.entity.Test;
import com.example.testservice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping(value="/{ecuName}") //find by ecuName
    public List<Test> findbyecuName(String ecuName){

        return testService.findbyecuName(ecuName);
    }

    @GetMapping(value="/view-all")   //get all data
    public List<Test> getAllData(){

        return testService.getAllData();
    }

    /*@GetMapping(value="/{ecuName}/{toolName}")
    public List<Test> getAllToolName(String toolName){

        return testService.getAllData();
    }*/

    @PostMapping(value="/addTest")  //Add data
    
    public ResponseTemplate addTest(@RequestBody ResponseTemplate responseTemplate){
        return testService.postTest(responseTemplate);

    }
}
