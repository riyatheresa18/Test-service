package com.example.testservice.repository;

import com.example.testservice.entity.Test;
import com.example.testservice.entity.Versions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository  extends JpaRepository<Test,Integer> {

    Test findByEcuName(String ecuName);



}
