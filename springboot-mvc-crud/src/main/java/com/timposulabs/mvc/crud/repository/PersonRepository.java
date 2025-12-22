package com.timposulabs.mvc.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timposulabs.mvc.crud.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByEmail(String email);
    
    boolean existsByEmailAndIdNot(String email, Long id);
}
