package com.mna.learning.rest.service;

import com.mna.learning.rest.dao.Person;

public interface PersonService {
    void save(final Person person);
    Person getById(final Long id);
}
