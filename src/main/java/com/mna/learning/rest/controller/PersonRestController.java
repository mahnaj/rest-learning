package com.mna.learning.rest.controller;

import com.mna.learning.rest.model.PersonDto;
import com.mna.learning.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestController(final PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/ping")
    public String ping() {
        return "Poooooooong !!!";
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody final PersonDto personDto) {
        personService.save(personDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> get(@PathVariable final Long id) {
        final PersonDto byId = personService.getById(id);
        return byId != null ? ResponseEntity.ok(byId) : ResponseEntity.notFound().build();
    }
}
