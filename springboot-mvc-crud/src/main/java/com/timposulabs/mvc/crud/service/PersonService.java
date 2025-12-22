package com.timposulabs.mvc.crud.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.timposulabs.mvc.crud.dto.PersonDTO;

public interface PersonService {
    Page<PersonDTO> getAllPersons(Pageable pageable);
    PersonDTO getPersonById(Long id);
    PersonDTO createPerson(PersonDTO personDTO);
    PersonDTO updatePerson(Long id, PersonDTO personDTO);
    void deletePerson(Long id);
    boolean isEmailUnique(String email, Long id); // handle email unique
    Page<PersonDTO> search(String keyword, Pageable pageable);
}