package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity

//

public class User {
    // private Object GenerationType;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private String name;
    //private String email;

    @Embedded
    private name names;


    @Embedded
    private email emails;

    public User() {}
}