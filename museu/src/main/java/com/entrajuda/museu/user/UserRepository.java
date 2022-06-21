package com.entrajuda.museu.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User findByName(String name);

    @Query(value = "SELECT name FROM user", nativeQuery = true)
    List<Object> findUserNames();
}