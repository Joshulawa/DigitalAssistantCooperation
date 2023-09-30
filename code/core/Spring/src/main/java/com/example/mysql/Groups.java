package com.example.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Groups {
    @Id
    private Integer id;
    private String groupName;

    public Groups(Integer id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Groups() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
