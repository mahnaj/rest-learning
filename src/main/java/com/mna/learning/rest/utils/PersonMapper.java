package com.mna.learning.rest.utils;

import com.mna.learning.rest.dao.Person;
import com.mna.learning.rest.model.PersonDto;

public class PersonMapper {
    public PersonDto fromPersonToPersonDto(final Person person) {
        return person != null ?
                PersonDto.builder()
                        .id(person.getId() != null ? person.getId() : null)
                        .name(person.getName())
                        .age(person.getAge()).build()
                : null;
    }

    public Person fromPersonDtoToPerson(final PersonDto personDto) {
        return personDto != null ?
                Person.builder()
                        .id(personDto.getId() != null ? personDto.getId() : null)
                        .name(personDto.getName())
                        .age(personDto.getAge()).build()
                : null;
    }
}
