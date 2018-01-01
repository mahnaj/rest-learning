package com.mna.learning.rest.service.impl;

import com.mna.learning.rest.dao.Person;
import com.mna.learning.rest.dao.PersonRepository;
import com.mna.learning.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(Person person) {
        if(person != null){
            personRepository.save(person);
        }
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findOne(id);
    }
}
