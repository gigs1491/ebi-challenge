package com.ebi.service;

import com.ebi.datatransferobject.DataDTO;
import com.ebi.datatransferobject.PersonDTO;
import com.ebi.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;

import com.ebi.exception.ConstraintsViolationException;


public interface PersonService {

    DataDTO findAll();

    ResponseEntity<DataDTO> create(DataDTO dataDTO) throws ConstraintsViolationException;

    DataDTO update(Long personId, DataDTO dataDTO) throws EntityNotFoundException;

    void delete(Long personId) throws EntityNotFoundException;
}
