package com.timposulabs.springboot.dto.stream.util;

import com.timposulabs.springboot.dto.stream.dto.PersonDTO;
import com.timposulabs.springboot.dto.stream.model.Person;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PersonMapperToEntity implements Function<PersonDTO, Person> {
    @Override
    public Person apply(PersonDTO personDTO) {
        return new Person(personDTO.id(), personDTO.firstName(), personDTO.lastName());
    }
}
