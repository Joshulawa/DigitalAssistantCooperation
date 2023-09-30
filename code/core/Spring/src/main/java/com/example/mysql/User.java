package com.example.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// Automatically translate the entity into the table.
public class User {
    // each user need id, name and email address to be stored in database.
    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;

    public User(Integer id,String name, String email ){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
    }

    public User() {

    }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){return email;}

}