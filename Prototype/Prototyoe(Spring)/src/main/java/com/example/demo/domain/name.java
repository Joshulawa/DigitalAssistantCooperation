package com.example.demo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;


@Data
@AllArgsConstructor
@Embeddable


public class name {
    private String name;

    public name() {}


}