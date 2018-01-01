package com.mna.learning.rest.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void should_create_a_new_person() {
        Person person = personRepository.save(Person.builder().name("maha").age(29).build());
        Assert.assertNotNull(person);
        Assert.assertEquals("maha",person.getName());
    }

    @Test
    public void should_find_person_by_id(){
        Person person = personRepository.save(Person.builder().name("hassan").age(32).build());
        Person expectedPerson = personRepository.findOne(person.getId());
        Assert.assertNotNull(expectedPerson);
        Assert.assertEquals(32,expectedPerson.getAge());
    }
}