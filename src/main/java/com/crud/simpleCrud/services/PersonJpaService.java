package com.crud.simpleCrud.services;

import com.crud.simpleCrud.entities.PersonEntity;
import com.crud.simpleCrud.repositories.PersonRepository;

import java.util.HashSet;
import java.util.Set;

public class PersonJpaService implements CrudService <PersonEntity,Long> {
    private final PersonRepository personRepository;

    public PersonJpaService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Set findAll() {
        Set<PersonEntity> personEntitiesSet = new HashSet<>();
        personRepository.findAll().forEach(personEntitiesSet::add);
        return personEntitiesSet;
    }

    @Override
    public PersonEntity findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public PersonEntity save(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}