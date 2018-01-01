package com.mna.learning.rest.service.impl;

import com.mna.learning.rest.dao.Person;
import com.mna.learning.rest.dao.PersonRepository;
import com.mna.learning.rest.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PersonServiceImplTest {

    PersonService personService;

    @Mock
    PersonRepository personRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        personService = new PersonServiceImpl(personRepository);
    }

    @Test
    public void should_save_a_new_person() throws Exception {
        Person person = Person.builder().id(4l).name("yasmine").age(1).build();
        personService.save(person);
        Mockito.verify(personRepository,Mockito.times(1)).save(person);
    }

    @Test
    public void should_get_person_by_id() throws Exception {
        Person person = Person.builder().id(1l).name("hiba").age(8).build();
        Mockito.when(personRepository.findOne(1l)).thenReturn(person);
        Person foundPerson = personService.getById(1l);
        Assert.assertNotNull(foundPerson);
        Assert.assertEquals(person.getName(), foundPerson.getName());
    }

}