package com.example.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Matrix {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Id
    private Integer id;
    private String test;

    public Matrix(Integer id, String test) {
        this.id = id;
        this.test = test;
    }
    public Matrix() {

    }
}
