package com.ebi.controller;


import com.ebi.datatransferobject.DataDTO;
import com.ebi.exception.EntityNotFoundException;
import com.ebi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebi.exception.ConstraintsViolationException;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/listAll")
    public DataDTO getPersonList() {
        return personService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DataDTO> createPerson(@Valid @RequestBody DataDTO dataDTO) throws ConstraintsViolationException {
        return personService.create(dataDTO);
    }

    @PutMapping("/edit/{personId}")
    public DataDTO editPerson(@PathVariable Long personId, @RequestBody DataDTO dataDTO) throws EntityNotFoundException {
        return personService.update(personId, dataDTO);
    }

    @DeleteMapping("/remove/{personId}")
    public void deletePerson(@PathVariable Long personId) throws EntityNotFoundException {
        personService.delete(personId);
    }

}
