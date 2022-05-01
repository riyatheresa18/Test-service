package com.example.testservice.repository;

import com.example.testservice.entity.ReportTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportTableRepository extends JpaRepository<ReportTable,Integer> {
}
