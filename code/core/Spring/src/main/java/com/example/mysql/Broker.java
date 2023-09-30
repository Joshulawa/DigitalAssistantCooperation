package com.example.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// Automatically translate the entity into the table.
public class Broker {
    // each user need id, name and email address to be stored in database.
    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer groupId;

    public Broker(Integer id, Integer userId, Integer groupId){
        this.setId(id);
        this.setUserId(userId);
        this.setGroupId(groupId);
    }

    public Broker() {

    }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setUserId(Integer id) {this.userId = id;}
    public void setGroupId(Integer id) {this.groupId = id;}

    public int getId() {
        return id;
    }
    public Integer getUserId(){
        return userId;
    }
    public Integer getGroupId(){return groupId;}

}