package com.timposulabs.springboot.dto.stream.util;

import com.timposulabs.springboot.dto.stream.dto.PersonDTO;
import com.timposulabs.springboot.dto.stream.model.Person;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PersonMapperToDTO implements Function<Person, PersonDTO> {
    @Override
    public PersonDTO apply(Person person) {
        return new PersonDTO(person.getId(), person.getFirstName(), person.getLastName());
    }
}
