package com.mna.learning.rest.controller;

import com.mna.learning.rest.model.PersonDto;
import com.mna.learning.rest.service.PersonService;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PersonRestControllerTest {

    private MockMvc mockMvc;
    private PersonRestController personRestController;

    @Mock
    PersonService personService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        personRestController = new PersonRestController(personService);
        mockMvc = MockMvcBuilders
                .standaloneSetup(personRestController)
                .build();

        standaloneSetup(personRestController);
    }

    @Test
    public void should_create_new_person(){
        PersonDto personDto = PersonDto.builder().name("Hassan").age(32).build();
        given().
                body(personDto).
                contentType(MediaType.APPLICATION_JSON_VALUE).
        when().
                post("/person").
                then().
                statusCode(200);
    }

    @Test
    public void should_return_200_when_person_found() {
        Mockito.when(personService.getById(1l)).thenReturn(PersonDto.builder().build());
        when().
                get("/person/1").
                then().
                statusCode(200);
    }

    @Test
    public void should_return_404_when_person_not_found() {
        Mockito.when(personService.getById(1l)).thenReturn(null);
        when().
                get("/person/1").
                then().
                statusCode(404);
    }

}