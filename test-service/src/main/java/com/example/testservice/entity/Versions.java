package com.example.testservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Versions {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int versionId;
    private String toolName;
    private String version;
    private int passed;
    private int failed;
    private int total;
    private int testId;


    //public Versions(String nest, String s, int i, int i1, int i2) {
    //}
}
