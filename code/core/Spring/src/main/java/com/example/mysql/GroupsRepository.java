package com.example.mysql;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface GroupsRepository extends CrudRepository<Groups, Integer> {
        //Gets the id of a group from its name.
        @Query(value = "SELECT id  FROM `Groups` g WHERE g.GroupName = :groupName", nativeQuery = true)
        Integer getId(String groupName);
    }
