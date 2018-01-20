package com.mna.learning.rest.utils;

import com.mna.learning.rest.dao.Person;
import com.mna.learning.rest.model.PersonDto;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonMapperTest {
    private PersonMapper personMapper;
    private Person fromPerson;
    private PersonDto fromPersonDto;


    @Before
    public void setUp() {
        personMapper = new PersonMapper();
        fromPerson = createPerson(1l, "Maha", 30);
        fromPersonDto = createPersonDto(1l, "Maha", 30);
    }


    @Test
    public void should_return_personDto_when_given_person_is_not_null() {
        Person person = personMapper.fromPersonDtoToPerson(fromPersonDto);
        assertThat(person).isNotNull();
        assertThat(person.getId()).isEqualTo(fromPersonDto.getId());
        assertThat(person.getName()).isEqualTo(fromPersonDto.getName());
        assertThat(person.getAge()).isEqualTo(fromPersonDto.getAge());
    }

    @Test
    public void should_return_person_when_given_personDto_is_not_null() {
        PersonDto personDto = personMapper.fromPersonToPersonDto(fromPerson);
        assertThat(personDto).isNotNull();
        assertThat(personDto.getId()).isEqualTo(fromPerson.getId());
        assertThat(personDto.getName()).isEqualTo(fromPerson.getName());
        assertThat(personDto.getAge()).isEqualTo(fromPerson.getAge());
    }

    private static PersonDto createPersonDto(final long id, final String name, final int age) {
        return PersonDto.builder()
                .id(id)
                .name(name)
                .age(age)
                .build();
    }

    private static Person createPerson(final long id, final String name, final int age) {
        return Person.builder()
                .id(id)
                .name(name)
                .age(age)
                .build();
    }
}
