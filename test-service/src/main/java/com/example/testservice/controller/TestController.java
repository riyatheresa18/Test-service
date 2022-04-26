package com.example.testservice.controller;


import com.example.testservice.entity.ResponseTemplate;
import com.example.testservice.entity.ResponseVO;
import com.example.testservice.entity.Test;
import com.example.testservice.entity.Versions;
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

    @GetMapping(value="/findbytoolName/{ecuName}/{toolName}")
    public List<Versions> getAllToolName(@PathVariable String ecuName, @PathVariable String toolName){

        return testService.getAllToolName(ecuName, toolName);
    }

    @PostMapping(value="/addTest")  //Add data
    public ResponseVO addTest(@RequestBody ResponseTemplate responseTemplate){
        return testService.postTest(responseTemplate);

    }
}
