package com.ebi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataDTO {

    private List<PersonDTO> person;

    public DataDTO() {
    }

    public DataDTO(List<PersonDTO> person) {
        this.person = person;
    }


}
