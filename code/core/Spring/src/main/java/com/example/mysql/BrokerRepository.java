package com.example.mysql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrokerRepository extends CrudRepository<Broker, Integer> {
    //Gets the id of users who are in a group via the associated group id.
    @Query(value = "SELECT idUsers FROM BROKER b WHERE b.idGroup = :groupId", nativeQuery = true)
    List<Integer> getId(Integer groupId);



}