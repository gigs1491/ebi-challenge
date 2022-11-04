package com.ebi.dataaccessobject;

import com.ebi.domainobject.Hobby;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyRepository extends CrudRepository<Hobby, Long> {

    @Query(value = "SELECT * FROM HOBBY WHERE PERSON_ID = :personId", nativeQuery = true)
    List<Hobby> findByPersonId(@Param("personId") Long personId);

}
