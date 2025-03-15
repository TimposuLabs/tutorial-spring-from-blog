package com.timposulabs.springboot.dto.stream.repository;

import com.timposulabs.springboot.dto.stream.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
