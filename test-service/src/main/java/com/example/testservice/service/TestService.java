package com.example.testservice.service;

import com.example.testservice.entity.*;
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

    public Test findbyEcuName(String ecuName) {

        return testRepository.findByEcuName(ecuName);
    }

    public List<Versions> getAllToolName(String ecuName ,String toolName) {
    List<Test> list2= new ArrayList<>();

    Test t1= (Test) testRepository.findByEcuName(ecuName);
    List<Versions> v2= new ArrayList<>();
    for(Versions v:versionRepository.findAll()){
        if(v.getToolName().equals(toolName) && v.getTestId()==t1.getTestId()){
            v2.add(v);
        }

    }
    return v2;
    }

    public List<Test> getAllData() {
        return testRepository.findAll();
    }

    public ResponseVO postTest(ResponseTemplate responseTemplate){
    List<Versions> list1= new ArrayList<>();
    Test test=new Test();
    test.setEcuName(responseTemplate.getTestRequest().getEcuName());
    ResponseVO vo=new ResponseVO();
      vo.setTest(testRepository.save(test));
      for( Version v: responseTemplate.getVersion()){
          Versions versions=new Versions();
          versions.setToolName(v.getToolName());
          versions.setVersion(v.getVersion());
          versions.setPassed(v.getPassed());
          versions.setFailed(v.getFailed());
          versions.setTotal(v.getTotal());
          versions.setTestId(vo.getTest().getTestId());
          list1.add(versionRepository.save(versions));
      }
      vo.setVersions(list1);
      return vo;
    }

}
