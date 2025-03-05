package com.timposulabs.demo_mvc_dto_example.mapper;

import com.timposulabs.demo_mvc_dto_example.dto.PersonDTO;
import com.timposulabs.demo_mvc_dto_example.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toPerson(PersonDTO personDTO);

    PersonDTO toPersonDTO(Person person);

}
