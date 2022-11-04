package com.ebi.service;

import com.ebi.dataaccessobject.HobbyRepository;
import com.ebi.dataaccessobject.PersonRepository;
import com.ebi.datatransferobject.DataDTO;
import com.ebi.datatransferobject.PersonDTO;
import com.ebi.domainobject.Hobby;
import com.ebi.domainobject.Person;
import com.ebi.exception.ConstraintsViolationException;
import com.ebi.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPersonService implements PersonService {

    private final PersonRepository personRepository;

    private final HobbyRepository hobbyRepository;

    @Autowired
    public DefaultPersonService(PersonRepository personRepository, HobbyRepository hobbyRepository) {
        this.personRepository = personRepository;
        this.hobbyRepository = hobbyRepository;
    }

    @Override
    public DataDTO findAll() {
        List<PersonDTO> personDTOList = new ArrayList<>();
        List<Person> getPersonList = personRepository.findAll();

        getPersonList.forEach(person -> {
            List<Hobby> hobbies =  hobbyRepository.findByPersonId(person.getId());
            personDTOList.add(PersonDTO.builder().Id(person.getId())
                    .first_name(person.getFirstName())
                    .last_name(person.getLastName())
                    .age(person.getAge())
                    .favourite_colour(person.getFavourite_colour())
                    .hobby(getHobbies(hobbies)).build());
        });
        return DataDTO.builder().person(personDTOList).build();
    }

    @Override
    public ResponseEntity<DataDTO> create(DataDTO dataDTO) throws ConstraintsViolationException {
        if(!(dataDTO.getPerson().size() > 0)){
            throw new ConstraintsViolationException("Person data could not be empty" + dataDTO.getPerson());
        }
        upsertRecords(dataDTO);

        return new ResponseEntity<>(dataDTO, HttpStatus.CREATED);
    }

    @Override
    public DataDTO update(Long personId, DataDTO dataDTO) throws EntityNotFoundException {
       Person person = findPersonChecked(personId);
       dataDTO.getPerson().forEach(eachPr -> {
           person.setFirstName(eachPr.getFirst_name());
           person.setLastName(eachPr.getLast_name());
           person.setAge(eachPr.getAge());
           person.setFavourite_colour(eachPr.getFavourite_colour());
           person.setHobby(upsertHobby(eachPr.getHobby(), person));
       });
        personRepository.save(person);

        return dataDTO;
    }

    @Override
    public void delete(Long personId) throws EntityNotFoundException {
        Person person = findPersonChecked(personId);
        personRepository.delete(person);
    }

    private Person findPersonChecked(Long personId) throws EntityNotFoundException {
        return personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " +personId));
    }

    private void upsertRecords(DataDTO dataDTO) {
        personRepository.saveAll(upsertPerson(dataDTO));
    }

    private List<Person> upsertPerson(DataDTO dataDTO) {
        List<Person> personList = new ArrayList<>();
        dataDTO.getPerson().forEach(data -> {
            Person person = new Person();
            person.setFirstName(data.getFirst_name());
            person.setLastName(data.getLast_name());
            person.setAge(data.getAge());
            person.setFavourite_colour(data.getFavourite_colour());
            person.setHobby(upsertHobby(data.getHobby(), person));
            personList.add(person);
        });
        return personList;
    }

    private List<Hobby> upsertHobby(List<String> hobbyList, Person person) {
        List<Hobby> hobbies = new ArrayList<>();
        hobbyList.forEach(hb -> {
            Hobby hobby = new Hobby();
            hobby.setHobbyName(hb);
            hobby.setPerson(person);
            hobbies.add(hobby);
        });
        return hobbies;
    }

    private List<String> getHobbies(List<Hobby> hobbies) {
        List<String> hobbyDTOList = new ArrayList<>();
        hobbies.forEach(data -> {
            hobbyDTOList.add(data.getHobbyName());
        });
        return hobbyDTOList;
    }
}
