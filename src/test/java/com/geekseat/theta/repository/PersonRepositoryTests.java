package com.geekseat.theta.repository;

import com.geekseat.theta.model.Person;
import com.geekseat.theta.model.PersonRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = {"/sql/delete-data-sample.sql"})
public class PersonRepositoryTests {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testGetPerson() {
        Assertions.assertNotNull(personRepository.findAll());
    }

    @Test
    public void testSavePerson() {
        Person person = new Person();
        person.setMapData("{}");
        person.setName("Test User");
        person.setEmail("user@mail.com");
        person.setPassword("$2a$12$mKW7whIhaeJqes14y7NeJuTyfANYSm7AUPXNjnlPhh660yEZ.Y7uO");
        person.setActive(true);
        person.setRole(PersonRole.Tenant);
        person.setAttachmentListData("[]");
        person.setEditor("{\"id\":1,\"name\":\"Dev Test\",\"email\":\"duomail@mailinator.com\",\"role\":\"Administrator\"}");
        Person save = personRepository.save(person);
        Assertions.assertNotNull(save);
    }
}
