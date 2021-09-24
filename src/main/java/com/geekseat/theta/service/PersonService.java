package com.geekseat.theta.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekseat.theta.helper.Decorator;
import com.geekseat.theta.model.Person;
import com.geekseat.theta.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService extends BaseService {

    @Autowired
    private PersonRepository personRepository;

    ObjectMapper mapper = new ObjectMapper();

    public final Decorator<Person> fromDecorator = new Decorator<Person>() {
        @Override
        public Person decorate(Person entity) {
            try {
                if (entity != null) {

                    fromDecorate(entity);

                    if (entity.getAttachmentListData() != null && !entity.getAttachmentListData().isEmpty()) {
                        entity.setAttachmentList(mapper.readValue(entity.getAttachmentListData(), List.class));
                        entity.setAttachmentListData(null);
                    }

                }

                return entity;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return entity;
            }
        }

        @Override
        public Iterable<Person> decorate(Iterable<Person> entityList) {
            for (Person person : entityList) {
                fromDecorator.decorate(person);
            }
            return entityList;
        }
    };

    public Iterable<Person> findAll() {
        return fromDecorator.decorate(personRepository.findAll());
    }

}
