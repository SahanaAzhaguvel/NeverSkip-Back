package com.neverskip.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Student {

    @Id
    private int stdId;
    private String stdName;
    private String className;
    private String section;
    private int score;

    
}

