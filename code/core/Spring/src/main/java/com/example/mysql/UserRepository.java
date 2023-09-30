package com.example.mysql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Spring will automatically implement into userRepository

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT id FROM USER u WHERE u.name = :name", nativeQuery = true)
    Integer getIdByName(String name);

    @Query(value = "SELECT id FROM USER u WHERE u.matrixID = :serviceId", nativeQuery = true)
    Integer getIdByServiceId(String serviceId);

}



// name = root
// pass = password
// user is root@localhost
