package com.timposulabs.springboot.dto.stream.util;

import com.timposulabs.springboot.dto.stream.dto.PersonDTO;
import com.timposulabs.springboot.dto.stream.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public static PersonDTO toDTO(Person person) {
        return new PersonDTO(person.getId(), person.getFirstName(), person.getLastName());
    }

    public static Person toEntity(PersonDTO personDTO) {
        return new Person(personDTO.id(), personDTO.firstName(), personDTO.lastName());
    }
}
