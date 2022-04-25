package com.example.testservice.entity;

import lombok.Data;

import java.util.List;

@Data
public class ResponseVO {

    private Test test;
    private List<Versions> versions;
}
