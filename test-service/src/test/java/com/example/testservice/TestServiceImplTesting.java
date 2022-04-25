package com.example.testservice;

import com.example.testservice.entity.Test;
import com.example.testservice.entity.Versions;
import com.example.testservice.repository.TestRepository;
import com.example.testservice.repository.VersionRepository;
import com.example.testservice.service.TestService;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class TestServiceImplTesting {

    @MockBean
    private TestRepository testrepository;

    @MockBean
    private VersionRepository versionRepository;

    @MockBean
    private ApplicationContext applicationContext;

    @Autowired
    private TestService testService;

    @org.junit.Test
    void getTestchecking(){

       // Versions versions1=new Versions("NEST", "B3-10-02-2022",1,3,4);
       // Versions versions2=new Versions("NEST", "B3-10-02-2022",1,3,4);

        Versions versions3=new Versions();
       // versions3.setVersion((Arrays.asList(versions1,versions2)));when(versionRepository.getAll

        //Test test=testrepository.findByEcuName().get();
        //Assertions.assertThat(test.getEcuName()).isEqualTo(ECAB-106);
    }




    /*@org.junit.Test
    void getAllTest(){
        List<Test> test=testrepository.findAll();
        //Assertions.assertThat(test.size()).isGreaterThan(0);
    }*/


}
