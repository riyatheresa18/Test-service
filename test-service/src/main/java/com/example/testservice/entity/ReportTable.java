package com.example.testservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportTable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int ReportId;
    private String ToolName;
    private int TotalFail;
    private int TotalTests;
    private int TotalPass;
    private String ecuName;
    private String version;
    private java.sql.Timestamp ExecutionTimestamp;







}
