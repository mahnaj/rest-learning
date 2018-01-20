package com.mna.learning.rest.service.impl;

import com.mna.learning.rest.dao.Person;
import com.mna.learning.rest.dao.PersonRepository;
import com.mna.learning.rest.model.PersonDto;
import com.mna.learning.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(PersonDto personDto) {
        if (personDto != null) {
            personRepository.save(Person.builder()
                    .name(personDto.getName())
                    .age(personDto.getAge())
                    .build());
        }
    }

    @Override
    public PersonDto getById(Long id) {
        Person person = personRepository.findOne(id);
        if (person != null)
            return PersonDto.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .age(person.getAge())
                    .build();

        return null;
    }
}
