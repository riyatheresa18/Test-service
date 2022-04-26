package com.example.testservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"ecuName"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int testId;
    private String ecuName;


}
