package com.example.testservice.service;

import com.example.testservice.entity.ResponseTemplate;
import com.example.testservice.entity.Test;
import com.example.testservice.entity.Versions;
import com.example.testservice.repository.TestRepository;
import com.example.testservice.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private VersionRepository versionRepository;

    public List<Test> findbyecuName(String ecuName) {

        return testRepository.findByEcuName(ecuName);
    }

    /*public List<Versions> findAllToolName(String toolName) {

        return versionRepository.findAllToolName(toolName);
    } */

    public List<Test> getAllData() {
        return testRepository.findAll();
    }

    public ResponseTemplate postTest(ResponseTemplate responseTemplate){

      Test test = new Test();
      List list1= new ArrayList();
      list1= test.getVersions();
      list1.add((responseTemplate.getVersions()));
      test.setVersions(list1);
      versionRepository.saveAll(list1);

        ResponseTemplate responseTemplate1=new ResponseTemplate();
        responseTemplate1.setTest( testRepository.save(test));
        responseTemplate1.setVersions(list1);
        return responseTemplate1;

    }

}
