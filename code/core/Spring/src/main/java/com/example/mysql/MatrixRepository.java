package com.example.mysql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatrixRepository extends CrudRepository<Matrix, Integer> {
    @Query(value = "SELECT * FROM MATRIX m WHERE m.id = :id", nativeQuery = true)
    List<String> getAll(Integer id);

    @Query(value = "SELECT homeserver FROM MATRIX m WHERE m.id = :id", nativeQuery = true)
    String getServer(Integer id);

    @Query(value = "SELECT username FROM MATRIX m WHERE m.id = :id", nativeQuery = true)
    String getUsername(Integer id);

    @Query(value = "SELECT password FROM MATRIX m WHERE m.id = :id", nativeQuery = true)
    String getPassword(Integer id);
}