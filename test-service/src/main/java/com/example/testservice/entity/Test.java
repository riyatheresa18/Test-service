package com.example.testservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String ecuName;
    @OneToMany(mappedBy = "test",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Versions> versions;

}
