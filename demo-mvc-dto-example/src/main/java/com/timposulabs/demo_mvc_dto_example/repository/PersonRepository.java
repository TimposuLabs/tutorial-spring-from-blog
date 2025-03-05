package com.timposulabs.demo_mvc_dto_example.repository;

import com.timposulabs.demo_mvc_dto_example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
