package com.timposulabs.springboot.dto.stream.service;

import com.timposulabs.springboot.dto.stream.dto.PersonDTO;
import com.timposulabs.springboot.dto.stream.repository.PersonRepository;
import com.timposulabs.springboot.dto.stream.util.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll()
                .stream()
                .map(person -> new PersonDTO(
                        person.getId(),
                        person.getFirstName(),
                        person.getLastName()))
                .collect(Collectors.toList());
    }

}
