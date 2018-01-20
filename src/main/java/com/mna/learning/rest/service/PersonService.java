package com.mna.learning.rest.service;

import com.mna.learning.rest.model.PersonDto;

public interface PersonService {
    void save(final PersonDto personDto);
    PersonDto getById(final Long id);
}
