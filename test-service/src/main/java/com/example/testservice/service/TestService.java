package com.example.testservice.service;

import com.example.testservice.entity.*;
import com.example.testservice.repository.ReportTableRepository;
import com.example.testservice.repository.TestRepository;
import com.example.testservice.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private VersionRepository versionRepository;

    @Autowired
    private ReportTableRepository reportTableRepository;

    public ResponseVO findbyEcuName(String ecuName) {

        Test test1=testRepository.findByEcuName(ecuName);        // create object nd find by ecuname
        List<Versions> v1=versionRepository.findByTestId(test1.getTestId()); //find versions by using test id
        ResponseVO vo= new ResponseVO();
        vo.setTest(test1);
        vo.setVersions(v1);
        return vo;
    }

    public List<Versions> getAllToolName(String ecuName ,String toolName) {
    List<Test> list2= new ArrayList<>();

    Test t1= (Test) testRepository.findByEcuName(ecuName); //traverse and find all toolname
    List<Versions> v2= new ArrayList<>();
    for(Versions v:versionRepository.findAll()){
        if(v.getToolName().equals(toolName) && v.getTestId()==t1.getTestId()){
            v2.add(v);
        }

    }
    return v2;
    }

    public Map<String, List<Versions>> getAllData() {  //find all data by mapping class test and class versions

       Map<String, List<Versions>> map1=new HashMap<>();
       List<Test> l1=testRepository.findAll();
       for(Test test:l1){
           List<Versions> l2= versionRepository.findByTestId(test.getTestId());
           map1.put(test.getEcuName(),l2);
       }
        return map1;
    }

    public ResponseVO postTest(ResponseTemplate responseTemplate){
    List<Versions> list1= new ArrayList<>(); //create list of versions
    Test test=new Test();
    test.setEcuName(responseTemplate.getTestRequest().getEcuName());
    ResponseVO vo=new ResponseVO();
      vo.setTest(testRepository.save(test));
      for( Version v: responseTemplate.getVersion()){  // using for loop set all values
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


    public ReportTable addToReportTable(ReportTable reportTable) { //add data to report table
          return reportTableRepository.save(reportTable);
    }
}
